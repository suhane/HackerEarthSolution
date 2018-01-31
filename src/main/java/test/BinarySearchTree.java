package test;
import java.util.LinkedList;
public class BinarySearchTree{
	
	private Node root;
	class Node{
		int data;
		Node left;
		Node right;
		
		
		public Node(int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	


public Node findElement(int data){

	if(root==null)
		return null;
	Node current=root;
	while(current!=null){
		if(data==current.data)
			return current;
		else if(data<current.data)
			current=current.left;
		else
			current=current.right;
	}
	return null;
}

public Node findMin(){
	if(root==null)
		return null;
	Node current=root;
	while(current.left!=null)
		current=current.left;
	return current;
}

public Node findMax(){
	if(root==null)
		return null;
	Node current=root;
	while(current.right!=null)
		current=current.right;
	return current;
}

public Node findMax(Node root){
	if(root==null)
		return null;
	Node current=root;
	while(current.right!=null)
		current=current.right;
	return current;
}

public void insert(int data){
	Node node=new Node(data);
	if(root==null)
		root=node;
	else{
		Node current=root;
		while(current!=null){
			if(data<current.data){
				if(current.left==null){
					current.left=node;
					return;
				}
				else current=current.left;
			}
				
			else {
				if(current.right==null){
					current.right=node;
					return;
				}
				else current=current.right;
			}
				
			
		}
	}
}

static Node lca(Node root,int v1,int v2)
{
if(root==null)
	return null;
if(root.data==v1 || root.data==v2)
	return root;

	if(Math.max(v1, v2)<root.data){
		return lca(root.right,v1,v2);
	}else if (Math.max(v1, v2)>root.data){
		return lca(root.left,v1,v2);
	}else
		return root;

   
}

static Node sortedListToBST(LinkedList<Integer> list)
{
	return construct(list.element(),0,list.size()-1);
	
	
}



private static Node construct(Integer element, int i, int j) {
	// TODO Auto-generated method stub
	return null;
}

public void delete(int data){
	if(root==null)
		return;
	Node current=root;
	while(current!=null && current.data!=data){
		if(data<current.data)
			current=current.left;
		else
			current=current.right;
	}
	if(current==null){
		System.out.println(data+ " not found in the tree");
		return;
	}
	else{
		if(current.left!=null && current.right!=null){
			Node leftsubtree=current.left;
			while(leftsubtree.right!=null && leftsubtree.right.right!=null)
				leftsubtree=leftsubtree.right;
			current.data=leftsubtree.right.data;
			
		}
			
		
	}
	
	
		
	
}




public static void main(String args[]){
	BinarySearchTree bst=new BinarySearchTree();
	bst.insert(9);
	bst.insert(11);
	bst.insert(6);
	bst.insert(4);
	bst.insert(7);
	bst.insert(8);
	bst.insert(13);
	bst.insert(3);
	bst.insert(5);
	System.out.println(bst.findElement(8).right.data);
}

}