package test;

import java.util.Scanner;

public class MySolution {
	
	class Linklist {

		private Node head;
		class Node{
			Object data;
			Node next;
			
			Node(Object data){
				this.data=data;
				this.next=null;
			}
			
		}
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
		public void add(Object data){
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
	}
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
        Scanner sc=new Scanner(System.in);
        MySolution s=new MySolution();
        Linklist list=s.new Linklist();
        Linklist outputList=s.new Linklist();
        int noOfArgs=sc.nextInt();
        String op = null;
        String word = null;
        for(int i=0;i<noOfArgs;i++){        	
        	op=sc.next();
        	word=sc.next();
        	if(op.equals("add")){
        		list.add(word);
        	}
        	else{
        		outputList.add(list.countMatchingWords(word));
        	}
        }
        outputList.println();
        System.out.println("Time : "+(System.currentTimeMillis()-startTime)+"ms");  
    }
}
	
	