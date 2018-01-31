package expedia;

import org.junit.Test;
import treesOneOnOne.TreeNode;

public class MaximumPathLeafToLeaf {

    static int diameter;

    public void maxPathUtil(TreeNode root){

        if(root==null){
            return;
        }

        int leftHeight= maxHeight(root.left);
        int rightHeight= maxHeight(root.right);

        if(leftHeight!=0 && rightHeight!=0)
            diameter =Math.max(leftHeight+rightHeight+1, diameter);
        maxPathUtil(root.left);
        maxPathUtil(root.right);

    }

    private int maxHeight(TreeNode root){
        if(root==null)
            return 0;
        return 1+Math.max(maxHeight(root.left), maxHeight(root.right));
    }

    public int maxPathLinearUtil(TreeNode root){

        if(root==null)
            return 0;

        int leftHeight= maxPathLinearUtil(root.left);
        int rightHeight= maxPathLinearUtil(root.right);

        //if both child exist
        if(root.left!=null && root.right!=null){
            diameter =Math.max(diameter,leftHeight+rightHeight+1);
        }

        return Math.max(leftHeight, rightHeight) + 1;

    }


    @Test
    public void testPolyNomialTime(){
        TreeNode root = new TreeNode(10);
        //root.right = new TreeNode(-2);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.left.left = new TreeNode(-4);
        System.out.println(maxPath(root));
    }

    private int maxPath(TreeNode root) {
        diameter =0;
        maxPathUtil(root);
        return diameter;
    }

    @Test
    public void testLinearTime(){
        TreeNode root = new TreeNode(10);
        //root.right = new TreeNode(-2);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.left.left = new TreeNode(-4);
        System.out.println(maxPathLinear(root));
    }

    private int maxPathLinear(TreeNode root) {
        diameter =0;
        maxPathLinearUtil(root);
        return diameter;
    }
}
