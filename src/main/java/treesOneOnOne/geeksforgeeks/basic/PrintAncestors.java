package treesOneOnOne.geeksforgeeks.basic;

import treesOneOnOne.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PrintAncestors {

    public boolean printAncestors(TreeNode root, int target){
        if(root==null)
            return false;
        if(root.data==target)
            return true;
        if(printAncestors(root.left,target) || printAncestors(root.right,target)){
            System.out.print(root.data+" ");
            return true;
        }
        return false;
    }

    public void printAncestorsIterative(TreeNode root, int target){
        Stack<TreeNode> s= new Stack<TreeNode>();
        Map<TreeNode,TreeNode> parent= new HashMap<TreeNode, TreeNode>();
        if(root!=null){
            s.push(root);
            parent.put(root,null);
        }
        while(!s.isEmpty()){
            TreeNode tmp=s.pop();
            if(tmp.right!=null){
                parent.put(tmp.right,tmp);
                s.push(tmp.right);
            }
            if(tmp.left!=null){
                parent.put(tmp.left,tmp);
                s.push(tmp.left);
            }

            if(tmp.data==target){

                TreeNode p= parent.get(tmp);
                while(p!=null){
                    System.out.print(p.data+" ");
                    p=parent.get(p);
                }
                break;
            }

        }
    }

    public static void main(String args[]) {


        /* Let us construct the tree shown in above diagram */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(5);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        System.out.println("---------Recursive approach------------");
        new PrintAncestors().printAncestors(root, 1);
        System.out.println();
        System.out.println("---------Iterative approach------------");
        new PrintAncestors().printAncestorsIterative(root, 1);

    }
}
