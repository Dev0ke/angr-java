package Engine;

import java.util.ArrayList;
import java.util.List;
import com.microsoft.z3.*;
public class SymList extends SymObject {

    public List<SymObject> value;
    public SymList(){
    }

    public SymObject get(int index){
        return value.get(index);
    }

    public void add(SymObject obj){
        isNull = false;
        if(value == null){
            value = new ArrayList<>();
        }
        value.add(obj);
    }










    

    
}
