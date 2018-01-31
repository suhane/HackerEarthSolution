package prep.set348.secondround;

/*

Find the largest BST subtree in a given Binary Tree | Set 1
Given a Binary Tree, write a function that returns the size of the largest subtree which is also a Binary Search Tree (BST). If the complete Binary Tree is BST, then return the size of whole tree.

Examples:

Input:
      5
    /  \
   2    4
 /  \
1    3

Output: 3
The following subtree is the maximum size BST subtree
   2
 /  \
1    3


Input:
       50
     /    \
  30       60
 /  \     /  \
5   20   45    70
              /  \
            65    80
Output: 5
The following subtree is the maximum size BST subtree
      60
     /  \
   45    70
        /  \
      65    80



 */

class Info{
    int size;
    int min;
    int max;
    int ans;
    boolean isBST;

    public Info(){}

    public Info(int size, int min, int max, int ans, boolean isBST) {
        this.size = size;
        this.min = min;
        this.max = max;
        this.ans = ans;
        this.isBST = isBST;
    }
}



public class LargestBSTTree {

    public static Info findLargestBST(TreeNode root){

        if(root==null)
            return new Info(0,Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
        if(root.left==null && root.right==null)
            return new Info(1,root.val,root.val,1,true);

        Info left=findLargestBST(root.left);
        Info right=findLargestBST(root.right);

        Info ret=new Info();
        ret.size=1+left.size+right.size;

        if(left.isBST && right.isBST && left.max<root.val && right.min>root.val){
            ret.min=Math.min(left.min,Math.min(right.min,root.val));
            ret.max=Math.max(left.max,Math.max(right.max,root.val));
            ret.ans=ret.size;
            ret.isBST=true;
            return ret;
        }

        ret.ans = Math.max(left.ans, right.ans);
        ret.isBST = false;

        return ret;



    }


    public static void main(String args[]){

        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(20);
        root.right = new TreeNode(60);
        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(70);
        root.right.right.left = new TreeNode(65);
        root.right.right.right = new TreeNode(80);

        System.out.println(findLargestBST(root).ans);

    }


}
