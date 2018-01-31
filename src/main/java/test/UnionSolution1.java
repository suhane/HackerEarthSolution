package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UnionSolution1 {
    
	
	void initialize( int Arr[ ], int N)
	{
	    for(int i = 0;i<N;i++)
	    Arr[ i ] = i ;
	}
	//returns true,if A and B are connected, else it will return false. 
	boolean find( int Arr[ ], int A, int B)                           
	{
	if(Arr[ A ] == Arr[ B ])
	return true;
	else
	return false;   
	}
	
	int find( int Arr[ ], int A)                           
	{
	int count=0;
	int root=Arr[A];
	for(int i=0;i<Arr.length;i++){
		if(Arr[i]==root)
			count++;
	}
	return count;   
	}
	//change all entries from Arr[ A ] to Arr[ B ].
	void union(int Arr[ ], int N, int A, int B)
	{
	    int TEMP = Arr[ A ];
	    for(int i = 0; i <N;i++)
	    {
	    if(Arr[ i ] == TEMP)
	    Arr[ i ] = Arr[ B ]; 
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
	public static void main(String args[]){
		UnionSolution1 pre=new UnionSolution1();
    	InputStream inputStream = System.in;
    	OutputStream outputStream = System.out;
    	InputReader in = pre.new InputReader(inputStream);
    	PrintWriter out = new PrintWriter(outputStream);
    	int n = in.nextInt();
    	int q = in.nextInt();
        solve(pre,n,q,in,out);
        out.close();
        System.exit(0);
	}
	private static void solve(UnionSolution1 pre, int n, int q, InputReader in,
			PrintWriter out) {
		int Arr[]=new int[n];
		pre.initialize(Arr,n);
		String query;
		while(q-->0){
			query=in.next();
			if(query.equals("M")){
				int A =in.nextInt();
				int B=in.nextInt();
				pre.union(Arr, n, A-1, B-1);
			}
			else{
				int el=in.nextInt();
				out.println(pre.find(Arr, el-1));
			}
		}
		
	}
	
}