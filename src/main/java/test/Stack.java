package test;

public class Stack {
	private Node top;
	public class Node{
		private Object data;
		private Node next;
		public Node(Object data) {
			this.data=data;
			next=null;
		}
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	}
	public Object getTop() {
		return top;
	}
	public void setTop(Node top) {
		this.top = top;
	}
	public Object pop(){
		if(top==null){
			return null;
		}
		Node temp=top;
		top=top.next;
		return temp;
	}
	public void push(Object data){
		Node temp=new Node(data);
		if(top==null){
			top=temp;
			return;
		}
		temp.next=top;
		top=temp;
	}
	public void print(){
		Node temp=top;
		while(temp!=null){
			System.out.print(temp.getData() +"\t");
			temp=temp.next;
		}
		System.out.println();
		if(top!=null)
			System.out.println("Top= "+top.getData());
		
	}
	public boolean empty() {
		if (top==null)
			return true;
		else
			return false;
	}
}
