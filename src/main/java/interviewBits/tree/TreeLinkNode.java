package interviewBits.tree;

/**
 * Created by labuser on 7/29/17.
 */
public class TreeLinkNode {

    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;

    public TreeLinkNode(int val){
        this.val=val;
        left=null;
        right=null;
    }

    public String toString(){
        return "["+this.val+"]";
    }
}
