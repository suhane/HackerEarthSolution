package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

public class CastleUsingBFS {

	static int[][] matrix;
	static int[][] steps;
	static Queue<Cell> q;
	static boolean[][] visited;
	static int n;
	class InputReader{
	BufferedReader reader;	
	StringTokenizer token;
	
	public InputReader(InputStream stream){
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
	
	class Cell{
		
		private int rowindex;
		private int colindex;
		
		public Cell(int x, int y){
			this.rowindex=x;
			this.colindex=y;
		}

		public boolean isReached(int i, int j) {
			return this.rowindex==i && this.colindex==j;
		}

		
		
	} 

	public static void main(String args[]){
		InputStream inputstream= System.in;
		OutputStream outstream =System.out;
		InputReader in =new CastleUsingBFS().new InputReader(inputstream);
		PrintWriter out =new PrintWriter(outstream);
		n=in.nextInt();
		matrix=new int[n][n];
		steps=new int[n][n];
		visited=new boolean[n][n];
		solve(n,in,out);
		out.close();
		System.exit(0);
		
	}
	
	
	
	private static void solve(int n, InputReader in, PrintWriter out) {
		int row=0;
		while(row<n){
			String path=in.next();
			int col=0;
			for(char cell: path.toCharArray()){
					if(cell=='.')
						matrix[row][col]=1;
					else
						matrix[row][col]=0;
			col++;
			}
			row++;
		}
		
		int startrow=in.nextInt();
		int startcol=in.nextInt();
		int destrow=in.nextInt();
		int destcol=in.nextInt();
		Cell startcell=new CastleUsingBFS().new Cell(startrow,startcol);
		visited[startrow][startcol]=true;
		steps[startrow][startcol]=0;
		Cell destcell=new CastleUsingBFS().new  Cell(destrow,destcol);
		q= new LinkedList<Cell>();
		q.add(startcell);
		while(!q.isEmpty()){
			Cell current=q.poll();
			int x=current.rowindex;
			int y=current.colindex;
			//move left
			for(int j=y-1;isLegal(x,j);j--){
				if(destcell.isReached(x,j)){
					out.println(steps[x][y]+1);
					return;
				}
				processNeighbours(current,x,j);
			}
			
			//move right
			for(int j=y+1;isLegal(x,j);j++){
				if(destcell.isReached(x,j)){
					out.println(steps[x][y]+1);
					return;
				}
				processNeighbours(current,x,j);
			}
			//move up
			for(int i=x-1;isLegal(i,y);i--){
				if(destcell.isReached(i,y)){
					out.println(steps[x][y]+1);
					return;
				}
				processNeighbours(current,i,y);
			}
			//move down
			for(int i=x+1;isLegal(i,y);i++){
				if(destcell.isReached(i,y)){
					out.println(steps[x][y]+1);
					return;
				}
				processNeighbours(current,i,y);
			}
		}			
	}


	private static boolean isLegal(int i , int j) {
		return i<n && j<n && i>=0 && j>=0 && matrix[i][j]==1 ; 
	}

	private static void processNeighbours(Cell current, int i, int j) {
		if(visited[i][j]==false){
			steps[i][j]=steps[current.rowindex][current.colindex]+1;
			q.add(new CastleUsingBFS().new Cell(i,j));
			visited[i][j]=true;
		}
		
	}
		
		
}

	

