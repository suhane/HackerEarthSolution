package BST;

/**
 * Created by suhane on 4/13/17.
 */
public class TreeNode{

    private TreeNode right;
    private int data;
    private TreeNode left;

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public int getData() {

        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode (int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }

}
