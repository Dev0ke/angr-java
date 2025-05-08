package module;
import accessControl.*;

import init.Config;
import init.StaticAPIs;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.microsoft.z3.*;
import com.microsoft.z3.Context;
import com.microsoft.z3.Expr;

import Engine.Expression;
import Engine.SimState;
import Engine.SymbolSolver;
import soot.*;
import soot.jimple.*;
import soot.jimple.internal.*;
import soot.jimple.toolkits.ide.icfg.OnTheFlyJimpleBasedICFG;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
import soot.util.Chain;
import utils.Log;




public class StateManager {

    public Map<Unit, List<SimState>> stateMap;


    
    public class StateCache {
        public Map<String, Set<String>> symbolMap;
        public List<String> callStack;
    
        public boolean isCallStackEqual(List<String> callStack) {
            if (this.callStack.size() != callStack.size()) {
                return false;
            }
            for (int i = 0; i < this.callStack.size(); i++) {
                if (!this.callStack.get(i).equals(callStack.get(i))) {
                    return false;
                }
            }
            return true;
        }
    
    
        public boolean isSymbolMapEqual(Map<String, List<String>> symbolMap) {
            if (this.symbolMap.size() != symbolMap.size()) {
                return false;
            }
            for (String key : this.symbolMap.keySet()) {
                if (!this.symbolMap.get(key).equals(symbolMap.get(key))) {
                    return false;
                }
            }
            return true;
        }
    
        public StateCache() {
            this.symbolMap = new java.util.HashMap<>();
            this.callStack = new java.util.ArrayList<>();
        }
          
    }
}
