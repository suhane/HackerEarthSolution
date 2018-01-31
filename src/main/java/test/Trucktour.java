package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class Trucktour {
	class InputReader{
		StringTokenizer token;
		BufferedReader reader;
		
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
		InputStream ins=System.in;
		OutputStream ous=System.out;
		InputReader in=new Trucktour().new InputReader(ins);
		PrintWriter out=new PrintWriter(ous);
		int n=in.nextInt();
		solve(n,in,out);
		out.close();
		System.exit(0);
	}

	private static void solve(int n, InputReader in, PrintWriter out) {
		int[] fuel=new int[n];
		int[] distance=new int[n];
		Queue<Integer> q=new LinkedList<Integer>();
		int iter=0;
		while(iter<n){
			fuel[iter]=in.nextInt();
			distance[iter]=in.nextInt();
			q.add(iter++);
		}
		int remainingfuel=0;
		int coverage=0;
		int index;
		while(!q.isEmpty()){
			index=q.poll();
			q.add(index);
			coverage++;
			remainingfuel+=fuel[index]-distance[index];
			if(remainingfuel<0){
				remainingfuel=0;
				coverage=0;
			}
			if(coverage==n+1){
				out.println(index);
				return;
			}
				 
			
		}
		
	}
}
