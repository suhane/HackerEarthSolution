package BST;

import BST.Impl.BSTIterativeImpl;

/**
 * Created by suhane on 4/12/17.
 */
public class TestBST {
    public static void main(String args[]){

        BinarySearchTree bst= new BSTIterativeImpl();
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(6);
        bst.insert(5);
        bst.insert(7);
        bst.printInorder();




    }
}
