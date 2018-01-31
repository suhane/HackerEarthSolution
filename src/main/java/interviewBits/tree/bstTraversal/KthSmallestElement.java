package interviewBits.tree.bstTraversal;

import interviewBits.tree.TreeNode;

import java.util.Stack;

/**
 * Created by labuser on 8/4/17.
 */
public class KthSmallestElement {

    public static int kthsmallest(TreeNode root, int k) {

        Stack<TreeNode> s= new Stack<TreeNode>();
        int count=0;
        TreeNode current=root;
        while(true){
            if(current!=null){
                s.push(current);
                current=current.left;
            }
            else {
                current=s.pop();
                if(count==k-1)
                    return current.val;
                current=current.right;
                count++;
            }
        }


    }
}
