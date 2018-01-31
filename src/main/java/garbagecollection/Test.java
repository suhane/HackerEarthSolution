package garbagecollection;

public class Test {
    private String str;
    Test(String str){
        this.str=str;
    }

    public static void main(String args[]){
        Test t1= new Test("t1");
        Test t2= m1(t1);
        Test t3= new Test("t3");
        t2=t3;
        System.gc();
    }

    private static Test m1(Test t1) {
        t1= new Test("insideFunction");
        return t1;
    }

    @Override protected void  finalize(){
        System.out.println("Destroying "+ this.str );
    }


}
