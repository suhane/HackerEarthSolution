package expedia;

public class DetectAndRemoveLoop {

   public boolean detectAndRemoveLoop(Node head) {
        Node slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet at same point then loop is present
            if (slow == fast) {
                removeLoop(slow, head);
                return true;
            }
        }
        return false;
    }

    private void removeLoop(Node loop_node, Node head) {



    }
}
