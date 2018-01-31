package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Stack;

public class ImplementQ {
	class InputReader{
		BufferedReader reader;
		StringTokenizer token;
		
		public InputReader(InputStream stream){
			reader=new BufferedReader(new InputStreamReader(stream));
			token=null;
		}
		
		public String next(){
			while(token==null || !token.hasMoreTokens()){
				try {
					token=new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return token.nextToken();
		}
		
		public int nextInt(){
			return Integer.parseInt(next());
		}
	}
	
	public static void main(String args[]){
		InputStream ins=System.in;
		OutputStream ous=System.out;
		InputReader in=new ImplementQ().new InputReader(ins);
		PrintWriter out=new PrintWriter(ous);
		int n=in.nextInt();
		solve(n,in,out);
		out.close();
		System.exit(0);
	}

	private static void solve(int n, InputReader in, PrintWriter out) {
		Stack<Integer> s1=new Stack<Integer>();
		Stack<Integer> s2=new Stack<Integer>();
		while(n-->0){
			int q=in.nextInt();
			switch(q){
			case 1:
				s1.add(in.nextInt());
				break;
			case 2:
				poll(s1,s2);
				break;
			case 3:
				out.println(peek(s1,s2));
				break;
				
			}
		}
		
	}

	private static int peek(Stack<Integer> s1, Stack<Integer> s2) {
		if(s2.isEmpty())
			while(!s1.empty())
				s2.add(s1.pop());
		return s2.peek();
		
	}

	private static void poll(Stack<Integer> s1, Stack<Integer> s2) {
		if(s2.isEmpty())
			while(!s1.empty())
				s2.add(s1.pop());
		s2.pop();
		
	}
}
