package Engine;

import com.microsoft.z3.Expr;
import soot.jimple.*;
import java.util.*;
import soot.*;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.graph.ExceptionalUnitGraph;
import utils.Log;

public class SimState {
        public Set<Expr> symbol;
        public Map<Value, Expr> localMap;
        public List<Expr> constraints;
        public Stack<Unit> callStack;
        public Stack<ExceptionalUnitGraph> cfgStack;
        public List<List<Expr>> paramList;
        // public Map<SootClass,Map<Value,Expr>> staticMaps;
        public Map<String, Integer> instCount;
        public Map<String, Expr> staticFieldMap;
        public Stack<Map<Value, Expr>> saveLocalMaps;

        public SimState() {
            this.localMap = new HashMap<>();
            this.constraints = new ArrayList<Expr>();
            this.symbol = new HashSet<>();
            this.callStack = new Stack<>();
            this.cfgStack = new Stack<>();
            this.paramList = new ArrayList<>();
            this.instCount = new HashMap<>();
            this.staticFieldMap = new HashMap<>();
            this.saveLocalMaps = new Stack<>();
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

        public void pushCFG(ExceptionalUnitGraph cfg) {
            this.cfgStack.push(cfg);
        }

        public ExceptionalUnitGraph popCFG() {
            return this.cfgStack.pop();
        }

        public boolean isCFGstackEmpty() {
            return this.cfgStack.isEmpty();
        }

        public void pushParam(List<Expr> params) {
            this.paramList.add(params);
        }

        public List<Expr> getParam() {
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
            this.saveLocalMaps.push(this.localMap);
            this.localMap = new HashMap<>();
        }

        public void popLocalMap() {
            this.localMap = this.saveLocalMaps.pop();
            if (this.localMap == null) {
                this.localMap = new HashMap<>();
                Log.error("[-] LocalMap is null");
            }
        }

        public void addConstraint(Expr c) {
            this.constraints.add(c);
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
            this.localMap.remove(l);
        }

        public void removeAllLocal() {
            this.localMap.clear();
        }

        public Expr getExpr(Value l) {
            Expr r = (Expr) this.localMap.get(l);
            return r;
        }

        public void addExpr(Value l, Expr e) {
            if (e == null) {
                throw new IllegalArgumentException("Not valid");
            }
            this.localMap.put(l, e);
        }

        // TODO 处理深拷贝
        public void copyTo(SimState dest) {
            dest.localMap.putAll(this.localMap);
            dest.constraints.addAll(this.constraints);
            dest.symbol.addAll(this.symbol);
            dest.callStack.addAll(this.callStack);
            dest.cfgStack.addAll(this.cfgStack);
            dest.paramList.addAll(this.paramList);
            dest.instCount.putAll(this.instCount);
            dest.staticFieldMap.putAll(this.staticFieldMap);
            dest.saveLocalMaps.addAll(this.saveLocalMaps);
        }

        public SimState copy() {
            SimState copy = new SimState();
            this.copyTo(copy);
            return copy;
        }

        public void clear() {
            this.localMap.clear();
            this.constraints.clear();
        }

}


