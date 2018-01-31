package treesOneOnOne.geeksforgeeks.basic;

import treesOneOnOne.TreeNode;

import java.util.Scanner;

public class Mirror {

    void mirror(TreeNode node)
    {
        if(node==null)
            return;
        TreeNode aux=node.left;
        node.left=node.right;
        node.right=aux;
        mirror(node.left);
        mirror(node.right);
    }
}