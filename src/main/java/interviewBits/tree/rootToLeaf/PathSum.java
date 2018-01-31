package interviewBits.tree.rootToLeaf;

import interviewBits.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by labuser on 8/1/17.
 */
public class PathSum {
    public static int hasPathSum(TreeNode a, int b) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(a);
        int levelSum = 0;
        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            if (tmp.left != null) {
                tmp.left.val += tmp.val;
                q.offer(tmp.left);
            }
            if (tmp.right != null) {
                tmp.right.val += tmp.val;
                q.offer(tmp.right);
            }
            if (tmp.right == null && tmp.left == null && tmp.val == b)
                return 1;
        }
        return 0;
    }

    public static int hasPathSumRecursion(TreeNode a, int b) {

        if(a==null)
            return 0;
        if(a.left==null && a.right==null && a.val==b)
            return 1;
        return hasPathSumRecursion(a.left,b-a.val) | hasPathSumRecursion(a.right,b-a.val);
    }

    public static void main(String args[]) {


        /* Let us construct the tree shown in above diagram */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(12);

        System.out.println(hasPathSumRecursion(root, 22));
    }
}
