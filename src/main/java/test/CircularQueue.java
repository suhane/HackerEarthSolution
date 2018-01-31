package test;

public class CircularQueue {
	private int[] queue;
	private int size,front,rear;
	private static int CAPACITY=16;
	private static int MINCAPACITY=1<<15;
	
	public CircularQueue(){
		queue=new int[CAPACITY];
		size=0;front=0;rear=0;
	}
	public CircularQueue(int cap){
		queue=new int[cap];
		size=0;front=0;rear=0;
	}
	
	public void enqueue(int data){
		if(size==CAPACITY)
			expand();
		size++;
		queue[rear]=data;
		rear=rear+1%CAPACITY;
	}
	
	private void expand() {
		// TODO Auto-generated method stub
		
	}
	public int dequeue(){
		if(size==0)
			throw new IllegalStateException("Queue is empty");
		size--;
		int data=queue[front%CAPACITY];
		front=front+1%CAPACITY;
		return data;
		
	}
}
