package Engine;

import com.microsoft.z3.Expr;
import soot.jimple.*;
import soot.jimple.internal.JIfStmt;
import soot.jimple.internal.JLookupSwitchStmt;
import soot.jimple.internal.JTableSwitchStmt;

import java.util.*;
import soot.*;
import soot.toolkits.graph.ExceptionalUnitGraph;
import utils.Log;


public class SimState {
        public List<SymBase> symbol;
        public Map<Value, SymBase> curLocalMap;
        public Map<Value, SymBase> objectMap;
        public ExceptionalUnitGraph curCFG;
        public List<Expr> globalConstraints;
        public List<Expr> localConstraints;
        public boolean isClear = false;

        public int callDepth;
        public Map<Integer, List<Integer>> instCount;
        public Map<String, SymBase> staticFieldMap;
        public HashMap<Integer, Integer> visitedMethods;

        // stack
        public List<List<SymBase>> paramList;

        public Stack<Unit> callStack;
        public Stack<Map<Value, SymBase>> LocalMapsStack;
        public Stack<List<Expr>> localConstraintsStack;
        public Stack<ExceptionalUnitGraph> cfgStack;

        public SimState() {
            this.curLocalMap = new HashMap<>();
            this.globalConstraints = new ArrayList<Expr>();
            this.localConstraints = new ArrayList<Expr>();
            this.symbol = new ArrayList<>();


            this.paramList = new ArrayList<>();
            this.instCount = new HashMap<>();
            this.staticFieldMap = new HashMap<>();

            this.visitedMethods = new HashMap<>();
            this.objectMap = new HashMap<>();
            this.curCFG = null;
            this.callDepth = 0;


            // stack
            this.LocalMapsStack = new Stack<>();
            this.localConstraintsStack = new Stack<>();
            this.callStack = new Stack<>();
            this.cfgStack = new Stack<>();
        }


        public void addVisitedMethod(SootMethod method) {
            int methodHash = genMethodHash(method);
            if(this.visitedMethods.containsKey(methodHash)){
                this.visitedMethods.put(methodHash, this.visitedMethods.get(methodHash) + 1);
            }else{
                this.visitedMethods.put(methodHash, 1);
            }
        }

        public int getVisitedMethodCount(SootMethod method) {
            int methodHash = genMethodHash(method);
            return this.visitedMethods.getOrDefault(methodHash, 0);
        }

        public static int genMethodHash(SootMethod method) {
            String className = method.getDeclaringClass().getName();
            String methodName = method.getName();
            String methodSignature = method.getSignature();
            return (className + methodName + methodSignature).hashCode();
        }
        


        public void addObject(Value v, SymBase e) {
            this.objectMap.put(v, e);
        }

        public SymBase getObject(Value v) {
            return this.objectMap.get(v);
        }

        public void removeObject(SymBase v) {
            this.objectMap.remove(v);
        }

        public void setClear(boolean isClear) {
            this.isClear = isClear;
        }

        public boolean isClear() {
            return this.isClear;
        }
        
        
        // TODO FIX HASH COLLISION
        public int addBranchCount(Unit u, int branchIdx) {
            int unitKey = this.getUnitKey(u);
            List<Integer> branchCountList =  this.instCount.get(unitKey);
            int count;
            if (branchCountList == null){
                branchCountList = createBranchCount(u);
                this.instCount.put(unitKey, branchCountList);
            }
            count = branchCountList.get(branchIdx);
            branchCountList.set(branchIdx, count + 1);
            return count;
        }

        public int getUnitKey(Unit u){
            String className = this.curCFG.getBody().getMethod().getDeclaringClass().getName();
            String methodName = this.curCFG.getBody().getMethod().getName();
            String unitKey = className + methodName + u.toString();;
            return unitKey.hashCode();
        }

        public int getBranchCount(Unit u, int branchIdx){
            int unitKey = this.getUnitKey(u);
            List<Integer> branchCountList =  this.instCount.get(unitKey);
            if (branchCountList == null){
                branchCountList = createBranchCount(u);
                this.instCount.put(unitKey, branchCountList);
            }
            return branchCountList.get(branchIdx);
        }

