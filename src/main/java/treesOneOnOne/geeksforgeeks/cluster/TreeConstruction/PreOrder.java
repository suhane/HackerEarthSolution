package treesOneOnOne.geeksforgeeks.cluster.TreeConstruction;

import org.junit.Test;
import treesOneOnOne.TreeNode;

public class PreOrder {

    private static int preIndex=0;
    public TreeNode constructTree(int[] pre, int[] preLN, int size ){

        if(preIndex>=size)
            return null;

        TreeNode root= new TreeNode(pre[preIndex]);
        preIndex++;
        if(preIndex==size || preLN[preIndex-1]=='L')
            return root;


        root.left=constructTree(pre,preLN,size);
        root.right=constructTree(pre,preLN,size);

        return root;
    }

    @Test
    public void test(){
        int[] pre={10, 30, 20, 5, 15};
        int[] preLN={'N', 'N', 'L', 'L', 'L'};
        TreeNode root=constructTree(pre,preLN,pre.length);

    }
}
