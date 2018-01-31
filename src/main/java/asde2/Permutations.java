package asde2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Permutations {
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
	  
	  public char nextChar(){
		  return next().charAt(0);
	  }
  }
  
  public static void main(String args[]){
	  InputStream istream= System.in;
	  OutputStream ostream=System.out;
	  InputReader in=new Permutations().new InputReader(istream);
	  PrintWriter out=new PrintWriter(ostream);
	  int n=in.nextInt();
	  solve(n,in,out);
	  out.close();
	  System.exit(0);
  }

private static void solve(int n, InputReader in, PrintWriter out) {
	char[] c=new char[n];
	int count=n;
	int i=0;
	while(count-->0){
		c[i++]= in.nextChar();
	}
	int k=in.nextInt();
	int limit=(int) Math.pow(n, k);
	for(int iter=0;iter<limit;iter++){
		printBinaryEquivalents(iter,k,c,n,out);
		out.println();
	}
	
}

private static void printBinaryEquivalents(int number, int k, char[] c, int n, PrintWriter out) {
	int rem;
	int[] binarydigits=new int[k];
	int q=-1;
	int plh=k;
	while(q!=1 && number!=0){
		rem=number%n;
		binarydigits[(k--)-1]=rem;
		number=number/n;
		q=rem/n;
	}
	int iter=0;
	while(iter<plh){
		int index=binarydigits[iter++];
		out.print(c[index]);
	}
	
	
}
}