        public static List<Integer> createBranchCount(Unit unit){
            List<Integer> branchCountList;
            int size;
            if(unit instanceof JIfStmt){
                size = 2;
            } else if(unit instanceof JLookupSwitchStmt lookupSwitchStmt){
                size = lookupSwitchStmt.getLookupValues().size() + 1;
            } else if(unit instanceof JTableSwitchStmt tableSwitchStmt){
                size = tableSwitchStmt.getHighIndex() - tableSwitchStmt.getLowIndex() + 1 + 1;
            }  else{ // TODO fix exception?
                Log.error("Unsupported unit type: " + unit.getClass());
                return null;
            }
            branchCountList = new ArrayList<>(Collections.nCopies(size, 0));
            return branchCountList;
        } 


        public int getBranchDepth() {
            return instCount.size();
        }

        
        public void pushCall(Unit u) {
            this.callStack.push(u);
        }

        public Unit popCall() {
            return this.callStack.pop();
        }

        public boolean isCallStackEmpty() {
            return this.callStack.isEmpty();
        }


        public ExceptionalUnitGraph getCurCFG(){
            return this.curCFG;
        }

        public void setCurCFG(ExceptionalUnitGraph cfg){
            this.curCFG = cfg;
        }

        public void pushCFG() {
            this.cfgStack.push(this.curCFG);
            this.curCFG = null;
        }

        public ExceptionalUnitGraph popCFG() {
            this.curCFG = this.cfgStack.pop();
            return this.curCFG;
        }

        public boolean isCFGstackEmpty() {
            return this.cfgStack.isEmpty();
        }

        public void pushParam(List<SymBase> params) {
            this.paramList.add(params);
        }

        public List<SymBase> getLastParam() {
            return this.paramList.get(this.paramList.size() - 1);
        }

        public SymBase getParam(int index) {
            if (this.paramList.isEmpty())
                return null;
            List<SymBase> exprs = this.paramList.get(this.paramList.size() - 1);
            if (index < exprs.size())
                return exprs.get(index);
            return null;
        }
        
 

        public void popParam() {
            this.paramList.remove(this.paramList.size() - 1);
        }

        public boolean isParamEmpty() {
            return this.paramList.isEmpty();
        }

        public void pushLocalMap() {
            this.LocalMapsStack.push(this.curLocalMap);
            this.curLocalMap = new HashMap<>();
        }

        public void popLocalMap() {
            this.curLocalMap = this.LocalMapsStack.pop();
            if (this.curLocalMap == null) {
                this.curLocalMap = new HashMap<>();
                Log.error("[-] LocalMap is null");
            }
        }

        public void pushLocalConstraints() {
            this.localConstraintsStack.push(this.localConstraints);
            this.localConstraints = new ArrayList<Expr>();
        }

        public void popLocalConstraints() {
            this.localConstraints = this.localConstraintsStack.pop();
        }

        public void addGlobalConstraint(Expr c) {
            this.globalConstraints.add(c);
        }
        public Expr popGlobalConstraint() {
            return this.globalConstraints.remove(this.globalConstraints.size() - 1);
        }
        

        public void addLocalConstraint(Expr c) {
            this.localConstraints.add(c);
        }

        public Expr popLocalConstraint() {
            return this.localConstraints.remove(this.localConstraints.size() - 1);
        }

        public List<Expr> getLocalConstraints() {
            return this.localConstraints;
        }

        public List<Expr> getGlobalConstraints() {
            return this.globalConstraints;
        }

        public List<Expr> getFullConstraints() {
            List<Expr> constraints = new ArrayList<>();
            constraints.addAll(this.localConstraints);
            constraints.addAll(this.globalConstraints);
            return constraints;
        }

        public void addSymbol(SymBase s) {
            this.symbol.add(s);
        }

        public SymBase getSymbolByName(String name) {
            for (SymBase s : this.symbol) {
                if (s.getName().equals(name)) {
                    return s;
                }
            }
            return null;
        }

        public SymBase getLastSymbol() {
            return this.symbol.get(this.symbol.size() - 1);
        }

        public void addStaticField(StaticFieldRef s, SymBase e) {
            String className = s.getField().getDeclaringClass().getName();
            String fieldName = s.getField().getName();
            this.staticFieldMap.put(className + "#" + fieldName, e);
        }

        public SymBase getStaticExpr(StaticFieldRef s) {
            String className = s.getField().getDeclaringClass().getName();
            String fieldName = s.getField().getName();
            return this.staticFieldMap.get(className + "#" + fieldName);
        }

