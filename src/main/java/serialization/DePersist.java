package serialization;

/**
 * Created by suhane on 6/24/17.
 */
import java.io.*;
class DePersist{
    public static void main(String args[])throws Exception{
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));
        Student s=(Student)in.readObject();
        System.out.println((int) s.id+" "+s.name+" "+ s.age);
        in.close();
    }
}