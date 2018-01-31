package interviewBits.tree.traversal;

import interviewBits.tree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by labuser on 7/29/17.
 */
public class PreorderTraversal {

    public ArrayList<Integer> preorderTraversal(TreeNode a) {
        Stack<TreeNode> s= new Stack<TreeNode>();
        ArrayList<Integer> output= new ArrayList<Integer>();
        if(a==null)
            return output;
        s.push(a);
        while(!s.isEmpty()){
            TreeNode temp=s.pop();
            if(temp.right!=null)
                s.push(temp.right);
            if(temp.left!=null)
                s.push(temp.left);
            output.add(temp.val);

        }
        return output;

    }


}
