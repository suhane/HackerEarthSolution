package interviewBits.tree.bstTraversal;

import interviewBits.tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by labuser on 8/5/17.
 */
public class RecoverBST {

    Stack<TreeNode> s= new Stack<TreeNode>();
    private TreeNode current;

    public ArrayList<Integer> recoverTree(TreeNode a) {
        this.current=a;
        ArrayList<Integer> output=new ArrayList<Integer>();
        TreeNode firstStartPoint=null;
        TreeNode lastEndPoint=null;
        TreeNode previous_node=null;
        while (hasNext()){
            TreeNode curr=next();
            if(previous_node!=null && previous_node.val>curr.val){
                if(firstStartPoint==null){
                    firstStartPoint=previous_node;
                }
                lastEndPoint=curr;
            }
            previous_node=curr;
        }
        output.add(lastEndPoint.val);
        output.add(firstStartPoint.val);
        return output;


    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {

        if((!s.isEmpty()) || (s.isEmpty() && current!=null))
            return true;
        return false;
    }


    /** @return the next smallest number */
    public TreeNode next() {
        while (true){
            if(current!=null){
                s.push(current);
                current=current.left;
            }else {
                current=s.pop();
                TreeNode val= current;
                current=current.right;
                return val;
            }
        }
    }

    public static void main(String args[])
    {


        /* Let us construct the tree shown in above diagram */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        RecoverBST i = new RecoverBST();
        System.out.print(i.recoverTree(root));

    }
}
