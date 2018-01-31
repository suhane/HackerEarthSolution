package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.PriorityQueue;


public class SlidingWindow {
	
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
		 InputStream ins=System.in;
		 OutputStream ous=System.out;
		 InputReader in =new SlidingWindow().new InputReader(ins);
		 PrintWriter out=new PrintWriter(ous);
		 int n=in.nextInt();
		 int q=in.nextInt();
		 solve(n,q,in,out);
		 out.close();
		 System.exit(0);
	 }

	private static void solve(int n, int q, InputReader in, PrintWriter out) {
		int[] A=new int[n];
		int i=0;
		while(i<n)
		{
			A[i++]=in.nextInt();
		}
		while(q-->0){
			int w=in.nextInt();
			solve(A,w,n,out);
		}
		
	}

	private static void solve(int[] A, int w,int n, PrintWriter out) {
		Deque<Integer> q=new LinkedList<Integer>();
		PriorityQueue<Integer> pq= new PriorityQueue<Integer>(); 
		
		for(int i=0;i<w;i++){
			while(!q.isEmpty() && A[i]>=A[q.peekLast()] ){
				q.pollLast();
			}
			q.offerLast(i);
		}
		for(int i=w;i<n;i++){
			pq.add(A[q.peekFirst()]);
			while(!q.isEmpty() && A[i]>=A[q.peekLast()])
				q.pollLast();
			while(!q.isEmpty() && q.peekFirst()<=i-w)
				q.pollFirst();
			q.offerLast(i);
		}
		pq.add(A[q.peekFirst()]);
		out.println(pq.poll());	
	}
		
		
	
}
