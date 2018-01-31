package prep.code;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorInPlace {

    public void mirror(TreeNode treeNode){

        if(treeNode==null)
            return;

        TreeNode aux= treeNode.left;
        treeNode.left=treeNode.right;
        treeNode.right=aux;
        mirror(treeNode.left);
        mirror(treeNode.right);

    }

    public void mirror2(TreeNode treeNode){

        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.offer(treeNode);
        while (!q.isEmpty()){
            TreeNode curr= q.poll();
            TreeNode aux= curr.left;
            curr.left=curr.right;
            curr.right=aux;

            if(curr.left!=null)
                q.offer(curr.left);
            if(curr.right!=null)
                q.offer(curr.right);
        }
    }

    public static void main(String args[]){

        TreeNode root= new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);

        new MirrorInPlace().mirror2(root);

    }

}


