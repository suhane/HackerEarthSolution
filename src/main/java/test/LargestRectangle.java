package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Stack;

public class LargestRectangle {

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
	public static void main(String[] args) {
		InputStream inputstream=System.in;
		OutputStream ouputstream= System.out;
		InputReader in=new LargestRectangle().new InputReader(inputstream);
		PrintWriter out=new PrintWriter(ouputstream);
		int length=in.nextInt();
		solve(length,in,out);
		out.close();
		System.exit(0);
	}
	private static void solve(int length, InputReader in, PrintWriter out) {
		int[] A=new int[length];
		int n=length;
		int index=0;
		while(n-->0)
			A[index++]=in.nextInt();
		Stack<Integer> s=new Stack<Integer>();
		int i=0;
		int maxArea=0;
		while(i<length){
			if(s.isEmpty() || A[s.peek()]<=A[i])
				s.push(i++);
			else{
				int top=s.pop();
				maxArea=Math.max(maxArea, A[top]*(s.isEmpty()?i:i-s.peek()-1));
			}
		}
		while(!s.isEmpty()){
			int top=s.pop();
			maxArea=Math.max(maxArea, A[top]*(s.isEmpty()?i:i-s.peek()-1));
		}
		out.println(maxArea);
		
	}
		
	}

