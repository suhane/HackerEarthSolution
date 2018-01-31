package test;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Graph {
	
	private int[][] adjMatrix;
	private Vertex[] vertexList;
	private int vertexCount;
	private int maxVertex;
	
	
	public Graph(int maxVertex){
		vertexCount=0;
		vertexList=new Vertex[maxVertex];
		this.maxVertex=maxVertex;
		for(int i=0;i<this.maxVertex;i++){
			for(int j=0;i<this.maxVertex;j++){
				this.adjMatrix[i][j]=0;
			}
		}
	}
	
	public void addEdge(int start,int end){
		adjMatrix[start][end]=1;
		adjMatrix[end][start]=1;
	}
	
	public void addVertex(char label){
		vertexList[this.vertexCount++]=new Vertex(label);
	}
	
	class Vertex{
		int label;
		boolean visited;
	
	public Vertex(char label){
		this.visited=false;
		this.label=label;
	}
	}
	
	public void dfs(){
		Stack<Integer> s=new Stack<Integer>();
		vertexList[0].visited=true;
		displayVertex(0);
		s.push(0);
		while(!s.isEmpty()){
			int v=getNonVistedVertex(s.peek());
			if(v==-1)
				s.pop();
			else{
				displayVertex(v);
				this.vertexList[v].visited=true;
				s.push(v);
			}
		}
	}
	public void bfs(){
		Queue<Integer> q= new LinkedList<Integer>();
		displayVertex(0);
		vertexList[0].visited=true;
		q.add(0);
		
		while(!q.isEmpty()){
			int v=q.poll();
			int v2;
			while((v2=this.getNonVistedVertex(v))!=-1){
				displayVertex(0);
				this.vertexList[v2].visited=true;
				q.add(v2);
			}
		}
	}

	private void displayVertex(int v) {
		System.out.println(this.vertexList[v].label);
		
	}

	private int getNonVistedVertex(int v) {
		for(int j=0;j<this.vertexCount;j++){
			if(this.adjMatrix[v][j]==1 && this.vertexList[j].visited==false)
				return j;
		}
		return -1;
	}
}
