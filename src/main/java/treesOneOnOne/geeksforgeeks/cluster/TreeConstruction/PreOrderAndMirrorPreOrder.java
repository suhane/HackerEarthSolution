package treesOneOnOne.geeksforgeeks.cluster.TreeConstruction;

import org.junit.Test;
import treesOneOnOne.TreeNode;

public class PreOrderAndMirrorPreOrder {

    static int preIndex;

    public TreeNode constructTree(int[] pre, int[] mpre, int size, int start, int end){

        if(start>=size || start>end){
            return null;
        }

        int rootElem=pre[preIndex];
        TreeNode root= new TreeNode(rootElem);
        preIndex++;

        if(start==end)
            return root;

        int i;
        for(i=start;i<end;i++){
            if(pre[preIndex]==mpre[i])
                break;
        }

        if(start<i) {

            root.left = constructTree(pre, mpre, size, i, end );
            root.right = constructTree(pre, mpre, size, start + 1,i-1 );
        }
        return root;

    }

    @Test
    public void test(){
        int[] pre= {1,2,4,5,3,6,7};
        int[] mpre={1,3,7,6,2,5,4};
        TreeNode root=constructTree(pre,mpre,pre.length,0,pre.length-1);

    }
}
