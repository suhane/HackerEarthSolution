package interviewBits.tree.inplaceChange;

import interviewBits.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by labuser on 7/31/17.
 */
public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {

        if (root==null)
            return root;
        TreeNode aux=root.left;
        root.left=root.right;
        root.right=aux;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


    public static TreeNode invertTreeNoNrecursive(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode aux=q.poll();
            if(aux!=null){
                TreeNode temp=aux.left;
                aux.left=aux.right;
                aux.right=temp;
                if(aux.left!=null)
                    q.offer(aux.left);
                if(aux.right!=null)
                    q.offer(aux.right);
            }
        }
        return root;
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

        System.out.println(invertTreeNoNrecursive(root));
    }


}
