package treesOneOnOne.geeksforgeeks.cluster.views;

import org.junit.Test;
import treesOneOnOne.TreeNode;

public class BoundaryTraversal {


    public void boundaryTraversal(TreeNode root){

        leftTopDown(root); // will not print the leaves to avoid duplication
        printLeaves(root);
        rightBottomUp(root.right);// will not print the leaves to avoid duplication

    }

    private void printLeaves(TreeNode root) {

        if(root==null)
            return;
        if(root.left==null && root.right==null){
            System.out.print(root.data+" ");
            return;
        }
        printLeaves(root.left);
        printLeaves(root.right);
    }

    private void rightBottomUp(TreeNode root) {

        if(root==null)
            return;
        if(root.right!=null){
            rightBottomUp(root.right);
            System.out.print(root.data+" ");
        }
        else if(root.left!=null){
            rightBottomUp(root.left);
            System.out.print(root.data+" ");
        }
    }

    private void leftTopDown(TreeNode root) {

        if(root==null)
            return;
        if(root.left!=null){
            System.out.print(root.data+" ");
            leftTopDown(root.left);
        }
        else if(root.right!=null) {

            System.out.print(root.data + " ");
            leftTopDown(root.right);

        }
    }


    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        boundaryTraversal(root);
    }

}
