package CreditSuisse;

// Java program to print all nodes that don't have sibling

// A binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        if(this==null)
            return null;
        sb.append("[data="+this.data);
        if(this.left!=null)
            sb.append(" left="+this.left.data);
        else
            sb.append(" left=null");
        if(this.right!=null)
            sb.append(" right="+this.right.data);
        else
            sb.append(" right=null");
        return sb.toString();
    }
}

class BinaryTree
{
    Node root;

    /* This function prints all nodes that are distance k from a leaf node
    path[] --> Store ancestors of a node
    visited[] --> Stores true if a node is printed as output. A node may
    be k distance away from many leaves, we want to print it once */
    void kDistantFromLeafUtil(Node node, int path[], boolean visited[],
                              int pathLen, int k)
    {
        // Base case
        if (node == null)
            return;

		/* append this Node to the path array */
        path[pathLen] = node.data;
        visited[pathLen] = false;

		/* it's a leaf, so print the ancestor at distance k only
		if the ancestor is not already printed */
        if (node.left == null && node.right == null
                && pathLen - k >= 0 && visited[pathLen - k] == false)
        {
            System.out.print(path[pathLen - k] + " ");
            visited[pathLen - k] = true;
            return;
        }

		/* If not leaf node, recur for left and right subtrees */
        kDistantFromLeafUtil(node.left, path, visited, pathLen+1, k);
        kDistantFromLeafUtil(node.right, path, visited, pathLen+1, k);
    }

    /* Given a binary tree and a nuber k, print all nodes that are k
    distant from a leaf*/
    void printKDistantfromLeaf(Node node, int k)
    {
        int path[] = new int[1000];
        boolean visited[] = new boolean[1000];
        kDistantFromLeafUtil(node, path, visited, 0, k);
    }

    // Driver program to test the above functions
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();

		/* Let us construct the tree shown in above diagram */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);

        System.out.println(" Nodes at distance 1 are :");
        tree.printKDistantfromLeaf(tree.root, 1);
    }
}
