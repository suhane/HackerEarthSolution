package treesOneOnOne.geeksforgeeks.basic;

import treesOneOnOne.TreeNode;

public class AreMirror {

    boolean areMirror(TreeNode a, TreeNode b)
    {
        if(a==null && b==null)
            return true;
        if(a==null || b==null)
            return false;
        return a.data==b.data && areMirror(a.left,b.right) && areMirror(a.right,b.left);
    }
}
