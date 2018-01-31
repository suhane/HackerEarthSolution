package interviewBits.tree.linkedListTree;

import interviewBits.tree.TreeNode;

import java.util.Stack;

/**
 * Created by labuser on 8/8/17.
 */
public class FlattenBinaryTrre {

    public TreeNode flatten(TreeNode a) {

        Stack<TreeNode> s= new Stack<TreeNode>();
        if(a==null)
            return a;
        if(a.left==null && a.right==null)
            return a;
        s.push(a);
        TreeNode root=a;
        TreeNode curr=a;
        while(!s.isEmpty()){
            TreeNode aux=s.pop();
            if(aux.right!=null)
                s.push(aux.right);
            if(aux.left!=null)
                s.push(aux.left);
            curr.right=aux;
            curr.left=null;
            curr=curr.right;
        }

        return root;
    }

    public static void main(String[] args)
    {
        FlattenBinaryTrre tree = new FlattenBinaryTrre();
        TreeNode root = new TreeNode(47);
        root.left = null;
        root.right = null;
        /*
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);*/

        System.out.print(tree.flatten(root));
    }
}
