package interviewBits.tree;

/**
 * Created by labuser on 7/29/17.
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
        this.val=val;
        left=null;
        right=null;
    }

    public String toString(){
        return "["+this.val+"]";
    }
}
