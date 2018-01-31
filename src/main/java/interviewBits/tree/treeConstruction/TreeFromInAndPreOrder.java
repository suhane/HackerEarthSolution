package interviewBits.tree.treeConstruction;

import interviewBits.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by labuser on 8/2/17.
 */
public class TreeFromInAndPreOrder {

    static int preStart=0;
    public static TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
        return buildTreeRec(preorder,inorder,0,inorder.size()-1);
    }

    private static TreeNode buildTreeRec(ArrayList<Integer> preorder, ArrayList<Integer> inorder, int instart, int inend) {

        if(instart>inend || preStart>=preorder.size()){
            return null;
        }
        int rootIndex=findRoot(inorder,instart,inend,preorder.get(preStart++));
        TreeNode root= new TreeNode(inorder.get(rootIndex));
        root.left=buildTreeRec(preorder,inorder,instart,rootIndex-1);
        root.right=buildTreeRec(preorder,inorder,rootIndex+1,inend);
        return root;

    }



    /*public static TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {

        int n=inorder.size();
        if(n==0)
            return null;
        Stack<ArrayList<Integer>> left= new Stack<ArrayList<Integer>>();
        Stack<ArrayList<Integer>> right= new Stack<ArrayList<Integer>>();

        TreeNode root=new TreeNode(preorder.get(0));
        TreeNode current=root;
        ArrayList<Integer> leftSubArray;
        ArrayList<Integer> rightSubArray;
        List<Integer> list= new ArrayList<Integer>(inorder.subList(0, n));
        for(int i=0;i<n;i++){

            if(!left.isEmpty()) {
                list = left.pop();
                TreeNode temp = new TreeNode(preorder.get(i));
                current.left=temp;
                current=current.left;
            }
            else
            if(!right.isEmpty()){
                list = right.pop();
                TreeNode temp = new TreeNode(preorder.get(i));
                current.right=temp;
                current=current.right;
            }

            int rootIndex= findRoot(list,preorder.get(i));
            if(rootIndex==0) {
                rightSubArray = new ArrayList<Integer>(list.subList(rootIndex + 1, list.size()));
                right.push(rightSubArray);
            }
            else
                if(rootIndex==list.size()-1){

                    leftSubArray = new ArrayList<Integer>(list.subList(0, list.size() - 1));
                    left.push(leftSubArray);
                }
                else {
                    rightSubArray = new ArrayList<Integer>(list.subList(rootIndex + 1, list.size()));
                    leftSubArray = new ArrayList<Integer>(list.subList(0, rootIndex));
                    left.push(leftSubArray);
                    right.push(rightSubArray);
                }
        }
        return root;
    }

    private static int findRoot(List<Integer> a, int val) {

        int low=0;
        int high=a.size()-1;
        while (low<=high){
            if(a.get(low)==val)
                return low;
            else
                low++;
        }
        return low;
    }
    */

    private static int findRoot(ArrayList<Integer> a, int low, int high, int val) {

        while (low<=high){
            if(a.get(low)==val)
                return low;
            else
                low++;
        }
        return low;
    }
    public static void main(String args[]){

        buildTree(new ArrayList<Integer>(Arrays.asList( 1,2,3,4,6,5)),new ArrayList<Integer>(Arrays.asList(1,3,2,6,4,5)));
    }
}
