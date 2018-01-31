package prep.set348.secondround;


import java.util.Stack;

class TreeNode {

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


public class IsBST {

    public static boolean isBST(TreeNode root){

        return isBSTUtil(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }

    public static boolean isBST2(TreeNode root){

        Stack<TreeNode> s= new Stack<TreeNode>();
        int last=Integer.MIN_VALUE;
        TreeNode current=root;
        while(true){
            if(current!=null){
                s.push(current);
                current=current.left;
            }
            else{
                if(s.isEmpty())
                    return true;
                else{
                    current=s.pop();
                    if(current.val>last)
                        last=current.val;
                    else
                        return false;
                    current=current.right;


                }
            }
        }

    }

    private static boolean isBSTUtil(TreeNode root, int maxValue, int minValue) {

        if(root==null)
            return true;
        if(root.val<minValue || root.val>maxValue)
            return false;
        return isBSTUtil(root.left,root.val-1,minValue) && isBSTUtil(root.right,maxValue,root.val+1);
    }


    public static void main(String args[])
    {


        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        if (isBST2(root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }

}
