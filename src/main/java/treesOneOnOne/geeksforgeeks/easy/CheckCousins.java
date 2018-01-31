package treesOneOnOne.geeksforgeeks.easy;

import treesOneOnOne.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCousins {

    public boolean isCousin(TreeNode root, TreeNode a , TreeNode b){

        if(root==null)
            return false;
        if (level(root,a,1)==level(root,b,1) && !isSibling(root, a,b))
            return true;
        return false;

    }


    public boolean isCousinIterative(TreeNode root, TreeNode a , TreeNode b){

        if(root==null || a==b || root==a || root==b)
            return false;
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        if(root!=null)
        q.offer(root);
        q.offer(null);
        boolean foundOne=false;
        while(!q.isEmpty()){
            TreeNode aux= q.poll();
            if(aux!=null){
                if((aux.left==a && aux.right==b) || (aux.right==a && aux.left==b))
                    return false;
                if(aux.left==a || aux.right==a || aux.left==b || aux.right==b){
                    if(foundOne)
                        return true;
                    else
                        foundOne=true;
                }
            }
            else {
                if(!q.isEmpty())
                    q.offer(null);
            }
            if(foundOne)
                return false;
        }

        return false;

    }

    private boolean isSibling(TreeNode root, TreeNode a, TreeNode b) {

        if(root==null)
            return false;
        if((root.left==a && root.right==b) || (root.right==a && root.left==b))
            return true;
        return isSibling(root.left,a,b) || isSibling(root.right,a,b);
    }

    private int level(TreeNode root, TreeNode a, int level) {
        if(root==null)
            return -1;
        if(root==a)
            return level;
        int left_level=level(root.left, a, level+1);
        if(left_level!=-1)
            return left_level;
        return level(root.right, a, level+1);

    }


    public static void main(String args[])
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        TreeNode Node1, Node2;
        Node1 = root.left.left;
        Node2 = root.right.left.right;
        System.out.println("---------------------------------------------Recursive approach---------");
        System.out.println(new CheckCousins().isCousin(root, Node1, Node2));
        System.out.println("---------------------------------------------Iterative approach---------");
        System.out.println(new CheckCousins().isCousinIterative(root, Node1, Node2));
    }
}
