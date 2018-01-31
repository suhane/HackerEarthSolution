package expedia;

import org.junit.Test;

public class LinkListReverse {

    public Node reverseIterative(Node head){


        Node prev =null;
        Node curr=head;
        while(curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        return prev;

    }

    public Node reverseRecursive(Node head){


        if(head==null)
            return null;

        Node first=head;
        if(first.next==null)
            return first;
        Node rest=reverseRecursive(head.next);
        first.next.next=first;
        first.next=null;
        return rest;

    }

    private void printList(Node res) {
        while (res!=null){
            System.out.print(res.data+" ");
            res=res.next;
        }
        System.out.println();
    }

    @Test
    public void test(){
        Node headA=new Node(1);
        headA.next=new Node(5);
        headA.next.next=new Node(10);
        headA.next.next.next=new Node(12);
        headA.next.next.next.next=new Node(13);
        Node rev=reverseIterative(headA);
        printList(rev);

    }

    @Test
    public void test2(){
        Node headA=new Node(1);
        headA.next=new Node(5);
        headA.next.next=new Node(10);
        headA.next.next.next=new Node(12);
        headA.next.next.next.next=new Node(13);
        Node rev=reverseRecursive(headA);
        printList(rev);

    }
}
