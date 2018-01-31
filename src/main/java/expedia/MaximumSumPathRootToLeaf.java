package expedia;

import org.junit.Test;
import treesOneOnOne.TreeNode;

public class MaximumSumPathRootToLeaf {

    public int maxSumPath(TreeNode root){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return root.data;
        return root.data+Math.max(maxSumPath(root.left),maxSumPath(root.right));
    }

    TreeNode targetRootNode;
    static int maxsum =Integer.MIN_VALUE;

    public void getTargetLeaf(TreeNode root, int sum){

        if(root==null)
            return;
        if(root.left==null && root.right==null){
            if(maxsum<sum+root.data){
                maxsum=sum+root.data;
                targetRootNode=root;
            }
            return;
        }
        sum=sum+root.data;
        getTargetLeaf(root.left, sum);
        getTargetLeaf(root.right,sum);
    }

    public boolean printPath(TreeNode root, TreeNode target){

        if(root==null)
            return false;
        if(root==target){
            System.out.print(root.data+" ");
            return true;
        }
        if(printPath(root.left,target) || printPath(root.right,target)){
            System.out.print(root.data+" ");
            return true;
        }
        return false;


    }


    @Test
    public void test(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);
        System.out.println(maxSumPath(root));
    }

    @Test
    public void test2(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);
        getTargetLeaf(root,0);
        System.out.println(maxsum);
        System.out.println(targetRootNode);
        printPath(root,targetRootNode);

    }
}
