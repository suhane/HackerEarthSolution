package interviewBits.graphs;

//
 // Definition for binary tree
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

 class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

public class SortedListToBalancedBinaryTree {

    public TreeNode sortedListToBST(ListNode a) {

        int nodeCount=countList(a);
        return null;
    }

    private int countList(ListNode a) {

        int c=0;
        while(a!=null){
            a=a.next;
            c++;
        }
        return c;
    }
}
