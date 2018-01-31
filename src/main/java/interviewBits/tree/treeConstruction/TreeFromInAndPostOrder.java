package interviewBits.tree.treeConstruction;

import interviewBits.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by labuser on 8/2/17.
 */
public class TreeFromInAndPostOrder {

    static int postend;
    public static TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {


        postend = postorder.size() - 1;
        return constructTree(inorder,postorder,0,inorder.size()-1);
    }

    private static TreeNode constructTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder, int prestart, int preend) {

        if(prestart>preend ||  postend<0)
            return null;
        int rootIndex=findRoot(inorder,prestart,preend,postorder.get(postend));
        postend--;
        TreeNode root=new TreeNode(inorder.get(rootIndex));
        root.right=constructTree(inorder,postorder,rootIndex+1,preend);
        root.left=constructTree(inorder,postorder,prestart,rootIndex-1);
        return root;
    }

    static class Index
    {
        int index;
    }


    private static TreeNode constructTree2(ArrayList<Integer> in, ArrayList<Integer> post, int inStrt,
                                          int inEnd, Index pIndex)  {

        // Base case
        if (inStrt > inEnd)
            return null;

        /* Pick current node from Preorder traversal using
           postIndex and decrement postIndex */
        TreeNode root = new TreeNode(post.get(pIndex.index));
        (pIndex.index)--;

        /* If this node has no children then return */
        if (inStrt == inEnd)
            return root;

        /* Else find the index of this node in Inorder
           traversal */
        int iIndex = findRoot(in, inStrt, inEnd, root.val);

        /* Using index in Inorder traversal, construct left and
           right subtress */
        root.right = constructTree2(in, post, iIndex + 1, inEnd, pIndex);
        root.left = constructTree2(in, post, inStrt, iIndex - 1, pIndex);

        return root;
    }


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

        buildTree(new ArrayList<Integer>(Arrays.asList( 7,5, 6, 2, 3, 1, 4)),new ArrayList<Integer>(Arrays.asList(5, 6, 3, 1, 4, 2,7)));
    }
}
