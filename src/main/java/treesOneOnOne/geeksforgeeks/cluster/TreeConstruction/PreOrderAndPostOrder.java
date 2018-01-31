package treesOneOnOne.geeksforgeeks.cluster.TreeConstruction;

import org.junit.Test;
import treesOneOnOne.TreeNode;

public class PreOrderAndPostOrder {

    static int preIndex=0;

    public TreeNode constructTree(int[] pre, int[] post, int size, int start, int end){

        if(preIndex>=size || start>end){
            return null;
        }

        int rootElem=pre[preIndex];
        TreeNode root= new TreeNode(rootElem);
        preIndex++;

        if(start==end  || preIndex >= size)
            return root;

        int i;
        for(i=start;i<end;i++){
            if(pre[preIndex]==post[i])
                break;
        }

        if(start<=i) {

            root.left = constructTree(pre, post, size, start,i );
            root.right = constructTree(pre, post, size, i + 1,end );
        }
        return root;

    }

    private void printInOrder(TreeNode root){

        if(root==null)
            return;
        printInOrder(root.left);
        System.out.print(root.data+" ");
        printInOrder(root.right);
    }

    @Test
    public void test(){
        int[] pre= {1, 2, 4, 8, 9, 5, 3, 6, 7};
        int[] post={8, 9, 4, 5, 2, 6, 7, 3, 1};
        TreeNode root=constructTree(pre,post,pre.length,0,pre.length-1);
        printInOrder(root);

    }
}
