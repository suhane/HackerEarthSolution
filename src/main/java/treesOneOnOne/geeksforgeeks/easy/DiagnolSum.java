package treesOneOnOne.geeksforgeeks.easy;

import org.junit.Test;
import treesOneOnOne.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DiagnolSum {

    public void diagonalsum(TreeNode root){
        Queue<TreeNode> q1=new LinkedList<TreeNode>();
        Queue<TreeNode> q2= new LinkedList<TreeNode>();

        if(root!=null)
        q1.offer(root);
        while (!q1.isEmpty() || !q2.isEmpty()){
            int sum=0;
            while (!q1.isEmpty()){
                TreeNode tmp=q1.poll();
                sum+=tmp.data;
                if(tmp.left!=null)
                    q2.offer(tmp.left);
                if(tmp.right!=null)
                    q1.offer(tmp.right);
            }
            System.out.println(sum);
            sum=0;
            while (!q2.isEmpty()){
                TreeNode tmp=q2.poll();
                sum+=tmp.data;
                if(tmp.left!=null)
                    q1.offer(tmp.left);
                if(tmp.right!=null)
                    q2.offer(tmp.right);
            }
            if(sum!=0)
                System.out.println(sum);
        }
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(6);
        root.left.right.left=new TreeNode(11);
        root.left.left.right = new TreeNode(10);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left=new TreeNode(12);
        root.right.left.right = new TreeNode(7);
        diagonalsum(root);
    }
}
