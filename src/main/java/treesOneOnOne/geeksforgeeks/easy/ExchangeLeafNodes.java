package treesOneOnOne.geeksforgeeks.easy;

import treesOneOnOne.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ExchangeLeafNodes {

    public void exchangeLeaf(TreeNode root){
        if(root==null)
            return;
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.offer(root);
        TreeNode nodeA=null,nodeB=null;
        while(!q.isEmpty()){
            TreeNode aux= q.poll();
            if(aux.left==null && aux.right==null){
                if(nodeA==null){
                    nodeA=aux;
                }
                else{
                    swap(nodeA,aux);
                    nodeA=null;
                }
            }
            if(aux.left!=null)
                q.offer(aux.left);
            if(aux.right!=null)
                q.offer(aux.right);
        }
    }

    private void swap(TreeNode nodeA, TreeNode nodeB) {

        int data=nodeA.data;
        nodeA.data=nodeB.data;
        nodeB.data=data;
    }

    public static void main(String s[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2); root.left.left=new TreeNode(4);
        root.right = new TreeNode(3); root.right.left=new TreeNode(5);root.right.left.left=new TreeNode(6);root.right.left.right=new TreeNode(7);root.right.right=new TreeNode(8);
        root.right.right.left=new TreeNode(9);root.right.right.right=new TreeNode(10);
        new ExchangeLeafNodes().exchangeLeaf(root);
    }
}
