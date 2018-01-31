package BST.Impl;

import BST.BinarySearchTree;
import BST.TreeNode;

import java.util.Stack;

/**
 * Created by suhane on 4/12/17.
 */
public class BSTIterativeImpl implements BinarySearchTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }



    public void insert(int data) {

        TreeNode node = new TreeNode(data);
        if (root == null)
            root = node;
        else {
            TreeNode current = root;
            while (current != null) {
                if (current.getData() > data) {
                    if (current.getLeft() == null) {
                        current.setLeft(node);
                        return;
                    }
                    current.setLeft(node);
                } else {
                    if (current.getData() < data) {
                        if (current.getRight() == null) {
                            current.setRight(node);
                            return;
                        }
                        current.setRight(node);
                    }
                }
            }
        }
    }



    public void printInorder(){

        TreeNode current=root;
        TreeNode prev=null;
        Stack<TreeNode> s=new Stack<TreeNode>();
        while(true){
            if(current!=null) {
                s.push(current);
                current.setLeft(current.getLeft());
            }
            else{
                if (s.isEmpty())
                    return;
                else{
                    current=s.pop();
                    System.out.print(current.getData()+" ");
                    current.setRight(current.getRight());
                }
            }

        }
    }

    public int getMin() {
        if(root==null)
            return 0;
        TreeNode current=root;
        while(current.getLeft()!=null)
            current.setLeft(current.getLeft());
        return current.getData();
    }

    public void delete(int data) {
        if(root==null)
            return;
       //to implement

    }

    public TreeNode find(int data) {
        return null;
        //to implement
    }

    public int getMax() {
        if(root==null)
            return 0;
        TreeNode current=root;
        while(current.getRight()!=null)
            current.setRight(current.getRight());

        return current.getData();
    }
}
