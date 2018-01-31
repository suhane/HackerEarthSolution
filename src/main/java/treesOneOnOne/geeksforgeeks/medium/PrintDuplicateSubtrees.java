package treesOneOnOne.geeksforgeeks.medium;

import org.junit.Test;
import treesOneOnOne.TreeNode;
import java.util.HashMap;
import java.util.HashSet;

public class PrintDuplicateSubtrees {

    static HashSet<String> output= new HashSet<>();
    static HashMap<String,Integer> hm = new HashMap<String, Integer>();

    public String inOrder(TreeNode root){

        if(root==null)
            return "";
        String str="(";
        str+=inOrder(root.left);
        str+=root.data;
        str+=inOrder(root.right);
        str+=")";

        if(hm.containsKey(str) && hm.get(str)==1){
            output.add(str);
        }
        if(!hm.containsKey(str))
            hm.put(str,1);
         return str;

    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        inOrder(root);


    }



}
