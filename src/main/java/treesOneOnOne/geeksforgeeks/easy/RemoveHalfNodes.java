package treesOneOnOne.geeksforgeeks.easy;

import org.junit.Test;
import treesOneOnOne.TreeNode;

public class RemoveHalfNodes {

    public TreeNode removeHalfNodes(TreeNode root){
        if(root==null)
            return null;
        if(root.left==null && root.right==null)
            return root;
        if(root.right==null)
            return removeHalfNodes(root.left);
        if(root.left==null)
            return removeHalfNodes(root.right);
        root.left=removeHalfNodes(root.left);
        root.right=removeHalfNodes(root.right);
        return root;

    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(11);
        root.right.right = new TreeNode(9);
        root.right.right.left = new TreeNode(4);
        removeHalfNodes(root);
    }
}
