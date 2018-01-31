package treesOneOnOne.geeksforgeeks.cluster.views;

import org.junit.Test;
import treesOneOnOne.TreeNode;

import java.util.HashMap;

public class BottomView {

    class Node{
        int level;
        int data;

        public Node(int data,int level){
            this.data=data;
            this.level=level;
        }
    }



    static int minLevel=0;
    static int maxLevel=0;
    static HashMap<Integer,Node> hm= new HashMap<>();

    public void bottomView(TreeNode root, int hd, int currentLevel){

        if(root==null)
            return;
        if(hm.containsKey(hd)){
            if(currentLevel>hm.get(hd).level) {
                hm.get(hd).level = currentLevel;
                hm.get(hd).data = root.data;
            }
        }
        else
            hm.put(hd,new Node(root.data,currentLevel));
        minLevel=Math.min(minLevel,hd);
        maxLevel=Math.max(maxLevel,hd);
        bottomView(root.left,hd-1,currentLevel+1);
        bottomView(root.right,hd+1,currentLevel+1);
    }

    public void printBottomView(TreeNode root){
        bottomView(root,0,0);
        for(int i=minLevel;i<=maxLevel;i++){
            System.out.print(hm.get(i).data+" ");
        }
        System.out.println();

    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        printBottomView(root);
    }
}
