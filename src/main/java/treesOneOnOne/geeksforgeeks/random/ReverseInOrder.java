package treesOneOnOne.geeksforgeeks.random;

import org.junit.Test;
import treesOneOnOne.TreeNode;

public class ReverseInOrder {

    class Sum{
        int sum;
        Sum(){
            this.sum=0;
        }
    }

    public void reverseInorder(TreeNode root, Sum sum){


        if(root!=null) {
            reverseInorder(root.right,sum);
            //System.out.print(root.data+ " ");
           int temp=root.data;
            if(sum.sum!=0)
                root.data=sum.sum;
            sum.sum= sum.sum+temp;
            reverseInorder(root.left,sum);
        }

    }

    public void printReverseInorder(TreeNode root){


        if(root!=null) {
            printReverseInorder(root.right);
            System.out.print(root.data+ " ");
            printReverseInorder(root.left);
        }

    }


    @Test
    public void test(){
        TreeNode root= new TreeNode(10);
        root.right=new TreeNode(18);
        root.left=new TreeNode(8);
        root.right.left=new TreeNode(14);
        root.right.right=new TreeNode(20);
        root.left.left=new TreeNode(6);
        root.left.right=new TreeNode(9);
        reverseInorder(root,new Sum());
        printReverseInorder(root);
    }
}
