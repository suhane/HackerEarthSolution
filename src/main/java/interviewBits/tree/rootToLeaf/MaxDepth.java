package interviewBits.tree.rootToLeaf;

import interviewBits.tree.TreeLinkNode;
import interviewBits.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by labuser on 8/1/17.
 */
public class MaxDepth {

    static int maxDepth=0;
    public static int maxDepth(TreeNode a) {

        if(a==null)
            return 0;
        maxDepth=1+Math.max(maxDepth(a.left),maxDepth(a.right));
        return maxDepth;
    }

    public static int maxDepthNonRecursive(TreeNode a) {
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        int maxDepth=0;
        q.offer(a);
        q.offer(null);
        while(!q.isEmpty()){
            TreeNode tmp=q.poll();
            if(tmp!=null){
                if(tmp.left!=null)
                    q.offer(tmp.left);
                if(tmp.right!=null)
                    q.offer(tmp.right);
            }
            else{
                maxDepth++;
                if(!q.isEmpty())
                    q.offer(null);
            }
        }
        return maxDepth;
    }

    public static void main(String args[]){

         /* Let us construct the tree shown in above diagram */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(7);
        root.right.right.right.right = new TreeNode(7);
        root.right.right.right.right.right = new TreeNode(7);
        root.right.right.right.right.right.right = new TreeNode(7);

        System.out.print(maxDepth(root));
    }
}
