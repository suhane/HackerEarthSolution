package treesOneOnOne.geeksforgeeks.basic;

import treesOneOnOne.TreeNode;

public class SumTree {


    //O(n*n) solution
    public boolean sumTree(TreeNode root){

        if(root==null || (root.left==null && root.right==null))
            return true;
        int ls=sum(root.left);
        int rs=sum(root.right);
        if(root.data==ls+rs && sumTree(root.left) && sumTree(root.right))
            return true;
        return false;
    }

    //O(n) solution
    public boolean sumTreeR(TreeNode root){

        if (root == null || isLeaf(root))
            return true;

        int ls; // for sum of nodes in left subtree
        int rs; // for sum of nodes in right subtree

        if (sumTreeR(root.left) && sumTreeR(root.right)){
            if (root.left == null)
                ls = 0;
            else if (isLeaf(root.left))
                ls = root.left.data;
            else
                ls = 2 * (root.left.data);

            // Get the sum of nodes in right subtree
            if (root.right == null)
                rs = 0;
            else if (isLeaf(root.right))
                rs = root.right.data;
            else
                rs = 2 * (root.right.data);

            if ((root.data == rs + ls))
                return true;
            else
                return false;

        }
        return false;



    }


    private int sum(TreeNode node)
    {
        if (node == null)
            return 0;
        return node.data+sum(node.left)+sum(node.right);
    }

    private boolean isLeaf(TreeNode root){
        if(root==null)
            return false;
        if(root.left==null && root.right==null)
            return true;
        return false;
    }

    public static void main(String s[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        System.out.println(new SumTree().sumTreeR(root));

    }
}
