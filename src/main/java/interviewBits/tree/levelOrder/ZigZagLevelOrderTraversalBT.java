package interviewBits.tree.levelOrder;

import interviewBits.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by labuser on 7/31/17.
 */
public class ZigZagLevelOrderTraversalBT {

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {

        Stack<TreeNode> ll1= new Stack<TreeNode>();
        Stack<TreeNode> ll2= new Stack<TreeNode>();

        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        if(a==null)
            return output;
        ll1.push(a);
        while (ll1.size()>0 || ll2.size()>0 ){
            if(!ll1.isEmpty()) {
                ArrayList<Integer> result = new ArrayList<Integer>();
                while (!ll1.isEmpty()) {
                    TreeNode tmp = ll1.pop();
                    if (tmp.left != null)
                        ll2.push(tmp.left);
                    if (tmp.right != null)
                        ll2.push(tmp.right);
                    result.add(tmp.val);
                }
                output.add(result);
            }
            if(!ll2.isEmpty()) {
                ArrayList<Integer> result = new ArrayList<Integer>();
                while (!ll2.isEmpty()) {
                    TreeNode tmp = ll2.pop();
                    if (tmp.right != null)
                        ll1.push(tmp.right);
                    if (tmp.left != null)
                        ll1.push(tmp.left);
                    result.add(tmp.val);
                }
                output.add(result);
            }

        }
        return output;


    }

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

        System.out.println(zigzagLevelOrder(root));
    }
}
