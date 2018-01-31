package treesOneOnOne.geeksforgeeks.basic;

import treesOneOnOne.TreeNode;

public class MinimumElementInBST {

    public int minElementinBST(TreeNode root){

        if (root==null)
            return -1;
        if(root.left==null)
            return root.data;
        return minElementinBST(root.left);
    }
}
