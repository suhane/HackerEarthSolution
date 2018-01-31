package treesOneOnOne.geeksforgeeks.medium;
import org.junit.Test;
import treesOneOnOne.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderToBST {

    class Struct{
        TreeNode treeNode;
        int min;
        int max;

        public Struct(TreeNode treeNode,int min,int max){
            this.treeNode=treeNode;
            this.min=min;
            this.max=max;
        }
    }


    public TreeNode constructBst(int arr[], int n)
    {
        if(n==0)return null;
        // Code here
        int i=0;
        Queue<Struct> q= new LinkedList<Struct>();
        TreeNode root= new TreeNode(arr[i++]);
        q.offer(new Struct(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
        while(i!=n){

            Struct parent=q.poll();

            if(i<n&& arr[i]>parent.min && arr[i]<parent.treeNode.data){

                TreeNode tmp=new TreeNode(arr[i++]);
                q.offer(new Struct(
                                tmp,
                        parent.min,
                        parent.treeNode.data
                ));
                parent.treeNode.left=tmp;
            }
            if(i<n && arr[i]<parent.max && arr[i]>parent.treeNode.data){
                TreeNode tmp=new TreeNode(arr[i++]);
                q.offer(new Struct(
                        tmp,
                        parent.treeNode.data,
                        parent.max

                ));
                parent.treeNode.right=tmp;
            }


        }
        return root;
    }


    public  ArrayList<Integer> levelOrderTraversal(TreeNode a) {
        ArrayList<Integer> output= new ArrayList<Integer>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(a);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode tmp=q.poll();
            if(tmp!=null){
                if(tmp.left!=null)
                    q.offer(tmp.left);
                if(tmp.right!=null)
                    q.offer(tmp.right);
                System.out.print(tmp.data+" ");

            }else{
                if(!q.isEmpty())
                    q.offer(null);

            }
        }
        return output;

    }

    @Test
    public void test(){
        int arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        TreeNode root=constructBst(arr,arr.length);
        levelOrderTraversal(root);

    }
}
