import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

public class LinkedHashMap {

    HashMap<Integer, Node> hm= new HashMap<Integer, Node>();
    DLL dll= new DLL();


    public void printAllKeys(){

        dll.print();
    }


    public void put(int key, int value){

        if(!hm.containsKey(key)){
            Node node=dll.insert(key,value);
            hm.put(key,node);
        }
        else{
            //update

            Node node= hm.get(key);
            node.value=value;
        }
    }

    public int get(int key){

       return hm.get(key).value;
    }

    public void remove(int key){

        Node node=hm.get(key);
        dll.remove(node);
        hm.remove(key);

    }

}

class Node{

    Node next;
    Node prev;
    int data;
    int value;

    public Node(int data, int value){

        prev=next=null;
        this.data=data;
        this.value=value;
    }

}

class DLL{

    Node head;
    Node tail;


    public DLL(){
        head=null;
        tail=null;
    }



    public Node insert(int data,int val){

        Node aux= new Node(data,val);

        if(head==null){
            head=aux;
            tail=aux;
            return aux;
        }

        aux.prev=tail;
        tail.next=aux;
        tail=aux;
        return aux;


    }

    public void remove(Node node){

        if(head==node){
            head=head.next;
            return;
        }
        if(tail==node){
            Node newtail=tail.prev;
            tail=newtail;
            tail.next=null;
            return;
        }
        //if node is in somewhere in between

        Node prev= node.prev;
        Node next= node.next;
        prev.next=node.next;
        next.prev=prev;
        return;

    }


    public static void main(String s[]){

        LinkedHashMap map= new LinkedHashMap();
        map.put(0,10);
        map.put(1,20);
        map.put(2,30);
        map.put(3,40);
        map.remove(3);
        map.printAllKeys();


    }

    public void print() {

        Node current=head;
        while(current!=null){
            System.out.print(current.data+" ");
            current=current.next;

        }
        System.out.println();
    }
}
