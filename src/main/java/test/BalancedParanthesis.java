package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashMap;


public class BalancedParanthesis {
	
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

		public Node peek() {
			return top;
		}

		public boolean isEmpty() {
			if(top==null)
				return true;
			return false;
		}
	}

	class InputReader{
		BufferedReader reader;
		StringTokenizer token;
		
		public InputReader(InputStream stream) {
			reader=new BufferedReader(new InputStreamReader(stream));
			token=null;
		}
		
		public String next(){
			while(token==null || !token.hasMoreTokens())
			try {
				token=new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return token.nextToken();
		}
		
		public int nextInt(){
			return Integer.parseInt(next());
		}
	}
	public static void main(String[] args) {
		
		
		
		InputStream inputstream =System.in;
		OutputStream outputstream =System.out;
		InputReader in=new BalancedParanthesis().new InputReader(inputstream);
		PrintWriter out=new PrintWriter(outputstream);
		int N=in.nextInt();
		solve(N,in,out);
		out.close();
		System.exit(0);
		
			
    }
	private static void solve(int n, InputReader in, PrintWriter out) {
		while(n-->0){
			String sequence=in.next();
			Stack s=new BalancedParanthesis().new Stack();
			HashMap<Character, Character> mapping=new HashMap<Character,Character>();
			mapping.put('(', ')');
			mapping.put('[', ']');
			mapping.put('{', '}');
			boolean done=false;
			for(char ch: sequence.toCharArray()){
				if(ch=='{' || ch=='[' || ch=='(')
					s.push(ch);
				else if(ch=='}' || ch==']' || ch==')'){
					if(s.peek()!=null){
						char parentheses=(char) s.peek().data;
						if(mapping.get(parentheses)==ch)
						s.pop();
						else{
							out.println("NO");
							done=true;
							break;
						}
					}
					else{
						out.println("NO");
						done=true;
						break;
						
						}
					}
					
			}
			if(!done)
				if(s.isEmpty())
					out.println("YES");
				else
					out.println("NO");
			}
			
		
		
	}
}
