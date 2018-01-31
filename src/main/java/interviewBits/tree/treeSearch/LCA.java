package interviewBits.tree.treeSearch;

import interviewBits.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by labuser on 8/8/17.
 */
public class LCA {

    private  List<Integer> path1 = new ArrayList<Integer>();
    private  List<Integer> path2 = new ArrayList<Integer>();

    public int lca(TreeNode a, int val1, int val2) {
        path1.clear();
        path2.clear();

        if (!findPath(a, val1, path1) || !findPath(a, val2, path2)) {
            return -1;
        }

        int i;
        for(i=0;i<path1.size() && i<path2.size();i++){
            if(!path1.get(i).equals(path2.get(i)))
                break;
        }
        return path1.get(i-1);
    }

    private boolean findPath(TreeNode root, int n, List<Integer> path)
    {
        if (root == null) {
            return false;
        }

        path.add(root.val);

        if (root.val == n) {
            return true;
        }

        if (root.left != null && findPath(root.left, n, path)) {
            return true;
        }

        if (root.right != null && findPath(root.right, n, path)) {
            return true;
        }

        path.remove(path.size()-1);

        return false;
    }


    TreeNode findLCA(TreeNode node, int n1, int n2)
    {
        // Base case
        if (node == null)
            return null;

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (node.val == n1 || node.val == n2)
            return node;

        // Look for keys in left and right subtrees
        TreeNode left_lca = findLCA(node.left, n1, n2);
        TreeNode right_lca = findLCA(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca!=null && right_lca!=null)
            return node;

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }


    public static void main(String[] args)
    {
        LCA tree = new LCA();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

       System.out.println("LCA(4, 5): " + tree.findLCA(root,4,5));
        System.out.println("LCA(4, 6): " + tree.findLCA(root,4,6));
        System.out.println("LCA(3, 4): " + tree.findLCA(root,3,4));
        System.out.println("LCA(2, 4): " + tree.findLCA(root,2,4));
       /* System.out.println("LCA(4, 7): " + tree.findLCA(4,7));
        System.out.println("LCA(4, 8): " + tree.findLCA(4,8));
        System.out.println("LCA(1, 1): " + tree.findLCA(1,1)); */
    }
}
