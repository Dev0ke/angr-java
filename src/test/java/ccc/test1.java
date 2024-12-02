import static accessControl.CheckPermissionAPI.PERMISSION_GRANTED;

class testCheckAPI {
     public static final int PERMISSION_GRANTED = 0;
     public static final int PERMISSION_DENIED = 1;
     public static final int PERMISSION_HARD_DENIED = 2;
     public static final int PERMISSION_SOFT_DENIED = 3;
    public void enforceP1(String Permission){
        return;
    }
    public int checkP2(String Permission){
        if(Permission.equals("com.test.ppp")){
            return 1;
        }
        return 0;
    }


}

public class test1 {
    public testCheckAPI ctx = new testCheckAPI();

    public void main() {
        try{
            check1();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    public void check1() throws Exception {
        testCheckAPI context = new testCheckAPI();
        context.enforceP1("android.permission.TEST1");
        if(context.checkP2("android.permission.TEST2") == PERMISSION_GRANTED){
            return;
        }
        else{
            //raise exception
            throw new Exception("Permission denied");
        }
    }

    // or
    public void check2() throws Exception {
        if(ctx.checkP2("android.permission.TEST1") == PERMISSION_GRANTED || ctx.checkP2("android.permission.TEST2") == PERMISSION_GRANTED){
            return;
        }
        else{
            //raise exception
            throw new Exception("Permission denied");
        }

    }
    // and
    public void check21() throws Exception {
        int a = ctx.checkP2("android.permission.TEST1");
        int b = ctx.checkP2("android.permission.TEST2");
        if(b == PERMISSION_GRANTED && a == PERMISSION_GRANTED){
            return;
        }
        else{
            //raise exception
            throw new Exception("Permission denied");
        }

    }
    // warp1
    public void check3() throws Exception {
        checkWarpper1();
    }

    public void checkWarpper1()  throws Exception{
        if(ctx.checkP2("android.permission.TEST1") == PERMISSION_GRANTED
                || ctx.checkP2("android.permission.TEST2") == PERMISSION_GRANTED){
            return;
        }
        else{
            //raise exception
            throw new Exception("Permission denied");
        }

    }
    public int cc(int c){
        return c+1;
    }
    public void ss(int a){
        int b = a;
        int r = cc(b);
        int d = r+3;


    }

    // warp2
    public void check4() throws Exception {
        if(checkWarpper2()){
            return;
        }
        else{
            //raise exception
            throw new Exception("Permission denied");
        }
    }
    public boolean checkWarpper2() {
        return  ctx.checkP2("PW222") == PERMISSION_GRANTED;
    }


    // fake check
    public void check5() {
        int a = ctx.checkP2("P555");
        if(a == PERMISSION_GRANTED){
            return;
        }
        else{
            return;
        }
    }


    public void check8() throws Exception {
        int r = ctx.checkP2("P888");
        switch (r){
            case testCheckAPI.PERMISSION_GRANTED:
                return;
            case testCheckAPI.PERMISSION_DENIED:
                return;
            case testCheckAPI.PERMISSION_HARD_DENIED:
                return;
            case testCheckAPI.PERMISSION_SOFT_DENIED:
                return;


            default:
                throw new Exception("Permission denied");
        }
    }


    // more Perminsion
    public void check6(int a) throws Exception {
        String b = "android.permission.TEST1";
        if(a>0){
            b = "android.permission.TEST2";
        }
        if(ctx.checkP2(b) == PERMISSION_GRANTED){
            return;
        }
        else{
            throw new Exception("Permission denied");
        }

    }


    // doThrow
    public  void check7() throws Exception {
        if(ctx.checkP2("android.permission.TEST1") == PERMISSION_GRANTED){
            return;
        }
        else{
            doThrow();
        }
    }
    public void doThrow() throws Exception {

        throw new Exception("Permission denied");

    }




}
