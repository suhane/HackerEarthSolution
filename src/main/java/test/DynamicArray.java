package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DynamicArray {
	class  InputReader{
		private BufferedReader reader;
		private StringTokenizer tokenzer;
		
		public InputReader(InputStream stream){
			reader=new BufferedReader(new InputStreamReader(stream));
			tokenzer=null;
		}
		
		public String next(){
			while(tokenzer==null || !tokenzer.hasMoreTokens()){
				try {
					tokenzer= new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return tokenzer.nextToken();
		}
		
		public int nextInt(){
			return Integer.parseInt(next());			
		}
	}
	public static void main(String args[]){
		InputStream inputstream= System.in;
		OutputStream outputstream=System.out;
		InputReader in=new DynamicArray().new InputReader(inputstream);
		PrintWriter out=new PrintWriter(outputstream);
		int N=in.nextInt();
		int Q=in.nextInt();
		solve(in,out,N,Q);
		out.close();
		System.exit(0);
	}
	private static void solve(InputReader in, PrintWriter out, int n, int q) {
		ArrayList<ArrayList<Integer>> Arr = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < n; ++i) {
		    Arr.add(new ArrayList<Integer>());
		}
		
		int lastAns=0;
		while(q-->0){
			int querytype=in.nextInt();
			int x=in.nextInt();
			int y=in.nextInt();
			
			if(querytype==1){
				int index=(x^lastAns)%n;
				Arr.get(index).add(y);
			}
			else{
				int X_index=(x^lastAns)%n;
				int size=Arr.get(X_index).size();
				int Y_index=y%size;
				lastAns=Arr.get(X_index).get(Y_index);
				out.println(lastAns);
			}
		}
		
	}
}
