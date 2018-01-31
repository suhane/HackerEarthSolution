package interviewBits.tree.rootToLeaf;

import interviewBits.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by labuser on 8/6/17.
 */
public class MinDepthOfBinaryTree {

    public int minDepth(TreeNode a) {

        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.add(a);
        q.add(null);
        int minHeight=1;
        while (!q.isEmpty()){
            TreeNode aux=q.poll();
            if(aux!=null){
                if(aux.left!=null)
                    q.add(aux.left);
                if(aux.right!=null)
                    q.add(aux.right);
                if(aux.left==null && aux.right==null)
                    return minHeight;
            }
            else{
                if(!q.isEmpty()) {
                    q.add(null);
                    minHeight++;
                }
            }
        }
        return minHeight;
    }

    public static void main(String args[])
    {


        /* Let us construct the tree shown in above diagram */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        MinDepthOfBinaryTree i = new MinDepthOfBinaryTree();
        System.out.print(i.minDepth(root));

    }
}
