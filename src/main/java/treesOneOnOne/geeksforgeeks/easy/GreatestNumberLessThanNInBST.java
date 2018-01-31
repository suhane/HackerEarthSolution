package treesOneOnOne.geeksforgeeks.easy;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import treesOneOnOne.TreeNode;

import java.util.Stack;


public class GreatestNumberLessThanNInBST {

    static TreeNode root=null;

    static int last;


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

    public int findMaxforN(TreeNode root, int n){
    Stack<TreeNode> s= new Stack<TreeNode>();
    int last=Integer.MAX_VALUE;
    TreeNode current=root;
    boolean flag= true;
    while (flag){

        if(current!=null){
            s.push(current);
            current=current.left;
        }
        else {
            if(s.isEmpty())
                flag=false;
            else {
                current=s.pop();
                if(last<=n && n<current.data)
                    return last;
                last=current.data;
                current=current.right;
            }
        }
    }
    return -1;
    }


    public int findClosestNeighbour(TreeNode root,int n){

        last=Integer.MAX_VALUE;
        findMaxforNUtil(root,n);
        return last;
    }

    public void findMaxforNUtil(TreeNode root, int n){

        if(root==null || (last<=n && n<root.data))
            return;
        if(root.data==n ){
            last=root.data;
            return;
        }
        last=root.data;

        if(n<last)
            findMaxforNUtil(root.left,n);
        else
            findMaxforNUtil(root.right,n);

    }

    @Test
    public void test1(){
        Assert.assertTrue(findMaxforN(root,4)==4);

    }
    @Test
    public void test2(){
        Assert.assertTrue(findMaxforN(root,18)==17);

    }
    @Test
    public void test3(){
        Assert.assertTrue(findMaxforN(root,16)==9);

    }

    @Test
    public void test4(){
        Assert.assertTrue(findClosestNeighbour(root,4)==4);

    }
    @Test
    public void test5(){
        Assert.assertTrue(findClosestNeighbour(root,18)==17);

    }
    @Test
    public void test6(){
        Assert.assertTrue(findClosestNeighbour(root,16)==9);

    }


}
