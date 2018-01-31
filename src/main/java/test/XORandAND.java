package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Stack;

public class XORandAND {
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
		InputStream stream =System.in;
		OutputStream outputstream=System.out;
		InputReader in= new XORandAND().new InputReader(stream);
		PrintWriter out=new PrintWriter(outputstream);
		int n=in.nextInt();
		solve(n,in,out);
		out.close();
		System.exit(0);
		
	}

	private static void solve(int n, InputReader in, PrintWriter out) {
		int[] numbers=new int[n]; 
		for(int i=0;i<n;i++)
			numbers[i]=in.nextInt();
		Stack<Integer> s=new Stack<Integer>();
		int i=0;
		int max = 0;
		while(i<n){
			while(!s.isEmpty() && s.peek()>numbers[i])
				max=Math.max(max, numbers[i] ^ s.pop());
			if(!s.isEmpty())
				max=Math.max(max, numbers[i] ^ s.peek());
			s.push(numbers[i++]);
		}
		
		out.println(max);
	}

			
	}

