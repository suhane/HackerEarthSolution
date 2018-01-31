package treesOneOnOne.geeksforgeeks.easy;

import org.junit.Test;
import treesOneOnOne.TreeNode;

public class ChildrenSumParent {

    public int isSumProperty(TreeNode root)
    {
        if(root==null)
            return 1;
        if(root.left==null && root.right==null)
            return 1;
        int childSum= getChildValue(root.left)+getChildValue(root.right);
        if(childSum==root.data && isSumProperty(root.left)==1 && isSumProperty(root.right)==1){
            return 1;
        }
        return 0;

    }

    private int getChildValue(TreeNode root) {
        if(root==null)
            return 0;
        return root.data;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        System.out.println(isSumProperty(root));
    }
}
