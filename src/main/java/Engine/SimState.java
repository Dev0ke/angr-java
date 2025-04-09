package Engine;

import com.microsoft.z3.Expr;
import soot.jimple.*;
import java.util.*;
import soot.*;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalUnitGraph;
import utils.Log;

public class SimState {
        public List<Expr> symbol;
        public Map<Value, Expr> curLocalMap;
        public ExceptionalUnitGraph curCFG;
        public List<Expr> constraints;
        
        public Map<String, Integer> instCount;
        public Map<String, Expr> staticFieldMap;

        // stack
        public List<List<Expr>> paramList;
        public Stack<Unit> callStack;
        public Stack<Map<Value, Expr>> saveLocalMaps;
        public Stack<ExceptionalUnitGraph> cfgStack;

        public SimState() {
            this.curLocalMap = new HashMap<>();
            this.constraints = new ArrayList<Expr>();
            this.symbol = new ArrayList<>();
            this.callStack = new Stack<>();
            this.cfgStack = new Stack<>();
            this.paramList = new ArrayList<>();
            this.instCount = new HashMap<>();
            this.staticFieldMap = new HashMap<>();
            this.saveLocalMaps = new Stack<>();
            this.curCFG = null;
        }

        // TODO FIX HASH COLLISION
        public int addInstCount(Unit u) {
            String unitKey = u.toString();
            int count;
            if (this.instCount.containsKey(unitKey)) {
                count = this.instCount.get(unitKey) + 1;
                this.instCount.put(unitKey, count);
            } else {
                this.instCount.put(unitKey, 1);
                count = 1;
            }
            return count;
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

        public void pushParam(List<Expr> params) {
            this.paramList.add(params);
        }

        public List<Expr> getLastParam() {
            return this.paramList.get(this.paramList.size() - 1);
        }

        public Expr getParam(int index) {
            if (this.paramList.isEmpty())
                return null;
            List<Expr> exprs = this.paramList.get(this.paramList.size() - 1);
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
            this.saveLocalMaps.push(this.curLocalMap);
            this.curLocalMap = new HashMap<>();
        }

        public void popLocalMap() {
            this.curLocalMap = this.saveLocalMaps.pop();
            if (this.curLocalMap == null) {
                this.curLocalMap = new HashMap<>();
                Log.error("[-] LocalMap is null");
            }
        }

        public void addConstraint(Expr c) {
            this.constraints.add(c);
        }
        public Expr popConstraint() {
            return this.constraints.remove(this.constraints.size() - 1);
        }


        public void addSymbol(Expr s) {
            this.symbol.add(s);
        }

        public Expr getSymbolByName(String name) {
            for (Expr s : this.symbol) {
                if (s.toString().equals(name)) {
                    return s;
                }
            }
            return null;
        }

        public Expr getLastSymbol() {
            return this.symbol.get(this.symbol.size() - 1);
        }

        public void addStaticField(StaticFieldRef s, Expr e) {
            String className = s.getField().getDeclaringClass().getName();
            String fieldName = s.getField().getName();
            this.staticFieldMap.put(className + "#" + fieldName, e);
        }

        public Expr getStaticExpr(StaticFieldRef s) {
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

        public Expr getExpr(Value l) {
            Expr r = (Expr) this.curLocalMap.get(l);
            return r;
        }

        public void addExpr(Value l, Expr e) {
            if (e == null) {
                throw new IllegalArgumentException("Not valid");
            }
            this.curLocalMap.put(l, e);
        }

        // TODO 处理深拷贝
        public void copyTo(SimState dest) {
            dest.curCFG = this.curCFG;    
            dest.curLocalMap.putAll(this.curLocalMap);
            dest.constraints.addAll(this.constraints);
            dest.symbol.addAll(this.symbol);

            dest.instCount.putAll(this.instCount);
            dest.staticFieldMap.putAll(this.staticFieldMap);

            // stack
            dest.callStack.addAll(this.callStack);
            dest.paramList.addAll(this.paramList);
            dest.saveLocalMaps.addAll(this.saveLocalMaps);
            dest.cfgStack.addAll(this.cfgStack);
        }

        public SimState copy() {
            SimState copy = new SimState();
            this.copyTo(copy);
            return copy;
        }

        public void clear() {
            this.curLocalMap.clear();
            this.constraints.clear();
            this.symbol.clear();
            this.callStack.clear();
            this.cfgStack.clear();
            this.paramList.clear();
            this.instCount.clear();
            this.staticFieldMap.clear();
            this.saveLocalMaps.clear();
        }

}


