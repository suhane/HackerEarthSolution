package treesOneOnOne.geeksforgeeks.easy;

import org.junit.Test;
import treesOneOnOne.TreeNode;

public class DeleteAndShink {


    static TreeNode deepestNodeParent=null;
    static int maxLevel=0;

    public void deletionBT(TreeNode root, int key){

        searchFordeepestNodeParent(root, null,1);
        int keyToReplace;
        if(deepestNodeParent!=null){
            if(deepestNodeParent.right==null){
                keyToReplace=deepestNodeParent.left.data;
                deepestNodeParent.left=null;
            }
            else{
                keyToReplace=deepestNodeParent.right.data;
                deepestNodeParent.right=null;
            }
            replaceNode(root,key,keyToReplace);
        }
        printInOrder(root);


    }

    private void printInOrder(TreeNode root) {
        if(root==null)
            return;
        printInOrder(root.left);
        System.out.print(root.data+" ");
        printInOrder(root.right);
    }

    private void replaceNode(TreeNode root, int key, int keyToReplace) {

        if(root==null)
            return;
        if(root.data==key){
            root.data=keyToReplace;
            return;
        }
        replaceNode(root.left,key,keyToReplace);
        replaceNode(root.right,key,keyToReplace);
    }

    private void searchFordeepestNodeParent(TreeNode root, TreeNode parent, int currLevel) {

        if(root==null)
            return;
        if(root.left==null && root.right==null){
            if(currLevel>=maxLevel){
                deepestNodeParent=parent;
                maxLevel=currLevel;
            }
        }
        searchFordeepestNodeParent(root.left,root,currLevel+1);
        searchFordeepestNodeParent(root.right,root,currLevel+1);

    }

    @Test
    public void test1(){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        deletionBT(root,4);
        System.out.println();

    }

    @Test
    public void test2(){

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(30);
        root.left.left.left = new TreeNode(40);
        root.left.left.right= new TreeNode(50);
        root.left.left.left.left=new TreeNode(60);
        root.left.left.left.left.right=new TreeNode(70);
        root.left.left.left.left.right.left=new TreeNode(80);
        deletionBT(root,40);
        System.out.println();

    }

    @Test
    public void test3(){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        deletionBT(root,6);
        System.out.println();

    }
}
