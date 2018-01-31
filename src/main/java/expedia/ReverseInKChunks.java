package expedia;

public class ReverseInKChunks {

    public Node reverseInChunks(Node head, int k){

        Node curr=head;
        Node prev=null;
        Node next=null;

        int count=0;
        while(count<k || curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;

        }

        if(next!=null)
            reverseInChunks(curr.next,k);
        return prev;

    }
}
