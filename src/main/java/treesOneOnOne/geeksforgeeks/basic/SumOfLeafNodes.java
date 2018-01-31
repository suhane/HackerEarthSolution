package treesOneOnOne.geeksforgeeks.basic;

import treesOneOnOne.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeafNodes {

    static int sum;

    public int sumLeaf(TreeNode root){

        int sum=0;
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode tmp=q.poll();
            if(tmp.left==null && tmp.right==null)
                sum+=tmp.data;
            if(tmp.left!=null)
                q.offer(tmp.left);
            if(tmp.right!=null)
                q.offer(tmp.right);
        }

        return sum;

    }

    public int sumLeaf(TreeNode root, int sum){

        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return sum+root.data;
        return sumLeaf(root.left,sum)+sumLeaf(root.right,sum);

    }

    public static void main(String s[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        System.out.println(new SumOfLeafNodes().sumLeaf(root,0));

    }
}
