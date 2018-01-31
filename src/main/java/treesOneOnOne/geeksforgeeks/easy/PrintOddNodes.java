package treesOneOnOne.geeksforgeeks.easy;

import org.junit.Test;
import treesOneOnOne.TreeNode;

public class PrintOddNodes {

    public void printOddNodes(TreeNode root){

        printOddNodesUtil(root,1);

    }

    private void printOddNodesUtil(TreeNode root, int level) {

        if(root==null)
            return;
        if(level%2==1){
            System.out.print(root.data+" ");
        }
        printOddNodesUtil(root.left,level+1);
        printOddNodesUtil(root.right,level+1);

    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        printOddNodes(root);
    }
}
