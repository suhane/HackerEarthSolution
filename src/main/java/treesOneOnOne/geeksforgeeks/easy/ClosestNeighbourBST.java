package treesOneOnOne.geeksforgeeks.easy;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import treesOneOnOne.TreeNode;

public class ClosestNeighbourBST {

    static TreeNode root=null;

    @BeforeClass
    public static void init(){
        root= new TreeNode(9);
        root.left=new TreeNode(4);
        root.right=new TreeNode(17);
        root.right.right=new TreeNode(22);
        root.right.right.left=new TreeNode(20);
        root.left.left= new TreeNode(3);
        root.left.right=new TreeNode(6);
        root.left.right.left=new TreeNode(5);
        root.left.right.right=new TreeNode(7);

    }

    int last=Integer.MAX_VALUE;
    public int closestNeighbour(TreeNode root, int n){

        if(root==null)
            return 0;
        closestNeighbour(root.left,n);
        if(last<=n && n<root.data)
            return last;
        else
            last=root.data;
        return closestNeighbour(root.right,n);

    }

    public int closestNeighbour2(TreeNode root,int n, int prev){

        if(root==null)
            return prev;
        if (root.data>n && n>=prev)
                return prev;

        if(n<root.data)
           return closestNeighbour2(root.left,n,root.data);
        else
            return closestNeighbour2(root.right,n,root.data);
    }

    @Test
    public void test1(){
        Assert.assertTrue(closestNeighbour2(root,4,Integer.MAX_VALUE)==4);

    }
    @Test
    public void test2(){
        Assert.assertTrue(closestNeighbour2(root,18,Integer.MAX_VALUE)==17);

    }
    @Test
    public void test3(){
        Assert.assertTrue(closestNeighbour2(root,12,Integer.MAX_VALUE)==9);

    }


}
