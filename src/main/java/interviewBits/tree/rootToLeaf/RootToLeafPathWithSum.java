package interviewBits.tree.rootToLeaf;

import interviewBits.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by labuser on 8/1/17.
 */
public class RootToLeafPathWithSum {

    static ArrayList<ArrayList<Integer>> output =new ArrayList<ArrayList<Integer>>();
    public  static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> output =new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return output;
        Queue<ArrayList<Integer>> elems = new LinkedList<ArrayList<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        elems.offer(new ArrayList<Integer>(Arrays.asList(root.val)));
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            ArrayList<Integer> temp=elems.poll();
            if (tmp.left != null) {
                ArrayList<Integer> left= (ArrayList<Integer>) temp.clone();
                left.add(tmp.left.val);
                tmp.left.val += tmp.val;
                q.offer(tmp.left);
                elems.offer(left);
            }
            if (tmp.right != null) {
                ArrayList<Integer> right= (ArrayList<Integer>) temp.clone();
                right.add(tmp.right.val);
                tmp.right.val += tmp.val;
                q.offer(tmp.right);
                elems.offer(right);

            }
            if (tmp.right == null && tmp.left == null && tmp.val == sum){
                output.add(temp);
            }
        }
        return output;
    }

    public static ArrayList<ArrayList<Integer>> pathSumRecursive(TreeNode root, int sum) {
        ArrayList<Integer> list= new ArrayList<Integer>();
        if(root ==null)
            return output;
        else {
            pathSumR(root, list, sum);
            return output;
        }
    }

    private static void pathSumR(TreeNode a, ArrayList<Integer> list, int sum) {

        if(a==null)
            return;
        list.add(a.val);
        if(a.left==null && a.right==null && a.val==sum){
            ArrayList<Integer> set= (ArrayList<Integer>) list.clone();
            output.add(set);
            list.remove(list.size()-1);
            return;
        }
        pathSumR(a.left,list,sum-a.val);
        pathSumR(a.right,list,sum-a.val);
        list.remove(list.size()-1);


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


        System.out.println(pathSum(root, 22));
    }
}
