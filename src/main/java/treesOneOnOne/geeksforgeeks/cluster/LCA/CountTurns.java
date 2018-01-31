package treesOneOnOne.geeksforgeeks.cluster.LCA;
import treesOneOnOne.TreeNode;
/*
Case 1:
If none of the nodes is equal to
LCA, we get these nodes either on
the left side or right side.
We call two functions for each node.
....a)  if (CountTurn(LCA->right, first,
                          false, &Count)
        || CountTurn(LCA->left, first,
                          true, &Count)) ;
....b)  Same for second node.
....Here Count is used to store number of
turns need to reached the target node.

Case 2:
If one of the nodes is equal to LCA_Node.
Then we count only number of turns needs
to reached the second node.
If LCA == (Either first or second)
....a)  if (countTurn(LCA->right, second/first,
                                false, &Count)
         || countTurn(LCA->left, second/first,
                              true, &Count)) ;

*/

public class CountTurns {

    static int count=0;
    private boolean countTurns(TreeNode root, int key, boolean turn){

        if(root==null)
            return false;

        if(root.data==key)
            return true;

        if(turn){

            if(countTurns(root.left,key,turn))
                return true;
            else{
                if(countTurns(root.right,key,!turn)){
                    count++;
                    return true;
                }
            }
        }
        else {

            if(countTurns(root.right,key,turn))
                return true;
            else{
                if(countTurns(root.left,key,!turn)){
                    count++;
                    return true;
                }
            }

        }
        return false;
    }

    public int numOfTurns(TreeNode root, int first, int second ) {

        TreeNode lca= new LCA().findLCA2(root,first,second);
        if(lca==null)
            return -1;
        // case 1:
        if (lca.data != first && lca.data != second) {

            if (countTurns(lca.right, second, false) || countTurns(lca.left, second, true));
            if (countTurns(lca.left, first, true) || countTurns(lca.right, first, false));
            return count+1;
        }

        if (lca.data == first) {

            countTurns(lca.right, second, false);
            countTurns(lca.left, second, true);
            return count;
        }
        else {
            countTurns(lca.right, first, false);
            countTurns(lca.left, first, true);
               return count;
        }
    }
}
