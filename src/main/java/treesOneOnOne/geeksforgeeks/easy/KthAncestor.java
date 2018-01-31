package treesOneOnOne.geeksforgeeks.easy;

import treesOneOnOne.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class KthAncestor {

    public TreeNode printKthAncestor(TreeNode root, TreeNode a, int k){
        Stack<TreeNode> s= new Stack<TreeNode>();
        Map<TreeNode,TreeNode> parent=new HashMap<TreeNode, TreeNode>();
        if(root!=null)
            s.push(root);
        parent.put(root,null);
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

            if(tmp==a){
                TreeNode p=parent.get(tmp);
                k--;
                while(p!=null && k>0){
                    p=parent.get(p);
                    k--;
                }
                return p;
            }

        }
        return null;

    }
}
