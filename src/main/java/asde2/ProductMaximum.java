package asde2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ProductMaximum {
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
	  InputReader in=new ProductMaximum().new InputReader(istream);
	  PrintWriter out=new PrintWriter(ostream);
	  int n=in.nextInt();
	  solve(n,in,out);
	  out.close();
	  System.exit(0);
  }

private static void solve(int n, InputReader in, PrintWriter out) {
	int[] arr=new int[n];
	int iter=0;
	while(iter<n){
		arr[iter++]=in.nextInt();
	}
	for(int i=0;i<n;i++){
		for(int j=i;j<n-1;j++){
			if(arr[j]>arr[j+1]){
				int temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
			}
		}
	}
	
	out.println(Math.max(arr[0]*arr[1]*arr[n-1], arr[n-1]*arr[n-2]*arr[n-3]));
	}
	
}

