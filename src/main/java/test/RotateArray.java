package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RotateArray {
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
					token =new StringTokenizer(reader.readLine());
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
		InputStream instream =System.in;
		OutputStream outstream=System.out;
		InputReader in=new RotateArray().new InputReader(instream);
		PrintWriter out=new PrintWriter(outstream);
		int n= in.nextInt();
		int d= in.nextInt();
		solve(n,d,in,out);
		out.close();
		System.exit(0);
		
	}

	private static void solve(int n, int d, InputReader in, PrintWriter out) {
		int[] A=new int[n];
		int iter=0;
		while(iter<n)
			A[iter++]=in.nextInt();
		reverse(A,0,d-1);
		reverse(A,d,n-1);
		iter--;
		while(iter>=0)
			out.print(A[iter--]+" ");
		
	}

	private static void reverse(int[] a, int start, int end) {
		// TODO Auto-generated method stub
		while(start<end){
			int temp=a[start];
			a[start]=a[end];
			a[end]=temp;
			start++;
			end--;
			
		}
	}
}
