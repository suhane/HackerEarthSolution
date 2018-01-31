package test;
import java.io.*;
import java.util.*;

public class MaximumElementStack {
	class InputReader{
		BufferedReader reader;
		StringTokenizer tokenizer;
		
		InputReader(InputStream stream){
			reader=new BufferedReader(new InputStreamReader(stream));
			tokenizer=null;
		}
		
		public String next(){
			while(tokenizer==null || !tokenizer.hasMoreElements()){
				try {
					tokenizer=new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		
		public int nextInt(){
			
			return Integer.parseInt(next());
		}
		
	}
	
	class Stack{
		
		Node top;
		int maxElement;
		
		class Node{
			Node next;
			int data;
			
			Node(int data){
				this.data=data;
				this.next=null;
			}
		}
		
		public void push(int data){
			Node temp=new Node(data);
			if(top==null){
				top=temp;
				maxElement=data;
				return;
			}
			if(data>maxElement)
				maxElement=data;
			temp.next=top;
			top=temp;
		}
		
		public void pop(){
			if(top==null)
				return;
			if(maxElement==top.data)
				findMaxElement();
			top=top.next;
		}

		private void findMaxElement() {
			Node start=top.next;
			if(start!=null)
				maxElement=start.data;
			while(start!=null){
				if(maxElement<start.data)
					maxElement=start.data;
				start=start.next;
			}
			
		}
	}
    public static void main(String[] args) {
        InputStream inputstream= System.in;
        OutputStream outputstream =System.out;
        InputReader in =new MaximumElementStack().new InputReader(inputstream);
        PrintWriter out=new PrintWriter(outputstream);
        int N=in.nextInt();
        solve(N,in,out);
        out.close();
        System.exit(0);
        
    }
	private static void solve(int n, InputReader in, PrintWriter out) {
		Stack s=new MaximumElementStack().new Stack();
		while(n-->0){
			int q=in.nextInt();
			if(q==1){
				int data=in.nextInt();
				s.push(data);	
			}
			if(q==2){
				s.pop();
			}
			if(q==3){
				out.println(s.maxElement);
			}
		}
		
	}
}