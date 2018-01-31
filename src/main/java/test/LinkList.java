package test;

import javax.management.RuntimeErrorException;

public class LinkList {

	private Node head;
	public class Node{
		private int data;
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		private Node next;
		
		Node(int data){
			this.data=data;
			this.next=null;
		}
		@Override
		public boolean equals(Object other) {
		    if (!(other instanceof Node)) {
		        return false;
		    }

		    Node that = (Node) other;
		    
		    if(this.next==null || that.next==null)
		    	return true && this.data==that.data;
		    
		    return this.data==that.data && this.next.equals(that.next);
		}
	}


	
public Node getHead(){
	return head;
}	

public void setHead(Node head){
	this.head=head;
}
public void print(){
	Node current=head;
	if(head==null){
		System.out.print("The list is empty");
	}
	while(current!=null){
		System.out.print(current.data+"\t");
		current=current.next;
	}
	System.out.println();
	
}	

public int size(){
	int size=0;
	Node temp=head;
	if(head==null)
		return 0;
	while(temp!=null){
		temp=temp.next;
		size++;
	}
	return size;
}

public void add(int data){
	Node newnode=new Node(data);
	if(head==null){
		head=newnode;
		return;
	}
	Node current=head;
	while(current.next!=null){
		current=current.next;
	}
	current.next=newnode;
}

public void add(int data, int pos){
	Node newnode=new Node(data);
	if(pos<0 || pos>this.size()){
		throw new RuntimeException("Invalid index. Index should be greater than -1 and less than size of list");
	}
	if(pos==0){
		newnode.next=head;
		head=newnode;
		return;
	}
	Node current=head;
	int currentpos=0;
	while(currentpos++<pos-1){
		current=current.next;
	}
	newnode.next=current.next;
	current.next=newnode;
}
void remove(int pos){
	if(head==null)
		throw new RuntimeException("The list is empty.");	
	if(pos<0 || pos>this.size())
		throw new RuntimeException("Position specified is beyond the range. Size is "+this.size()+" Position is "+pos);
	if(this.size()==1){
		if(pos==0){
			head=null;
			return;
		}
		else{
			throw new RuntimeException("Size is 1 so position can be nothing other than 0");
		}
	}
	if(pos==0){
		head=head.next;
		return;
	}
	Node current =head;
	int currentpos=0;
	while(currentpos++<pos-1){
		current=current.next;
	}
	current.next=current.next.next;
}

void removeLastElement(){
	if(head==null){
		throw new RuntimeException("The list is empty.");
	}
	Node current=head;
	if(this.size()==1){
		head=null;
		return;
	}
	
	while(current.next.next!=null){
		current=current.next;
	}
	current.next=null;
}

int compareLinkLists(LinkList list){
	Node Head1=this.head;
	Node Head2=list.getHead();
	Node temp1=Head1;
	Node temp2=Head2;
	if ((Head1==null || Head2==null) && (Head1!=Head2)){
		return 0;
	}
	if(Head1==null && Head2==null){
		return 1;
	}
	int temp1count=0;
	int temp2count=0;
	while(temp1!=null && temp2!=null){
		if(temp1.data!=temp2.data){
			return 0;
		}
		else{
			temp1=temp1.next;
			temp2=temp2.next;			
		}
		if(temp1!=null)
			temp1count++;
		if(temp2!=null)
			temp2count++;
	}
	if(temp1count==temp2count){
		return 1;
	}
	else return 0;
}
public void reverse(){
	if(head==null)
	       return;
	if(head.next ==null)
	       return;
	Node next=head.next;
    Node prev=null;
    
  
    while(next!=null)
        {
          head.next=prev;
          prev=head; 
          head=next;
          next=next.next;
        
    }
    
    head.next=prev;
}

public int get(int index){
	Node temp=head;
	int currentindex=0;
	while(currentindex++<index)
		temp=temp.next;
	return temp.data;
}

public void sort() {
	Node temp =head;
	while(temp!=null){
		Node current=temp;
		while(current!=null){
			if(current.data<temp.data){
				int tem=current.data;
				current.data=temp.data;
				temp.data=tem;
			}
		current=current.next;
		}
		temp=temp.next;
		
	}
}

public void merge(LinkList list) {
	if(head==null){
        head=list.getHead();
        return;
    }
	if(list.getHead().data<head.data){
		Node temp=list.getHead();
		list.setHead(list.getHead().next);
		temp.next=head;
		head=temp;
		
	}
	Node source=head;
	Node client=list.getHead();
	while(source!=null && client!=null){
		if(source.next==null){
			source.next=client;
			return;
		}
		if(client.data<source.next.data){
			Node temp=client;
			client=client.next;
			temp.next=source.next;
			source.next=temp;
			
		}
		source=source.next;
	}
	
}

public Node merge2(Node headA, Node headB) {
 if(headA==null || headB==null)
	 return headA!=null?headA:headB;
 Node base,toMerge;
 if(headA.data<headB.data){
	 base=headA;
	 toMerge=headB;
 }
 else{
	 base=headB;
	 toMerge=headA;
 }
 while(base.next!=null || toMerge.next!=null){
	 Node start=toMerge;
	 Node prevbase=base;
	 while(toMerge.next!=null && toMerge.next.data<base.next.data){
		 toMerge=toMerge.next;
	 }
	 base=base.next;
	 toMerge.next=base.next;
	 prevbase.next=start;
 }
 if(toMerge.next!=null){
	 base.next=toMerge;
 }
 return base;
	 
 
}

Node MergeLists(Node headA, Node headB) {
	if(headA==null){
        headA=headB;
        return headA;
    }
	if(headB.data<headA.data){
		Node temp=headB;
		headB=headB.next;
		temp.next=headA;
		headA=temp;
		
	}
    
    
	Node source=headA;
	Node client=headB;
	while(source!=null && client!=null){
		if(source.next==null){
			source.next=client;
			break;
		}
		if(client.data<source.next.data){
			Node temp=client;
			client=client.next;
			temp.next=source.next;
			source.next=temp;
			
		}
		source=source.next;
	}
    return headA;

}

public int getNodeFromtail(int pos) {
	Node current=head;
	int count=0;
	while(current!=null){
		count++;
		current=current.next;
	}
	int requiredIndex=count-pos;
	current=head;
	while(--requiredIndex>0){
		current=current.next;
	}
	return current.data;
}

public void removeDuplicates() {
	Node current=head;
	while(current!=null){
		Node tempcurrent=current;
			while(tempcurrent.next!=null)
			{
				if(tempcurrent.data==tempcurrent.next.data)
					tempcurrent=tempcurrent.next;
				else
					break;
			}
		current.next=tempcurrent.next;
		current=current.next;
	}
}


public int findMergePoint(LinkList list) {
	int countA=this.size();
	int countB=list.size();
	Node tempA=this.head;
	Node tempB=list.getHead();
	if(countA>countB){
		int i=0;
		while(i++<(countA-countB)){
			tempA=tempA.next;
		}
	}
	if(countB>countA){
		int i=0;
		while(i++<(countB-countA)){
			tempB=tempB.next;
		}
	}
	while(tempA!=null && tempB!=null){
		tempA=tempA.next;
		tempB=tempB.next;
		if(tempA.equals(tempB))
			return tempA.data;
	}
	return -1;
}


public void swap(int x, int y){
	
		
		Node prevX=null;
		Node currX=head;
		while(currX!=null && currX.data!=x){
			prevX=currX;
			currX=currX.next;
		}
		
		Node prevY=null;
		Node currY=head;
		while(currY!=null && currY.data!=y){
			prevY=currY;
			currY=currY.next;
		}
		
		if(currX==null || currY==null)
			return;
		
		if(prevX==null){
			head=currY;
			prevY.next=currX;
		}
		else{
			prevX.next=currY;
		}
		
		if(prevY==null){
			head=currX;
			prevX.next=currY;
		}
		else{
			prevY.next=currX;
		}
		
		Node temp=currX.next;
		currX.next=currY.next;
		currY.next=temp;
		
	
}
/*
public int countMatchingWords(String word) {
	Node current=head;
	int count=0;
	while(current!=null){
		if(current.data.toString().contains(word)){
			count++;
		}
		current=current.next;
	}
	return count;
	
}
*/
public void println() {
	Node current=head;
	if(head==null){
		System.out.print("The list is empty");
	}
	while(current!=null){
		System.out.println(current.data);
		current=current.next;
	}
	
}

public String toString(){
 if(this.size()==0)
	 return "[]";
 StringBuilder sb = new StringBuilder();
 sb.append('[');
 Node iter=this.head;
 while(iter!=null){
	 sb.append(iter.data);
	 iter=iter.next;
	 if(iter!=null)sb.append(',').append(' ');
	 
 }
sb.append("]");	 
 
return sb.toString();	 
}

public int getElemFromLast(int i) {
	Node curr0=head;
	int index=1;
	while(index++<i){
		if(curr0!=null)
			curr0=curr0.next;	
	}
	
	Node curr=null;
	while(curr0!=null){
		if(curr==null)
			curr=head;
		else
			curr=curr.next;
		curr0=curr0.next;
		
	}
	if(curr!=null)
		return curr.data;
	throw new RuntimeException("Index out of bound");

}

}