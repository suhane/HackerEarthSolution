package test;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

import org.w3c.dom.Node;

public class BinaryTree {
	
	
	
	private BinaryTreeNode root;
	
	public BinaryTree(){
		root=null;
	}
	public BinaryTree(int data){
		root=new BinaryTreeNode(data);
	}
	
	public class BinaryTreeNode{
		private int data;
		private BinaryTreeNode leftchild;
		private BinaryTreeNode rightchild;
		
		public BinaryTreeNode(int data){
			this.setData(data);
			leftchild=null;
			rightchild=null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public BinaryTreeNode getLeftchild() {
			return leftchild;
		}

		public void setLeftchild(BinaryTreeNode leftchild) {
			this.leftchild = leftchild;
		}

		public BinaryTreeNode getRightchild() {
			return rightchild;
		}

		public void setRightchild(BinaryTreeNode rightchild) {
			this.rightchild = rightchild;
		}
		
	}
	
	public BinaryTreeNode getRoot() {
		return root;
	}
	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}
	
	public void insert(int data){
		BinaryTreeNode temp=new BinaryTreeNode(data);
		if(root==null){
			root=temp;
			return;
		}
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		while(!q.isEmpty()){
			BinaryTreeNode tmp=q.poll();
			if(tmp!=null){
				if(tmp.leftchild==null){
					tmp.leftchild=temp;
					break;
				}
				else
					q.offer(tmp.leftchild);
				if(tmp.rightchild==null){
					tmp.rightchild=temp;
					break;
				}
				else
					q.offer(tmp.rightchild);
					
			}
			else{
				if(!q.isEmpty())
					q.offer(null);
			}
			}
		}
	
	public void levelordertraversal(){
		if(root==null)
			return;
		System.out.print(root.data+ " ");
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		while(!q.isEmpty()){
			BinaryTreeNode temp=q.poll();
			if(temp!=null){
				if(temp.leftchild!=null){
					q.offer(temp.leftchild);
					System.out.print(temp.leftchild.data+ " ");
				}
				if(temp.rightchild!=null){
					q.offer(temp.rightchild);
					System.out.print(temp.rightchild.data+ " ");
				}
			}
			else{
				if(!q.isEmpty())
					q.offer(null);
			}
		}
		System.out.println();
	}
	public void preordertravrsal() {
		if(root==null)
			return;
		Stack<BinaryTreeNode> s=new Stack<BinaryTreeNode>();
		s.push(root);
		while(!s.isEmpty()){
			BinaryTreeNode temp=s.pop();
			if(temp.rightchild!=null)
				s.push(temp.rightchild);
			if(temp.leftchild!=null)
				s.push(temp.leftchild);
			System.out.print(temp.data+ " ");
		}
		System.out.println();
		
		
	}
	public void inordertraversal() {
		if(root==null)
		return;
	Stack<BinaryTreeNode> s=new Stack<BinaryTreeNode>();
	BinaryTreeNode curr=root;
	boolean done=false;
	while(!done){
		if(curr!=null){
			s.push(curr);
			curr=curr.leftchild;
		}
		else{
			if(s.empty())
				done=true;
			else{
				curr=s.pop();
				System.out.print(curr.data+" ");
				curr=curr.rightchild;
			}
		}
		
	}
	System.out.println();
		
	}
	public void postordertraversal() {
		if(root==null)
			return;
		Stack<BinaryTreeNode> s=new Stack<BinaryTreeNode>();
		BinaryTreeNode prev=null;
		s.push(root);
		while(!s.empty()){
			BinaryTreeNode curr=s.peek();
			if(prev==null || prev.leftchild==curr || prev.rightchild==curr){
				if(curr.leftchild!=null)
					s.push(curr.leftchild);
				else if (curr.rightchild!=null)
					s.push(curr.rightchild);
				
			}
			else{
				if(curr.leftchild==prev){
					if(curr.rightchild!=null)
						s.push(curr.rightchild);
				}
				else{
					s.pop();
					System.out.print(curr.data+" ");
				}
			}
			prev=curr;
			
		}
		System.out.println();
		
	}
	
	public BinaryTreeNode mirror(BinaryTreeNode root){
		BinaryTreeNode temp;
		if(root!=null){
			mirror(root.leftchild);
			mirror(root.rightchild);
			temp=root.leftchild;
			root.leftchild=root.rightchild;
			root.rightchild=temp;
		}
		return root;
			
		}
	
	public boolean areMirrors(BinaryTreeNode root1 , BinaryTreeNode root2){
		if(root1==null && root2==null)
			return true;
		if(root1==null || root2==null)
			return false;
		if(root1.data!=root2.data)
			return false;
		else return (areMirrors(root1.leftchild, root2.rightchild) && areMirrors(root1.rightchild, root2.leftchild));
			
		}
	
		
}
