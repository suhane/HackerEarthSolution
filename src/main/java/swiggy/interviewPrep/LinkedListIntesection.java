package swiggy.interviewPrep;

import org.junit.Test;

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data=data;
        this.next=null;
    }

    public boolean equals(Node that) {

        if(that==null)
            return false;

        if(this.next==null || that.next==null)
            return this.data==that.data;

        return this.data==that.data && this.next.equals(that.next);
    }

}

public class LinkedListIntesection {

    public Node mergePoint(Node headA, Node headB){

        int countA=calculateLength(headA);
        int countB=calculateLength(headB);

        Node currentA=headA;
        Node currentB=headB;

        if(countA>countB){
            int move=0;
            while(move<countA-countB){
                currentA=currentA.next;
                move++;

            }
        }

        if(countB>countA){
            int move=0;
            while(move<countB-countA){
                currentB=currentB.next;
                move++;

            }
        }

        while (currentA!=null || currentB!=null){

            if(currentB.equals(currentA))
                return currentB;
            currentA=currentA.next;
            currentB=currentB.next;
        }

        return null;


    }

    private int calculateLength(Node headA) {
        Node current=headA;
        int count=0;
        while (current!=null){
            count++;
            current=current.next;
        }
        return count;

    }

    @Test
    public void test(){
        Node l1=new Node(3);
        Node l2=new Node(10);
        l1.next=new Node(6);
        l1.next.next=new Node(9);
        l1.next.next.next=new Node(15);
        l1.next.next.next.next=new Node(30);
        l2.next=new Node(15);
        l2.next.next=new Node(30);
        System.out.println(mergePoint(l1,l2).data);
    }
}
