package test;

public class Heap {
	private int capacity;
	private int count;
	private int[] array;
	
	public Heap(int capacity){
		this.array=new int[capacity];
		this.count=0;
	}
	
	public int parent(int i){
		if(i>=this.count|| i<=0)
			return -1;
		else
			return (i-1)/2;
	}
	
	public int leftchild(int i){
		int left=2*i+1;
		if(left>=this.count)
			return -1;
		return left;
	}
	
	public int righttchild(int i){
		int right=2*i+2;
		if(right>=this.count)
			return -1;
		return right;
	}
	
	public void percolatedown(int i){
		int l,r,min;
		l=leftchild(i);
		r=righttchild(i);
		if(this.array[l]<this.array[i])
			min=l;
		else
			min=i;
		if(this.array[r]<this.array[i])
			min=r;
		if(min!=i){
			int temp=this.array[min];
			this.array[min]=this.array[i];
			this.array[i]=temp;
		}
		percolatedown(min);
	}
	
	public int deletemin(){
		if(this.count==0)
			return -1;
		int data= this.array[0];
		this.array[0]=this.array[this.count-1];
		this.count--;
		percolatedown(0);
		return data;
	}
	
	public int getMin(){
		if(this.count==0)
			return -1;
		return this.array[0];
	}
	
	public void insert(int data){
		int i=this.count;
		while(i>=0 && data< this.array[(i-1)/2]){
			this.array[i]=this.array[(i-1)/2];
			i=(i-1)/2;
		}
		this.array[i]=data;
		this.count++;
	}
	
	public void buildHeap(int[] A){
		for(int i=0;i<A.length;i++){
			int index=this.count;
			while(index>0 && this.array[index]<this.array[(index-1)/2]){
				this.array[index]=this.array[(index-1)/2];
				index=(index-1)/2;
			}
			this.array[index]=A[i];
			this.count++;
		}
	}
	
	
	
}
