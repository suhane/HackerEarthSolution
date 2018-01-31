package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Stack; 

public class TextEditor {

	class InputReader{
		BufferedReader reader;
		StringTokenizer token;
		
		InputReader(InputStream stream){
			reader=new BufferedReader(new InputStreamReader(stream));
			token=null;
		}
		
		public String next(){
			while(token==null || !token.hasMoreTokens()){
				try {
					token=new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return token.nextToken();
		}
		public int nextInt(){
			return Integer.parseInt(next());
		}
	}
	public static void main(String args[]){
		InputStream stream=System.in;
		OutputStream outstream=System.out;
		InputReader in=new TextEditor().new InputReader(stream);
		PrintWriter out=new PrintWriter(outstream);
		int Q=in.nextInt();
		solve(Q,in,out);
		out.close();
		System.exit(0);
	}
	private static void solve(int q, InputReader in, PrintWriter out) {
		Stack<Integer> delStack=new Stack<Integer>();
		Stack<String> addStack=new Stack<String>();
		Stack<Integer> operationStack=new Stack<Integer>();
		StringBuilder s=new StringBuilder();
		String input;
		int deleteCount;
		while(q-->0){
			int op=in.nextInt();
			switch(op){
			case 1:
				input=in.next();
				delStack.push(input.length());
				operationStack.push(2);
				s.append(input);
				break;
			case 2:
				deleteCount=in.nextInt();
				String subsequence=s.substring(s.length()-deleteCount,s.length());
				addStack.push(subsequence);
				s.delete(s.length()-deleteCount, s.length());
				operationStack.push(1);
				break;
			case 3:
				int index=in.nextInt();
				out.println(s.charAt(index-1));
				break;
			case 4:
				int opCase=operationStack.pop();
				if(opCase==2){
					deleteCount=delStack.pop();
					s.delete(s.length()-deleteCount, s.length());
				}else{
					input=addStack.pop();
					s.append(input);
				}
				break;
			}
		}
		
		
		
	}
}
