package treesOneOnOne.geeksforgeeks.cluster.views;

import org.junit.Test;
import treesOneOnOne.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

public class VerticalTree {

    static HashMap<Integer,ArrayList<Integer>> hm= new HashMap<>();
    static int minLevel=0;
    static int maxLevel=0;
    public void printNode(TreeNode root, int level){

        if(root==null)
            return;
        if(!hm.containsKey(level)){
            hm.put(level,new ArrayList<Integer>());
        }
        hm.get(level).add(root.data);
        minLevel=Math.min(level,minLevel);
        maxLevel=Math.max(level,maxLevel);
        printNode(root.left,level-1);
        printNode(root.right,level+1);
    }

    public void verticalOrderTraversal(TreeNode root){
        printNode(root,0);
        for(int i=minLevel;i<=maxLevel;i++){
            ArrayList<Integer> list= hm.get(i);
            for(int elem:list){
                System.out.print(elem+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        verticalOrderTraversal(root);
    }
}
