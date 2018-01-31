package treesOneOnOne.geeksforgeeks.basic;

import org.junit.Test;
import treesOneOnOne.TreeNode;

public class HeightOfBinaryTree {

    int height(TreeNode node)
    {
        if(node==null)
            return 0;
        return 1+ Math.max(height(node.left),height(node.right));
    }

    @Test
    public void test(){
        TreeNode root= new TreeNode(1);
        root.left=new TreeNode(1);
        root.left.right=new TreeNode(1);
        root.left.right.left=new TreeNode(1);
        root.left.right.left.right=new TreeNode(1);
        root.left.right.left.right.left=new TreeNode(1);
        root.left.right.left.right.left.right=new TreeNode(1);
        root.left.right.left.right.left.right.left=new TreeNode(1);
        root.left.right.left.right.left.right.left.right=new TreeNode(1);

        root.right=new TreeNode(1);
        root.right.right=new TreeNode(1);
        root.right.right.left=new TreeNode(1);
        root.right.right.left.right=new TreeNode(1);
        root.right.right.left.right.left=new TreeNode(1);
        root.right.right.left.right.left.right=new TreeNode(1);
        root.right.right.left.right.left.right.left=new TreeNode(1);
        root.right.right.left.right.left.right.left.right=new TreeNode(1);
        root.right.right.left.right.left.right.left.right.left=new TreeNode(1);
        System.out.println(height(root));

    }
}
