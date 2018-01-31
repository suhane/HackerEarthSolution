package treesOneOnOne.geeksforgeeks.cluster.views;

import org.junit.Test;
import treesOneOnOne.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

public class TopView {

    class LLNode{

        LLNode prev;
        LLNode next;
        int data;
        int level;

        public LLNode(int data,int level){
            prev=null;
            next=null;
            this.data=data;
            this.level=level;
        }
    }

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
    public void topView(TreeNode root,int hd, int currentLevel){

        if(root==null)
            return;
        if(!hm.containsKey(hd))
            hm.put(hd,new Node(root.data,currentLevel));
        else if(currentLevel<hm.get(hd).level){
            hm.get(hd).data=root.data;
            hm.get(hd).level=currentLevel;
        }
        minLevel=Math.min(minLevel,hd);
        maxLevel=Math.max(maxLevel,hd);
        topView(root.left,hd-1,currentLevel+1);
        topView(root.right,hd+1,currentLevel+1);
    }

    public void printTopView(TreeNode root){
        topView(root,0,0);
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
        printTopView(root);
        printTopView2(root);
    }

    private void printTopView2(TreeNode root) {

        LLNode llNode= new LLNode(root.data,0);
        printTopViewUtil(root,llNode,0);

        while (llNode.prev!=null){
            llNode=llNode.prev;
        }

        while (llNode!=null){
            System.out.print(llNode.data+" ");
            llNode=llNode.next;
        }

    }

    private void printTopViewUtil(TreeNode root, LLNode llNode, int currentLevel) {

        if(root==null)
            return;

        if(llNode==null)
            llNode=new LLNode(root.data,currentLevel);
        else {
            if(currentLevel<llNode.level){
                llNode.level=currentLevel;
                llNode.data=root.data;

            }
        }

        if(root.left!=null){

            if (llNode.prev==null){
                llNode.prev=new LLNode(root.left.data,currentLevel+1);
                llNode.prev.next=llNode;
            }
            printTopViewUtil(root.left,llNode.prev,currentLevel+1);

        }
        if (root.right!=null){
            if(llNode.next==null){
                llNode.next=new LLNode(root.right.data,currentLevel+1);
                llNode.next.prev=llNode;
            }
            printTopViewUtil(root.right,llNode.next,currentLevel+1);
        }

    }


}
