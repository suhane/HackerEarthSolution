package interviewBits.tree.traversal;

import interviewBits.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by labuser on 7/30/17.
 */
public class LevelOrderTraversal {
    public static ArrayList<Integer> inorderTraversal(TreeNode a) {
        ArrayList<Integer> output= new ArrayList<Integer>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(a);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode tmp=q.poll();
            if(tmp!=null){
                if(tmp.left!=null)
                    q.offer(tmp.left);
                if(tmp.right!=null)
                    q.offer(tmp.right);
                output.add(tmp.val);

            }else{
                if(!q.isEmpty())
                    q.offer(null);

            }
        }
        return output;

    }

    // Driver program to test the above functions
    public static void main(String args[])
    {


        /* Let us construct the tree shown in above diagram */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        System.out.println(inorderTraversal(root));
    }
}
