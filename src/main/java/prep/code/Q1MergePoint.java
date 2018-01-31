package prep.code;
/*
There are two singly linked lists in a system.
By some programming error the end node of one of the linked list got linked into the second list, forming a inverted Y shaped list.
Write a program to get the point where two linked list merge.
 */
class Node{

    int data;
    Node next;

    Node(int data){
        this.data=data;
        next=null;
    }

}

public class Q1MergePoint {

    public static Node findMergePoint(Node head1, Node head2){

        Node current1=head1;
        Node current2=head2;

        int length1=computeLength(head1);
        int length2=computeLength(head2);
        if(length1>length2){
            int crawl=0;
            while(crawl<length1-length2){
                current1=current1.next;
                crawl++;
            }
        }
        if(length2>length1){
            int crawl=0;
            while(crawl<length2-length1){
                current2=current2.next;
                crawl++;
            }
        }
        while (current1 != null && current2 != null) {
            if (current1.data == current2.data) {
                return current1;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return null;



    }

    private static int computeLength(Node head) {
        Node current=head;
        int len=0;
        while(current!=null){
            current=current.next;
            len++;
        }
        return len;
    }
}
