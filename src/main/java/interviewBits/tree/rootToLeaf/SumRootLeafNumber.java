package interviewBits.tree.rootToLeaf;

import interviewBits.tree.TreeNode;

/**
 * Created by labuser on 8/1/17.
 */
public class SumRootLeafNumber {

    public static int sumNumbers(TreeNode a) {


        return sum(a,0);
    }

    private static int sum(TreeNode a, int prev) {
        if(a==null)
            return 0;
        if(a.left==null && a.right==null)
            return (prev*10+a.val)%1003;
        int leftsum=sum(a.left,(prev*10+a.val)%1003);
        int rightsum=sum(a.right,(prev*10+a.val)%1003);
        return (leftsum+rightsum)%1003;

    }

    public static void main(String args[]){

         /* Let us construct the tree shown in above diagram */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        //root.right.right = new TreeNode(7);
        /*
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(7);
        root.right.right.right.right = new TreeNode(7);
        root.right.right.right.right.right = new TreeNode(7);
        root.right.right.right.right.right.right = new TreeNode(7);
        */

        System.out.print(sumNumbers(root));
    }
}
