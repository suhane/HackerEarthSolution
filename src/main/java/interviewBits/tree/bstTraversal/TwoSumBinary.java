package interviewBits.tree.bstTraversal;

import interviewBits.tree.TreeNode;

import java.util.Stack;

/**
 * Created by labuser on 8/4/17.
 */
public class TwoSumBinary {


    Stack<TreeNode> asc= new Stack<TreeNode>();
    Stack<TreeNode> desc= new Stack<TreeNode>();
    private TreeNode currentLowest;
    private TreeNode currentHighest;
    private TreeNode root;


    public int t2Sum(TreeNode A, int B) {

        this.currentLowest=A;
        this.currentHighest=A;
        this.root=A;

        if(A==null)
            return 0;
        int j=nextLower();
        int i=nextLarger();
        while (hasNextHigher() || hasNextLower()){
                if(i+j==B)
                    return 1;
                else if(i+j>B)
                    j=nextLower();
                else
                    i=nextLarger();
                if(i>=j)
                    return 0;


        }
        return 0;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNextHigher() {

        if((!asc.isEmpty()) || (asc.isEmpty() && currentLowest!=null))
            return true;
        return false;
    }

    /** @return whether we have a next highest number */
    public boolean hasNextLower() {

        if((!desc.isEmpty()) || (desc.isEmpty() && currentHighest!=null))
            return true;
        return false;
    }


    /** @return the next smallest number */
    public int nextLarger() {
        while (true){
            if(currentLowest!=null){
                asc.push(currentLowest);
                currentLowest=currentLowest.left;
            }else {
                currentLowest=asc.pop();
                int val= currentLowest.val;
                currentLowest=currentLowest.right;
                return val;
            }
        }
    }

    /** @return the next smallest number */
    public int nextLower() {
        while (true){
            if(currentHighest!=null){
                desc.push(currentHighest);
                currentHighest=currentHighest.right;
            }else {
                currentHighest=desc.pop();
                int val= currentHighest.val;
                currentHighest=currentHighest.left;
                return val;
            }
        }
    }



    public static void main(String args[])
    {


        /* Let us construct the tree shown in above diagram */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        TwoSumBinary i = new TwoSumBinary();
        System.out.print(i.t2Sum(root,40));

    }


}
