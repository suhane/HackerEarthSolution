package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Stack;

public class PoisonousPlants {

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
			InputStream instream=System.in;
			OutputStream outstream=System.out;
			InputReader in=new PoisonousPlants().new InputReader(instream);
			PrintWriter out= new PrintWriter(outstream);
			int n=in.nextInt();
			solve(n,in,out);
			out.close();
			System.exit(0);
		}

		private static void solve(int n, InputReader in, PrintWriter out) {

			int[] plants=new int[n];
			for(int i=0;i<n;i++){
				plants[i]=in.nextInt();
			}
			int[] days=new int[n];
			Stack<Integer> s= new Stack<Integer>();
			s.push(0);
			int max=0;
			int min=plants[0];
			
			for(int i=1;i<n;i++){
				if(plants[i]>plants[i-1] )
					days[i]=1;
				
				
				min=min<plants[i]?min:plants[i];
				while(!s.empty() && plants[s.peek()]>=plants[i]){
					
					if(plants[i]>min)
						days[i]=days[i]>days[s.peek()]+1?days[i]:days[s.peek()]+1;
					
					s.pop();	
				}
				max=max>days[i]?max:days[i];
				s.push(i);
			}
			out.print(max);
			}
}
