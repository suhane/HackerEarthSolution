package treesOneOnOne.geeksforgeeks.medium;

import org.junit.Test;
import treesOneOnOne.TreeNode;

public class BTtoDLL {

    static TreeNode prev=null;
    static TreeNode head=null;

    //inOrder
    public void convertTreetoDLL(TreeNode root){

        if(root==null)
            return;
        convertTreetoDLL(root.left);
        if(prev==null){
            head=root;
            prev=root;
        }
        else {
            prev.right=root;
            root.left=prev;
            prev=root;
        }
        convertTreetoDLL(root.right);
    }

    //reverse Inorder
    public void convertTreetoDLL(TreeNode root ,TreeNode head){

        if(root==null)
            return;
        convertTreetoDLL(root.right,head);
        root.right=head;
        if(head!=null)
            head.left=root;
        head=root;
        convertTreetoDLL(root.left,head);

    }

    @Test
    public void testInOrder(){
        head=null;
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        convertTreetoDLL(root);
        printDLL(head);

    }

    private void printDLL(TreeNode head) {

        TreeNode curr=head;
        while (curr!=null){
            System.out.print(curr.data+"->");
            curr=curr.right;
        }
        System.out.println();
    }

    @Test
    public void testReverseInOrder(){
        head=null;
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        convertTreetoDLL(root);
        printDLL(head);

    }



}
