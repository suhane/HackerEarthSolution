package treesOneOnOne.geeksforgeeks.easy;

import treesOneOnOne.TreeNode;

public class COnvertLeafToDLL {

    static TreeNode prev;
    static TreeNode head;

    public void convertToDLL(TreeNode root){

        if(root==null)
            return;
        convertToDLL(root.left);
        if(root.left==null && root.right==null){
            if(head==null){
                prev=root;
                head=root;
            }
            else
                root.left=prev;
                prev.right=root;
                prev=root;
        }
        convertToDLL(root.right);

    }
}
