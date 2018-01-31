package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Map {

	public class InputReader{
		BufferedReader reader;
		StringTokenizer tokenizer;
		
		public InputReader(InputStream stream){
			reader=new BufferedReader(new InputStreamReader(stream));
			tokenizer=null;
		}
		public String next(){
			while(tokenizer==null || !tokenizer.hasMoreTokens()){
				try {
					tokenizer=new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return tokenizer.nextToken();
		}
		
		public int nextInt(){
			return Integer.parseInt(next());
		}
		
	}
	
	public static void main(String args[]){
		InputStream stream =System.in;
		OutputStream outputstream=System.out;
		InputReader in=new Map().new InputReader(stream);
		PrintWriter out=new PrintWriter(outputstream);
		HashMap<String,Integer> hm=new HashMap<String,Integer>();
		int N=in.nextInt();
		readInput(N,in,hm);
		int Q=in.nextInt();
		processOutput(Q,in,out,hm);
		out.close();
		System.exit(0);
	}

	private static void processOutput(int q, InputReader in, PrintWriter out, HashMap<String, Integer> hm) {
		while(q-->0){
			String key=in.next();
			out.println(hm.get(key)==null?0:hm.get(key));
		}
		
	}

	private static void readInput(int n, InputReader in, HashMap<String, Integer> hm) {
		while(n-->0){
			String word=in.next();
			
			if(!hm.containsKey(word)){
				hm.put(word, 1);
			}
			else{
				int count=hm.get(word);
				hm.put(word, count+1);
			}
		}
		
	}
}
