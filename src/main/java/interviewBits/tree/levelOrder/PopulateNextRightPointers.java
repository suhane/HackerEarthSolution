package interviewBits.tree.levelOrder;

import interviewBits.tree.TreeLinkNode;
import interviewBits.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by labuser on 7/31/17.
 */
public class PopulateNextRightPointers {

    public static void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q= new LinkedList<TreeLinkNode>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            TreeLinkNode tmp=q.poll();
            if(tmp!=null){
                if(tmp.left!=null)
                    q.add(tmp.left);
                if(tmp.right!=null)
                    q.add(tmp.right);
                tmp.next=q.peek();
            }
            else{
                if(!q.isEmpty())
                    q.offer(null);
            }
        }

    }

    public static void main(String args[]) {


        /* Let us construct the tree shown in above diagram */
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        connect(root);
    }

}
