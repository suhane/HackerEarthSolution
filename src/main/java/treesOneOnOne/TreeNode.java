package treesOneOnOne;

public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int d){
        this.data=d;
        left=null;
        right=null;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        if(this==null)
            return null;
        sb.append("[data="+this.data);
        if(this.left!=null)
            sb.append(" left="+this.left.data);
        else
            sb.append(" left=null");
        if(this.right!=null)
            sb.append(" right="+this.right.data);
        else
            sb.append(" right=null");
        return sb.toString();
    }
}
