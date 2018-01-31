package treesOneOnOne.geeksforgeeks.easy;

import org.junit.Test;
import treesOneOnOne.TreeNode;

public class SumLeftLeafNodes {

    
    public int leftLeafSumUtil(TreeNode root,TreeNode parent,int sum){
        
        if(root==null)
            return 0;
        if(root.left==null && root.right==null){
            
            if(parent!=null && parent.left==root)
                return sum+root.data;
        }
        
        return leftLeafSumUtil(root.left,root,sum)+leftLeafSumUtil(root.right,root,sum);
        
        
    }

    public int leftLeafSum(TreeNode root){
        return leftLeafSumUtil(root,null,0);
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(15);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(9);
        System.out.println(leftLeafSum(root));
    }
}
