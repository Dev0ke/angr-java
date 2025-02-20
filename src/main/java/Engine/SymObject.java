package Engine;

public class SymObject {
    public Boolean isNull;
    

    public SymObject(){
        isNull = true;
    }


    public void setNull(boolean value) {
        isNull = value;
    }

    public boolean isNull() {
        return isNull;
    }
}
