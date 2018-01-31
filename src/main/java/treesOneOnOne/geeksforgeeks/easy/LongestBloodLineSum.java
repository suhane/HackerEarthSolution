package treesOneOnOne.geeksforgeeks.easy;
import org.junit.Test;
import treesOneOnOne.TreeNode;

public class LongestBloodLineSum {

    static int maxLen;
    static int maxSum;

    public int longestBloodlineSum(TreeNode root) {

        maxSum=Integer.MIN_VALUE;
        maxLen=0;
        if (root == null)
            return 0;
        sumOfLongRootToLeafPath(root,0,0);
        return maxSum;
    }


    public void sumOfLongRootToLeafPath(TreeNode root,int sum,int len){

        if(root==null) {
            if (len > maxLen) {
                maxLen = len;
                maxSum = sum;
            } else if (maxLen == len)
                maxSum = Math.max(sum,maxSum);
            return;
        }
        sumOfLongRootToLeafPath(root.left,sum+root.data,len+1);
        sumOfLongRootToLeafPath(root.right,sum+root.data,len+1);

    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(8);
        root.left.right.left.right = new TreeNode(8);
        root.left.right.left.right.left = new TreeNode(1);
        root.left.right.left.right.left.right = new TreeNode(1);
        root.left.right.left.right.left.right.left = new TreeNode(1);
        root.left.right.left.right.left.right.left.right = new TreeNode(1);

        root.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        root.right.right.left.right = new TreeNode(1);
        root.right.right.left.right.left = new TreeNode(1);
        root.right.right.left.right.left.right = new TreeNode(1);
        root.right.right.left.right.left.right.left = new TreeNode(1);
        root.right.right.left.right.left.right.left.right = new TreeNode(1);
        root.right.right.left.right.left.right.left.right.left = new TreeNode(10);
        System.out.println(longestBloodlineSum(root));
    }
}