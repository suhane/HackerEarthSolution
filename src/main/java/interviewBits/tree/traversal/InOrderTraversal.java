package interviewBits.tree.traversal;

import interviewBits.tree.TreeNode;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by labuser on 7/29/17.
 */
public class InOrderTraversal {

    static TreeNode root=null;


    @BeforeClass
    public static void init(){
        root= new TreeNode(9);
        root.left=new TreeNode(4);
        root.right=new TreeNode(17);
        root.right.right=new TreeNode(22);
        root.right.right.left=new TreeNode(20);
        root.left.left= new TreeNode(3);
        root.left.right=new TreeNode(6);
        root.left.right.left=new TreeNode(5);
        root.left.right.right=new TreeNode(7);

    }

    public ArrayList<Integer> inorderTraversal(TreeNode a) {
        Stack<TreeNode> s= new Stack<TreeNode>();
        ArrayList<Integer> output= new ArrayList<Integer>();
        TreeNode current=a;
        boolean flag=true;
        while(flag){
            if(current!=null){
                s.push(current);
                current=current.left;
            }else{
                if(s.isEmpty())
                    flag=false;
                else{
                    current=s.pop();
                    System.out.print(current.val+" ");
                    current=current.right;
                }
            }
        }
        return output;

    }

    @Test
    public void test(){
        inorderTraversalrec(root);
    }

    private void inorderTraversalrec(TreeNode root) {

        if(root!=null){
            inorderTraversalrec(root.left);
            System.out.print(root.val+" ");
            inorderTraversalrec(root.right);
        }

    }

}
