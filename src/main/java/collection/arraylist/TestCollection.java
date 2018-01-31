package collection.arraylist;

/**
 * Created by suhane on 6/26/17.
 */

import java.util.*;
public class TestCollection {
    public static void main(String args[]){
        ArrayList<String> list=new ArrayList<String>();//Creating arraylist
        list.add("Ravi");//Adding object in arraylist
        list.add("Vijay");
        list.add("Ravi");
        list.add("Ajay");
        //Traversing list through Iterator
        Iterator itr=list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }


        List<String> lst = new ArrayList<String>();
        lst.add("alpha");
        lst.add("beta");
        lst.add("charlie");
        System.out.println(lst);   // [alpha, beta, charlie]

        for (String str : lst) {
            str += "change!";   // cannot modify "immutable" objects
        }
        System.out.println(lst);   // [alpha, beta, charlie]


    }
}
