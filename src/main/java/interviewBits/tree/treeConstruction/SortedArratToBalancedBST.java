package interviewBits.tree.treeConstruction;
import interviewBits.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static interviewBits.tree.treeConstruction.InOrderCartesianTree.buildTree;
/**
 * Created by labuser on 8/2/17.
 */

public class SortedArratToBalancedBST {

    public static TreeNode sortedArrayToBST(final List<Integer> a) {

        return constructBST(a,0,a.size()-1);

    }

    private static TreeNode constructBST(List<Integer> a, int start, int end) {

        if(start>end)
            return null;
        int mid=(start+end)/2;
        TreeNode root= new TreeNode(a.get(mid));
        root.left=constructBST(a,start,mid-1);
        root.right=constructBST(a,mid+1,end);
        return root;

    }

    public static void main(String args[]){

        sortedArrayToBST(new ArrayList<Integer>(Arrays.asList(1,2,3)));
    }
}
