package treesOneOnOne.geeksforgeeks.cluster.LCA;

import treesOneOnOne.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LCA {



    private boolean findPath(TreeNode root, int target, List<Integer> path){

        if(root==null)
            return false;
        path.add(root.data);
        if(root.data==target){
            return true;
        }

        if(findPath(root.left,target,path)){
            return true;
        }
        if(findPath(root.right,target,path)){
            return true;
        }
        path.remove(path.size()-1);
        return false;

    }

    public int findLCA(TreeNode root, int n1, int n2){

        List<Integer> path1=new ArrayList<>();
        List<Integer> path2=new ArrayList<>();

        if(!findPath(root,n1,path1) || !findPath(root,n2,path2)){
            System.out.print("The target node is not present in the tree");
        }

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            //  System.out.println(path1.get(i) + " " + path2.get(i));
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }

        return path1.get(i-1);
    }

    public TreeNode findLCA2(TreeNode root,int n1, int n2){


        if(root==null)
            return null;
        if(root.data==n1 || root.data==n2)
            return root;

        TreeNode left=findLCA2(root.left,n1,n2);
        TreeNode right=findLCA2(root.right,n1,n2);

        if(left!=null && right!=null)
            return root;

        return left==null?right:left;



    }


}
