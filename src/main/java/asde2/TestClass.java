package asde2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TestClass {

	class InputReader{
		BufferedReader reader;
		StringTokenizer token;
		public InputReader(InputStream istream){
			reader=new BufferedReader(new InputStreamReader(istream));
			token=null;
		}
		
		public String next(){
			while(token==null || !token.hasMoreElements()){
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
		InputStream istream = System.in;
		OutputStream outstream=System.out;
		InputReader in =new TestClass().new InputReader(istream);
		PrintWriter out=new PrintWriter(outstream);
		int n=in.nextInt();
		solve(n,in,out);
		out.close();
		System.exit(0);
	}

	private static void solve(int n, InputReader in, PrintWriter out) {
		while(n-->0){
			out.println(in.nextInt()+in.nextInt());
		}
		
	}
}
