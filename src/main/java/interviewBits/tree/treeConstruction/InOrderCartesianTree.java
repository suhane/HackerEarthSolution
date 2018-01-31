package interviewBits.tree.treeConstruction;

import interviewBits.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by labuser on 8/1/17.
 */
public class InOrderCartesianTree {

    public  static TreeNode buildTreeR(ArrayList<Integer> a,int start ,int end) {

        int max=findRoot(a,start,end);
        TreeNode root= new TreeNode(a.get(max));
        root.left=start==max?null:buildTreeR(a,start,max-1);
        root.right=end==max?null:buildTreeR(a,max+1,end);
        return root;
    }

    public  static TreeNode buildTree(ArrayList<Integer> a) {
        if(a.size()==0)
            return null;
        return buildTreeR(a,0,a.size()-1);
    }

    private static int findRoot(ArrayList<Integer> a, int strt, int end) {

        int i, max = a.get(strt), maxind = strt;
        for (i = strt + 1; i <= end; i++)
        {
            if (a.get(i) > max)
            {
                max = a.get(i);
                maxind = i;
            }
        }
        return maxind;
    }

    public static void main(String args[]){

        buildTree(new ArrayList<Integer>(Arrays.asList( 3,1,2)));
    }
}
