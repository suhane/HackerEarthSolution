package treesOneOnOne.geeksforgeeks.random;

import org.junit.Test;
import treesOneOnOne.TreeNode;

public class TreeDiameter {

    static int diameter=Integer.MIN_VALUE;
    public int findDiameter(TreeNode root){

        if(root==null)
            return 0;
        int lh=findDiameter(root.left);
        int rh= findDiameter(root.right);
        diameter=Math.max(diameter,1+lh+rh);
        return 1+ Math.max(lh,rh);
    }



    @Test
    public void  test(){

        TreeNode root= new TreeNode(1);
        root.right=new TreeNode(2);
        root.left=new TreeNode(3);
        root.left.left=new TreeNode(3);
        root.left.left.left=new TreeNode(3);
        root.left.left.left.left=new TreeNode(3);
        root.right.left=new TreeNode(14);

        root.right.left.right=new TreeNode(20);
        root.right.left.right.right=new TreeNode(20);
        root.right.left.right.right.right=new TreeNode(20);
        root.right.left.right.right.right.right=new TreeNode(20);

        root.right.left.left=new TreeNode(6);
        root.right.left.left.left=new TreeNode(6);
        root.right.left.left.left.left=new TreeNode(6);
        root.right.left.left.left.left.left=new TreeNode(6);

        //root.left.right=new TreeNode(9);
        findDiameter(root);
        System.out.print( diameter);

    }

}
