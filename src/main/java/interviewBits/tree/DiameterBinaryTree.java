package interviewBits.tree;




public class DiameterBinaryTree {

    //Time Complexity: O(n^2)
    int diameter(TreeNode root){

        if(root==null)
            return 0;

        int lheight= height(root.left);
        int rheight= height(root.right);

        int ldiameter=diameter(root.left);
        int rdiameter=diameter(root.right);

        return Math.max(1+lheight+rheight,Math.max(ldiameter,rdiameter));
    }

    private int height(TreeNode root) {

        if(root==null)
            return 0;

        return 1+ Math.max(height(root.left),height(root.right));

    }

    static class Height{
        int h;
    }

    int diameter(TreeNode root, Height height ){
        Height lh = new Height(), rh = new Height();

        if (root == null)
        {
            height.h = 0;
            return 0; /* diameter is also 0 */
        }

        lh.h++;     rh.h++;
        int ldiameter = diameter(root.left, lh);
        int rdiameter = diameter(root.right, rh);
        height.h = Math.max(lh.h, rh.h) + 1;
        return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
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

        System.out.println(new DiameterBinaryTree().diameter(root,new Height()));
    }
}
