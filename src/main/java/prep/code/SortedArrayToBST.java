package prep.code;

import java.util.ArrayList;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data=data;
    }
}
public class SortedArrayToBST {

    public static void main(String args[]){

        int[] arr={1,2,3};
        ArrayList<TreeNode> list=constructBST(1,3);
        System.out.println(list);

    }

    public static ArrayList<TreeNode> constructBST(int[] arr,int start, int end){

        ArrayList<TreeNode> list= new ArrayList<TreeNode>();

        if(start>end)
            return list;

        for(int i=start;i<=end;i++) {

            ArrayList<TreeNode> leftSubTree = constructBST(arr,start,i-1 );
            ArrayList<TreeNode> rightSubTree= constructBST(arr,i+1,end);

            for(int j=0;j<leftSubTree.size();j++){


                TreeNode left=leftSubTree.get(j);
                for(int k=0;k<rightSubTree.size();k++){

                    TreeNode root= new TreeNode(arr[i]);
                    TreeNode right=rightSubTree.get(k);
                    root.left=left;
                    root.right=right;
                    list.add(root);
                }
            }
        }

        return list;


    }

    public static ArrayList<TreeNode> constructBST(int start, int end){

        ArrayList<TreeNode> list= new ArrayList<TreeNode>();

        if(start>end)
            return list;

        for(int i=start;i<=end;i++) {

            ArrayList<TreeNode> leftSubTree = constructBST(start,i-1 );
            ArrayList<TreeNode> rightSubTree= constructBST(i+1,end);

            for(int j=0;j<leftSubTree.size();j++){


                TreeNode left=leftSubTree.get(j);
                for(int k=0;k<rightSubTree.size();k++){

                    TreeNode root= new TreeNode(i);
                    TreeNode right=rightSubTree.get(k);
                    root.left=left;
                    root.right=right;
                    list.add(root);
                }
            }
        }

        return list;


    }
}
