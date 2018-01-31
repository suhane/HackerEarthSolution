package test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UnionFindSolution {
    
	
	void initialize( int Arr[ ], int size [], int N)
	{
	    for(int i = 0;i<N;i++){
	    Arr[ i ] = i ;
	    size[i]=1;
	    }
	}
	//returns true,if A and B are connected, else it will return false. 
	boolean find( int Arr[ ], int A, int B)                           
	{
	if(root(Arr,A) == root(Arr,B))
	return true;
	else
	return false;   
	}
	
	int find( int Arr[ ],int size[], int A)                           
	{
	int root_A=root( Arr,A);
	return size[root_A];
	}
	
	int root(int Arr[],int A){
		while(Arr[A]!=A){
			A=Arr[A];
			
		}
		return A;
	}
	//change all entries from Arr[ A ] to Arr[ B ].
	void union(int Arr[ ], int size [],int A, int B)
	{
	    
		int root_A=root(Arr,A);
		int root_B=root(Arr,B);
		if(!find(Arr,A,B)){
		if(size[root_A] < size[root_B ]){
			Arr[root_A]=Arr[root_B];
			size[root_B]+=size[root_A];
		}
		else{
			Arr[root_B]=Arr[root_A];
			size[root_A]+=size[root_B];
		}
		}
	}
	class InputReader {
	    private BufferedReader reader;
	    private StringTokenizer tokenizer;
	 
	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream));
	        tokenizer = null;
	    }
	 
	    public String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	            try {
	                tokenizer = new StringTokenizer(reader.readLine());
	            } catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        }
	        return tokenizer.nextToken();
	    }
	 
	    public int nextInt() {
	        return Integer.parseInt(next());
	    }
	 
	}
	public static void main(String args[]) throws IOException{
		UnionFindSolution pre=new UnionFindSolution();
    	InputStream inputStream = System.in;
    	OutputStream outputStream = new FileOutputStream("./output.txt",true);//System.out;
    	InputReader in = pre.new InputReader(inputStream);
    	PrintWriter out = new PrintWriter(outputStream,true);
    	int n = in.nextInt();
    	int q = in.nextInt();
        solve(pre,n,q,in,out);
        out.close();
        System.exit(0);
	}
	
	
	private static void solve(UnionFindSolution pre, int n, int q, InputReader in,
			PrintWriter out) throws IOException {
		int Arr[]=new int[n];
		int size[]=new int[n];
		pre.initialize(Arr,size,n);
		String query;

		while(q-->0){
			query=in.next();
			if(query.equals("M")){
				int A =in.nextInt();
				int B=in.nextInt();
				pre.union(Arr, size, A-1, B-1);
			}
			else{
				int el=in.nextInt();
				out.write(""+pre.find(Arr, size, el-1)+"\n");
				//out.println(pre.find(Arr, size, el-1));
			}
			
		}
	}
	
}