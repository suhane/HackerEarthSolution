package BST;

/**
 * Created by suhane on 4/12/17.
 */
public interface BinarySearchTree {

    void insert(int data);
    void printInorder();
    int getMax();
    int getMin();
    void delete(int data);
    TreeNode find(int data);

}
