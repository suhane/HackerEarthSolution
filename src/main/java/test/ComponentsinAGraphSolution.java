package test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class ComponentsinAGraphSolution {
private void initialize(int[] Arr,int[] Size, int n){
	for(int i=0;i<n;i++){
		Arr[i]=i;
		Size[i]=1;
	}
}

private int root(int[] Arr, int A){
	while(A!=Arr[A]){
		A=Arr[A];
	}
	return A;
}

private void union(int[] Arr,int[] Size, int A,int B){
	int root_A=root(Arr,A);
	int root_B=root(Arr,B);
	if(root_A!=root_B){
		if(Size[root_A]<Size[root_B]){
			Arr[root_A]=root_B;
			Size[root_B]+=Size[root_A];
		}
		else{
			Arr[root_B]=root_A;
			Size[root_A]+=Size[root_B];
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
	ComponentsinAGraphSolution pre=new ComponentsinAGraphSolution();
	InputStream inputStream = System.in;
	//OutputStream outputStream = new FileOutputStream("./output.txt",true);//System.out;
	OutputStream outputStream =System.out;
	InputReader in = pre.new InputReader(inputStream);
	PrintWriter out = new PrintWriter(outputStream,true);
	int n = in.nextInt();
    solve(pre,n,in,out);
    out.close();
    System.exit(0);
}


private static void solve(ComponentsinAGraphSolution pre, int n, InputReader in,
		PrintWriter out) throws IOException {
	int Arr[]=new int[n*2];
	int size[]=new int[n*2];
	pre.initialize(Arr,size,n*2);

	while(n-->0){
		
			int A =in.nextInt();
			int B =in.nextInt();
			pre.union(Arr, size, A-1, B-1);
			//out.println(pre.find(Arr, size, el-1));
	}

	int min=size[pre.root(Arr,Arr[0])];
	int max=size[pre.root(Arr,Arr[0])];
	for(int i=0;i<Arr.length;i++){
		int root=pre.root(Arr,Arr[i]);
		if(size[root]!=1){
			System.out.print("\t" +size[i]);
			if(min!=1){
				if ( size[root] < min){
						min=size[root];
				
				}
			}
			else{
				min=size[root];
			}
			if ( size[root] > max){
				max=size[root];
			}
		}
	}
	
	out.println(min+" "+max);
}

}
