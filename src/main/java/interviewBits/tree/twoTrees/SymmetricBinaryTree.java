package interviewBits.tree.twoTrees;

import interviewBits.tree.TreeNode;
import java.util.LinkedList;

/**
 * Created by labuser on 7/30/17.
 */
public class SymmetricBinaryTree {

    public static int isSymmetric(TreeNode a) {

        if(a==null)
            return 1;
        LinkedList<TreeNode> ll1= new LinkedList<TreeNode>();
        LinkedList<TreeNode> ll2= new LinkedList<TreeNode>();
        ll1.add(a);
        while(ll1.size()>0 || ll2.size()>0) {

            while (ll1.size() > 0) {
                TreeNode tmp = ll1.removeFirst();
                if (tmp != null) {
                    if (tmp.left != null)
                        ll2.offer(tmp.left);
                    if (tmp.right != null)
                        ll2.offer(tmp.right);

                }
            }

            if (!isPalindrome(ll2)) {
                return 0;
            }

            while (ll2.size() > 0) {
                TreeNode tmp = ll2.removeFirst();
                if (tmp != null) {
                    if (tmp.left != null)
                        ll1.offer(tmp.left);
                    if (tmp.right != null)
                        ll1.offer(tmp.right);

                }
            }

            if (!isPalindrome(ll1)) {
                return 0;
            }
        }
        return 1;

    }

    private static boolean isPalindrome(LinkedList<TreeNode> ll) {
        int low=0;
        int high=ll.size()-1;
        while(low<high){
            if(ll.get(low).val!=ll.get(high).val)
                return false;
            low++;
            high--;
        }
        return true;
    }


    public int isSymmetricRecursive(TreeNode a) {

        if(a==null)
            return 1;
        else
          return checkSymmetric(a.left,a.right);

    }

    private int checkSymmetric(TreeNode a, TreeNode b) {
        if(a==null && b==null)
            return 1;
        if(a==null || b==null)
            return 0;
        if(a.val!=b.val)
            return 0;
        return checkSymmetric(a.left,  b.right) & checkSymmetric(a.right,  b.left);

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

        System.out.println(isSymmetric(root));
    }
}
