package expedia;

import org.junit.Test;
import treesOneOnOne.TreeNode;

public class MaximumSumPathLeafToLeaf {

    static int maxSum;

    public void maxSumPathUtil(TreeNode root){

        if(root==null){
            return;
        }

        int leftSum= maxLeafSum(root.left);
        int rightSum= maxLeafSum(root.right);

        maxSum=Math.max(leftSum+rightSum+root.data, maxSum);
        maxSumPathUtil(root.left);
        maxSumPathUtil(root.right);

    }

    private int maxLeafSum(TreeNode root){
        if(root==null)
            return 0;
        return root.data+Math.max(maxLeafSum(root.left),maxLeafSum(root.right));
    }

    public int maxSumPathLinearUtil(TreeNode root){

        if(root==null)
            return 0;

        int leftSum= maxSumPathLinearUtil(root.left);
        int rightSum= maxSumPathLinearUtil(root.right);

        //if both child exist
        if(root.left!=null && root.right!=null){
            maxSum=Math.max(maxSum,leftSum+rightSum+root.data);
        }

        return Math.max(leftSum, rightSum) + root.data;

    }


    @Test
    public void testPolyNomialTime(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);
        System.out.println(maxSumPath(root));
    }

    private int maxSumPath(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        maxSumPathUtil(root);
        return maxSum;
    }

    @Test
    public void testLinearTime(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);
        System.out.println(maxSumPathLinear(root));
    }

    private int maxSumPathLinear(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        maxSumPathLinearUtil(root);
        return maxSum;
    }
}
