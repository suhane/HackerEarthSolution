package serialization;

import java.io.Serializable;

/**
 * Created by suhane on 6/24/17.
 */
public class Student implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 122751305466249507L;
	long id;
    String name;
    transient int age;//Now it will not be serialized
    public Student(int id, String name,int age) {
        this.id = id;
        this.name = name;
        this.age=age;
    }
}