package expedia;


import org.junit.Test;

class Node{

    int data;
    Node next;

    public Node(int data){
        this.data=data;
    }

    @Override
    public String toString() {
        return "["+this.data+",next="+(this.next==null?"null":this.next.data)+"]";
    }
}

public class LinkedList {

    public Node mergeSortedList(Node headA, Node headB){

        Node result=null;
        Node current=null;
        Node currA=headA;
        Node currB=headB;

        while(true){

            if(currA==null){
                if(result==null)
                    result=currB;
                else
                    current.next=currB;
                break;
            }

            if(currB==null){
                if(result==null)
                    result=currA;
                else
                    current.next=currA;
                break;
            }

            if(currA.data<=currB.data){
                if(result==null){
                    result=currA;
                    current=result;
                }

                else {
                    current.next = currA;
                    current=current.next;
                }
                currA=currA.next;
            }
            else {

                if(result==null){
                    result=currB;
                    current=result;
                }
                else {
                    current.next = currB;
                    current=current.next;
                }
                currB=currB.next;
            }

        }
        return result;

    }


    public Node merge(Node headA, Node headB){

        if(headA==null)
            return headB;
        if(headB==null)
            return headA;
        if(headA.data<=headB.data){
            headA.next= merge(headA.next,headB);
            return headA;
        }
        else{
            headB.next=merge(headA,headB.next);
            return headB;
        }

    }


    @Test
    public void test(){
        Node headA=new Node(1);
        headA.next=new Node(5);
        headA.next.next=new Node(10);

        Node headB=new Node(2);
        headB.next=new Node(4);
        headB.next.next=new Node(6);

        Node res=mergeSortedList(headA,headB);
        printList(res);

    }

    @Test
    public void test2(){
        Node headA=new Node(1);
        headA.next=new Node(5);
        headA.next.next=new Node(10);

        Node headB=new Node(2);
        headB.next=new Node(4);
        headB.next.next=new Node(6);

        Node res=merge(headA,headB);
        printList(res);

    }

    private void printList(Node res) {
        while (res!=null){
            System.out.print(res.data+" ");
            res=res.next;
        }
        System.out.println();
    }

}
