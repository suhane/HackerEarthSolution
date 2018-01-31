package treesOneOnOne.geeksforgeeks.basic;

import treesOneOnOne.TreeNode;

public class NoSiblingNode {

    void printSibling(TreeNode node)
    {
        if(node==null)
            return;
        if(node.left!=null && node.right==null)
            System.out.println(node.left.data);
        if(node.left==null && node.right!=null)
            System.out.println(node.right.data);

        printSibling(node.left);
        printSibling(node.right);
    }

    public static void main(String s[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right=new TreeNode(7);
        new NoSiblingNode().printSibling(root);

    }
}