        public void removeLocal(Value l) {
            this.curLocalMap.remove(l);
        }

        public void removeAllLocal() {
            this.curLocalMap.clear();
        }

        public SymBase getLocalSym(Value l) {
            SymBase r = this.curLocalMap.get(l);
            return r;
        }

        public void addLocalSym(Value l, SymBase e) {
            if (e == null) {
                return;
            }
            this.curLocalMap.put(l, e);
        }

        // TODO 处理深拷贝
        public void copyTo(SimState dest) {
            // 保持CFG的浅拷贝（通常是共享的）
            dest.curCFG = this.curCFG;    
            dest.isClear = this.isClear;
            
            // 深拷贝curLocalMap
            dest.curLocalMap.clear();
            for (Map.Entry<Value, SymBase> entry : this.curLocalMap.entrySet()) {
                dest.curLocalMap.put(entry.getKey(), entry.getValue());
            }
            
            // 深拷贝objectMap
            dest.objectMap.clear();
            for (Map.Entry<Value, SymBase> entry : this.objectMap.entrySet()) {
                dest.objectMap.put(entry.getKey(), entry.getValue());
            }
            
            // 深拷贝globalConstraints
            dest.globalConstraints.clear();
            dest.globalConstraints.addAll(this.globalConstraints);
            
            // 深拷贝localConstraints
            dest.localConstraints.clear();
            dest.localConstraints.addAll(this.localConstraints);
            
            // 深拷贝symbol
            dest.symbol.clear();
            dest.symbol.addAll(this.symbol);

            // 深拷贝instCount - Map<Unit, List<Integer>>
            dest.instCount.clear();
            for (Map.Entry<Integer, List<Integer>> entry : this.instCount.entrySet()) {
                List<Integer> copyList = new ArrayList<>(entry.getValue());
                dest.instCount.put(entry.getKey(), copyList);
            }
            
            // 深拷贝staticFieldMap
            dest.staticFieldMap.clear();
            for (Map.Entry<String, SymBase> entry : this.staticFieldMap.entrySet()) {
                dest.staticFieldMap.put(entry.getKey(), entry.getValue());
            }

            // 深拷贝callStack
            dest.callStack.clear();
            dest.callStack.addAll(this.callStack);
            
            // 深拷贝LocalMapsStack - Stack<Map<Value, SymBase>>
            dest.LocalMapsStack.clear();
            for (Map<Value, SymBase> map : this.LocalMapsStack) {
                Map<Value, SymBase> copyMap = new HashMap<>();
                for (Map.Entry<Value, SymBase> entry : map.entrySet()) {
                    copyMap.put(entry.getKey(), entry.getValue());
                }
                dest.LocalMapsStack.add(copyMap);
            }
            
            // 深拷贝localConstraintsStack - Stack<List<Expr>>
            dest.localConstraintsStack.clear();
            for (List<Expr> list : this.localConstraintsStack) {
                List<Expr> copyList = new ArrayList<>(list);
                dest.localConstraintsStack.add(copyList);
            }
            
            // 深拷贝cfgStack
            dest.cfgStack.clear();
            dest.cfgStack.addAll(this.cfgStack);

            // 深拷贝paramList - List<List<SymBase>>
            dest.paramList.clear();
            for (List<SymBase> list : this.paramList) {
                List<SymBase> copyList = new ArrayList<>(list);
                dest.paramList.add(copyList);
            }
            
            // 深拷贝visitedMethods
            dest.visitedMethods.clear();
            for (Map.Entry<Integer, Integer> entry : this.visitedMethods.entrySet()) {
                dest.visitedMethods.put(entry.getKey(), entry.getValue());
            }
            
            // callDepth是基本类型，直接赋值
            dest.callDepth = this.callDepth;
        }

        public SimState copy() {
            SimState copy = new SimState();
            this.copyTo(copy);
            return copy;
        }

        public void clear() {
            this.curLocalMap.clear();
            this.globalConstraints.clear();
            this.localConstraints.clear();
            this.symbol.clear();
            this.callStack.clear();
            this.cfgStack.clear();
            this.paramList.clear();
            this.instCount.clear();
            this.staticFieldMap.clear();
            this.LocalMapsStack.clear();
            this.visitedMethods.clear();
            this.objectMap.clear();
        }

}


