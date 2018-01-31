package interviewBits.tree.traversal;

import interviewBits.tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by labuser on 7/29/17.
 */
public class PostOrderTraversal {
    public ArrayList<Integer> postOrderTraversal(TreeNode a) {
        Stack<TreeNode> s= new Stack<TreeNode>();
        ArrayList<Integer> output=new ArrayList<Integer>();
        TreeNode prev=null;
        s.push(a);
        while(!s.isEmpty()){
            TreeNode current=s.peek();
            if(prev==null || prev.left==current || prev.right==current){
                if(current.left!=null)
                    s.push(current.left);
                else if(current.right!=null)
                    s.push(current.right);
            }
            else{
                if(current.left==prev){
                    if(current.right!=null)
                    s.push(current.right);
                }
                else{
                    TreeNode temp = s.pop();
                    output.add(temp.val);
                }
            }
            prev=current;
        }
        return output;

    }


}
