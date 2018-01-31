package test;

public class DoubleLinkedList {
	
	Node head;
	class Node{
		Node prev;
		Object data;
		Node next;
	
		Node(Object data){
			this.prev=null;
			this.data=data;
			this.next=null;
		}
	}
	public void add(Object data) {
		Node temp=new Node(data);
		if(this.head==null){
			head=temp;
		}
		else{
			Node current=head;
			while(current.next!=null){
				current=current.next;
			}
			temp.prev=current;
			current.next=temp;
		}
		
			
		
	}
	
	public void addinSortedList(Object data) {
		Node temp=new Node(data);
		if(this.head==null){
			head=temp;
			return;
		}
		if(head.data.hashCode() > data.hashCode())
        {
        
			temp.next=head;
			head.prev=temp;
			head=temp;
			return;
        }
			Node current=head;
			while(current.next!=null){
					if(current.next.data.hashCode()>data.hashCode() && current.data.hashCode()<data.hashCode()){
						temp.next=current.next;
						temp.prev=current.prev;
						current.next.prev=temp;
						current.next=temp;
						break;
					}
					current=current.next;
			}
			temp.prev=current;
			current.next=temp;
			
		}
	
	public void print() {
		Node current=head;
		while(current!=null){
				System.out.print(current.data+"\t");
				current=current.next;
		}
		System.out.println();
	}

	public void reverse() {
		Node current=head;
		Node temp=null;
		while(current!=null){
			temp=current.prev;
			current.prev=current.next;
			current.next=temp;
			current=current.prev;
		}
		if (temp != null) {
            head = temp.prev;
        }
	}

	public void printrev() {
		Node current=head;
		while(current.next!=null){
				current=current.next;
		}
		
		while(current!=null){
			System.out.print(current.data+"\t");
			current=current.prev;
	}
		System.out.println();
		
	}
}
