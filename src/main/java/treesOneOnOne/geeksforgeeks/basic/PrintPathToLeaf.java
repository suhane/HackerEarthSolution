package treesOneOnOne.geeksforgeeks.basic;

import treesOneOnOne.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PrintPathToLeaf {



    public void printPath(TreeNode root){
        printPathUtil(root,"");
    }

    private void printPathUtil(TreeNode root, String s) {

        if(root==null)
            return;
        if(root.left==null && root.right==null) {
            System.out.print(s + root.data);
            System.out.println();
            return;
        }
        printPathUtil(root.left,s+root.data+" ");
        printPathUtil(root.right,s+root.data+" ");
    }

    public void printPathIterative(TreeNode root){
        Stack<TreeNode> s= new Stack<TreeNode>();
        Map<TreeNode, TreeNode> parent=new HashMap<TreeNode, TreeNode>();
        parent.put(root,null);
        if(root!=null)
            s.push(root);
        while (!s.isEmpty()){
            TreeNode temp= s.pop();
            if(temp.left==null && temp.right==null){
                printTopToBottomPath(temp, parent);
            }
            if(temp.right!=null){
                parent.put(temp.right,temp);
                s.push(temp.right);
            }
            if(temp.left!=null){
                parent.put(temp.left,temp);
                s.push(temp.left);
            }



        }
    }

    private void printTopToBottomPath(TreeNode temp, Map<TreeNode, TreeNode> parent) {

        Stack<Integer> s= new Stack<Integer>();
        s.push(temp.data);
        TreeNode p=parent.get(temp);
        while(p!=null){

            s.push(p.data);
            p=parent.get(p);
        }

        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
        System.out.println();
    }


    public static void main(String s[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left=new TreeNode(6);

        System.out.println("---------Recursive approach------------");
        new PrintPathToLeaf().printPath(root);
        System.out.println("---------Iterative approach------------");
        new PrintPathToLeaf().printPathIterative(root);

    }
}
