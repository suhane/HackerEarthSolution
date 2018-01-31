package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.Queue;

public class StepToZero {
	
	/** Class BinaryHeap **/
	class BinaryHeap    
	{
	    /** The number of children each node has **/
	    private static final int d = 2;
	    private int heapSize;
	    private int[] heap;
	 
	    /** Constructor **/    
	    public BinaryHeap(int capacity)
	    {
	        heapSize = 0;
	        heap = new int[capacity + 1];
	    }
	 
	    /** Function to check if heap is empty **/
	    public boolean isEmpty( )
	    {
	        return heapSize == 0;
	    }
	 
	    /** Check if heap is full **/
	    public boolean isFull( )
	    {
	        return heapSize == heap.length;
	    }
	 
	    /** Clear heap */
	    public void makeEmpty( )
	    {
	        heapSize = 0;
	    }
	 
	    /** Function to  get index parent of i **/
	    private int parent(int i) 
	    {
	        return (i - 1)/d;
	    }
	 
	    /** Function to get index of k th child of i **/
	    private int kthChild(int i, int k) 
	    {
	        return d * i + k;
	    }
	 
	    /** Function to insert element */
	    public void insert(int x)
	    {
	        if (isFull( ) )
	            throw new NoSuchElementException("Overflow Exception");
	        /** Percolate up **/
	        heap[heapSize++] = x;
	        heapifyUp(heapSize - 1);
	    }
	 
	    /** Function to find least element **/
	    public int findMin( )
	    {
	        if (isEmpty() )
	            throw new NoSuchElementException("Underflow Exception");           
	        return heap[0];
	    }
	 
	    /** Function to delete min element **/
	    public int deleteMin()
	    {
	        int keyItem = heap[0];
	        delete(0);
	        return keyItem;
	    }
	 
	    /** Function to delete element at an index **/
	    public int delete(int ind)
	    {
	        if (isEmpty() )
	            throw new NoSuchElementException("Underflow Exception");
	        int keyItem = heap[ind];
	        heap[ind] = heap[heapSize - 1];
	        heapSize--;
	        heapifyDown(ind);        
	        return keyItem;
	    }
	 
	    /** Function heapifyUp  **/
	    private void heapifyUp(int childInd)
	    {
	        int tmp = heap[childInd];    
	        while (childInd > 0 && tmp < heap[parent(childInd)])
	        {
	            heap[childInd] = heap[ parent(childInd) ];
	            childInd = parent(childInd);
	        }                   
	        heap[childInd] = tmp;
	    }
	 
	    /** Function heapifyDown **/
	    private void heapifyDown(int ind)
	    {
	        int child;
	        int tmp = heap[ ind ];
	        while (kthChild(ind, 1) < heapSize)
	        {
	            child = minChild(ind);
	            if (heap[child] < tmp)
	                heap[ind] = heap[child];
	            else
	                break;
	            ind = child;
	        }
	        heap[ind] = tmp;
	    }
	 
	    /** Function to get smallest child **/
	    private int minChild(int ind) 
	    {
	        int bestChild = kthChild(ind, 1);
	        int k = 2;
	        int pos = kthChild(ind, k);
	        while ((k <= d) && (pos < heapSize)) 
	        {
	            if (heap[pos] < heap[bestChild]) 
	                bestChild = pos;
	            pos = kthChild(ind, k++);
	        }    
	        return bestChild;
	    }
	 
	    /** Function to print heap **/
	    public void printHeap()
	    {
	        System.out.print("\nHeap = ");
	        for (int i = 0; i < heapSize; i++)
	            System.out.print(heap[i] +" ");
	        System.out.println();
	    }     
	}
	
	static HashMap<Integer,Integer> stepTozero;
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
					token= new StringTokenizer(reader.readLine());
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
	
	class Multiples{
		int a;
		int b;
		
		public Multiples(int a ,int b){
			this.a=a;
			this.b=b;
		}
		
	}
	
	public static void main(String args[]){
		InputStream instream=System.in;
		OutputStream outstream=System.out;
		InputReader in =new StepToZero().new InputReader(instream);
		PrintWriter out=new PrintWriter(outstream);
		int n=in.nextInt();
		stepTozero=new HashMap<Integer,Integer>();
		solve(n,in,out);
		out.close();
		System.exit(0);
	}

	private static void solve(int n, InputReader in, PrintWriter out) {
		
		while(n-->0){
			
			int q=in.nextInt();
			out.println(solve(q));
			
			
		}
		
	}

	private static int solve(int q) {
		
		if(q<=0)
			return 0;
		Queue<Integer> queue=new LinkedList<Integer>();
		boolean[] visited=new boolean[q];
		BinaryHeap h=new StepToZero().new BinaryHeap(q);
		int stepCount=0;
		queue.add(q);
		queue.add(-1);
		while(!queue.isEmpty()){
			int item=queue.poll();
			if(item!=-1){
				ArrayList<Integer> multiples=generateMultiples(item,visited);
				if(!multiples.isEmpty()){
					for(int multiple: multiples){
						if(!stepTozero.containsKey(multiple)){
							queue.add(multiple);
							visited[multiple]=true;
						}
						else
								h.insert(stepTozero.get(multiple)+stepCount+1);
							
					}
				}				
				if(item-1!=0){
					if(!stepTozero.containsKey(item-1) && visited[item-1]!=true){
						queue.add(item-1);
						visited[item-1]=true;
					}
					else
						if(stepTozero.containsKey(item-1) && visited[item-1]!=true)
							h.insert(stepTozero.get(item-1)+stepCount+1);
				}
				else{
						stepTozero.put(q, Math.min(stepCount+1,!h.isEmpty()?h.findMin():stepCount+1));
						return stepTozero.get(q);
				}
			}	
				
			else{
				stepCount++;
				if(!queue.isEmpty())
					queue.add(-1);
			}
		}
		return h.findMin();
	}

	private static ArrayList<Integer> generateMultiples(int q, boolean[] visited) {
		ArrayList<Integer> multiples = new ArrayList<Integer>();
		for(int i=2;i*i<=q;i++){
			int k;
			if(q%i==0 && visited[k=q/i]!=true){
				multiples.add(k);
			}
		}
		return multiples;
	}
}
