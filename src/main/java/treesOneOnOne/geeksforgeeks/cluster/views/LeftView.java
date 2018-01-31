package treesOneOnOne.geeksforgeeks.cluster.views;

import org.junit.Test;
import treesOneOnOne.TreeNode;

import java.util.HashMap;

public class LeftView {

    static int maxLevel;
    static HashMap<Integer,Integer> hm= new HashMap<Integer, Integer>();
    public void leftView(TreeNode root,int level){
        if(root==null)
            return;
        if(!hm.containsKey(level))
            hm.put(level,root.data);
        maxLevel= Math.max(maxLevel,level);
        leftView(root.left,level+1);
        leftView(root.right,level+1);

    }

    public void printLeftView2(TreeNode root){

        if(root==null)
            return;
        System.out.print(root.data+" ");
        if(root.left!=null){
            printLeftView2(root.left);
        }
        else if(root.right!=null){
            printLeftView2(root.right);
        }

    }

    public void printLeftView(TreeNode root){

        hm= new HashMap<Integer, Integer>();
        maxLevel=0;
        leftView(root,0);
        for(int i=0;i<=maxLevel;i++){
            System.out.print(hm.get(i)+" ");
        }
        System.out.println();
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(8);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        root.right.right.right.left = new TreeNode(10);
        printLeftView(root);
    }

    @Test
    public void test2(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        printLeftView(root);
        printLeftView2(root);

    }
}
