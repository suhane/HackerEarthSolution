package interviewBits.tree.ops;

import interviewBits.tree.TreeNode;

/**
 * Created by labuser on 7/31/17.
 */
public class BalancedBinaryTree {


    public static int isBalanced(TreeNode a) {
        if(a.left==null && a.right==null)
            return 1;
        if((a.left==null && a.right!=null && a.right.left==null && a.right.left==null) ||
                (a.right==null && a.left!=null && a.left.right==null && a.left.left==null))
            return 1;

        if((a.left==null && a.right!=null && (a.right.left!=null|| a.right.left!=null)) ||
                (a.right==null && a.left!=null && (a.left.right!=null || a.left.left!=null)))
            return 0;

        return isBalanced(a.left) & isBalanced(a.right);

    }




}
