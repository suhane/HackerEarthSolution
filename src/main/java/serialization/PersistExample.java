package serialization;

/**
 * Created by suhane on 6/24/17.
 */
import java.io.*;
class PersistExample{
    public static void main(String args[])throws Exception{
        Student s1 =new Student(211,"ravi",22);//creating object
        //writing object into file
        FileOutputStream f=new FileOutputStream("f.txt");
        ObjectOutputStream out=new ObjectOutputStream(f);
        out.writeObject(s1);
        out.flush();

        out.close();
        f.close();
        System.out.println("success");
    }
}