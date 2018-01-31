package interviewBits.tree.bstTraversal;

import interviewBits.tree.TreeNode;

import java.util.Stack;

/**
 * Created by labuser on 8/4/17.
 */
public class BSTIterator {

    Stack<TreeNode> s= new Stack<TreeNode>();
    private TreeNode current;
    private TreeNode root;

    public BSTIterator(TreeNode root) {
        this.current=root;
        this.root=root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {

        if((!s.isEmpty()) || (s.isEmpty() && current!=null))
            return true;
        return false;
    }


    /** @return the next smallest number */
    public int next() {
        while (true){
            if(current!=null){
                s.push(current);
                current=current.left;
            }else {
                    current=s.pop();
                    int val= current.val;
                    current=current.right;
                    return val;
                }
            }
    }

    public static void main(String args[])
    {


        /* Let us construct the tree shown in above diagram */
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        //root.left.left = new TreeNode(1);
        BSTIterator i = new BSTIterator(root);
        while (i.hasNext()) System.out.print(i.next());

    }

}
