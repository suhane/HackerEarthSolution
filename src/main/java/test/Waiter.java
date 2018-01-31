package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Waiter {
 class PrimeGenerator{
	Stack<Integer> prime= new Stack<Integer>();
	public int nextPrime(){
		if(prime.isEmpty()){
			prime.push(2);
			return 2;
		}
		int curPrime=prime.peek();
		while(!isPrime(++curPrime)){
			
		}
		prime.push(curPrime);
		return curPrime;
			
	}
	private boolean isPrime(int n) {
		for(int i=2;i<n/2 + 1;i++){
			if(n%i==0)
				return false;
		}
		return true;
	}
 }
 
 class InputReader{
	 BufferedReader reader;
	 StringTokenizer token;
	 
	 public InputReader(InputStream stream) {
		 reader= new BufferedReader(new InputStreamReader(stream));
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
	InputStream is=System.in;
	OutputStream os=System.out;
	InputReader in=new Waiter().new InputReader(is);
	PrintWriter out=new PrintWriter(os);
	int n=in.nextInt();
	int q=in.nextInt();
	solve(n,q,in,out);
	out.close();
	System.exit(0);
}

private static void solve(int n, int q, InputReader in, PrintWriter out) {
	Stack<Integer> plates= new Stack<Integer>();
	PrimeGenerator gen=new Waiter().new PrimeGenerator();
	while(n-->0)
		plates.push(in.nextInt());
	while(q-->0){
		int prime=gen.nextPrime();
		Stack<Integer> primediv= new Stack<Integer>();
		Stack<Integer> nonprivediv= new Stack<Integer>();
		while(!plates.isEmpty()){
			if(plates.peek()%prime==0)
				primediv.push(plates.pop());
			else
				nonprivediv.push(plates.pop());
		}
		plates=nonprivediv;
		while(!primediv.isEmpty())
			out.println(primediv.pop());
	}
	while(!plates.isEmpty())
		out.println(plates.pop());
}
}

