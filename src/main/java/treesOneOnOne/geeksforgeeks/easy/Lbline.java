package treesOneOnOne.geeksforgeeks.easy;


import org.junit.Test;
import treesOneOnOne.TreeNode;

public class Lbline {

    static int maxLevel=0;
    static int maxSum=0;

    public void lbs(TreeNode root, int level , int sum){

        if(root==null)
            return;
        if(root.left==null && root.right==null){

            if(level>maxLevel){

                maxSum=sum+root.data;
                maxLevel=level;
            }else {
                if(level==maxLevel)
                    maxSum=Math.max(sum+root.data,maxSum);
            }

        }

        lbs(root.left,level+1,sum+root.data);
        lbs(root.right,level+1,sum+root.data);


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

    private int longestBloodlineSum(TreeNode root) {

        if (root == null)
            return 0;
        lbs(root,0,0);
        return maxSum;
    }
}
