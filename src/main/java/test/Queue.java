package test;

public class Queue {
	
	private Node rear;
	private Node front;
	
	public class Node{
		private Object data;
		private Node next;
		
		public Node(Object data){
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
	public Node getRear() {
		return rear;
	}
	public void setRear(Node rear) {
		this.rear = rear;
	}
	public Node getFront() {
		return front;
	}
	public void setFront(Node front) {
		this.front = front;
	}
	
	public void enqueue(Object data){
		Node temp=new Node(data);
		if(rear==null){
			rear=temp;
			front=temp;
			return;
		}
		temp.next=front;
		front=temp;
		
	}
	public void dequeue(){
		if(rear==front){
			rear=null;
			front=null;
			return;
		}
		Node temp=front;
		while(temp.next!=rear){
			temp=temp.next;
		}
		temp.next=null;
		rear=temp;
		
	}
	public void print() {
		Node temp=front;
		if(temp==null)
			return;
		while(temp!=rear){
			System.out.print(temp.data+ "\t");
			temp=temp.next;
		}
		System.out.print(temp.data+ "\t");
		System.out.println();
		System.out.println("Front= " +front.getData()+" Rear= "+rear.getData());
	}
}
