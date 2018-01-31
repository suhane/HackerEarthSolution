package interviewBits.tree.twoTrees;
import interviewBits.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by labuser on 7/30/17.
 */
public class IdenticalTrees {
    public static int isSameTree(TreeNode a, TreeNode b) {
        Queue<TreeNode> q1= new LinkedList<TreeNode>();
        Queue<TreeNode> q2= new LinkedList<TreeNode>();
        if(a==null && b== null)
            return 1;
        if((a==null && b!=null) || (b==null && a!=null))
            return 0;
        q1.offer(a);
        q2.offer(b);
        while(!q1.isEmpty() || !q2.isEmpty()){
            TreeNode t1=q1.poll();
            TreeNode t2= q2.poll();
            if(t1!=null && t2!=null && t1.val==t2.val){
                if(t1.left!=null && t2.left!=null){
                    q1.offer(t1.left);
                    q2.offer(t2.left);
                }
                else if((t1.left==null && t2.left!=null) || (t1.left!=null && t2.left==null)){
                    return 0;
                }

                if(t1.right!=null && t2.right!=null){
                    q1.offer(t1.right);
                    q2.offer(t2.right);
                }

                else if((t1.right==null && t2.right!=null) || (t1.right!=null && t2.right==null)){
                    return 0;
                }

            }
            else
                return 0;
        }

       if(q1.isEmpty() && q2.isEmpty())
           return 1;
        else
           return 0;
    }

    public static int isSameTreeRecursion(TreeNode a, TreeNode b) {

        if(a==null && b==null)
            return 1;
        if(a==null || b==null)
            return 0;
        if(a.val!=b.val)
            return 0;

        return isSameTreeRecursion(a.left,b.left) & isSameTreeRecursion(a.right,b.right);

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
        root.right.left.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(7);
        root2.right.left.right = new TreeNode(8);
        root2.right.right.right = new TreeNode(9);

        System.out.println(isSameTreeRecursion(root,root2));
    }
}
