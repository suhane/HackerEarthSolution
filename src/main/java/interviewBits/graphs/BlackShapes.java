package interviewBits.graphs;


import java.util.LinkedList;
import java.util.Queue;

public class BlackShapes {

    class Cell{
        int x;
        int y;

        public Cell(int x,int y){
            this.x=x;
            this.y=y;
        }

        public String toString(){
            return "["+x+","+y+"]";
        }
    }
    public int black(String[] A) {

        int row=A.length;
        int col=A[0].length();
        int count=0;
        Queue<Cell> q=new LinkedList<Cell>();
        boolean[][] visited= new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!visited[i][j] &&A[i].charAt(j)=='X'){
                    q.offer(new Cell(i,j));
                    while (!q.isEmpty()){
                        Cell cell=q.poll();
                        visited[cell.x][cell.y]=true;
                        //up
                        if(cell.x-1>=0 && !visited[cell.x-1][cell.y] && A[cell.x-1].charAt(cell.y)=='X')
                            q.offer(new Cell(cell.x-1,cell.y));
                        //down
                        if(cell.x+1<row && !visited[cell.x+1][cell.y] && A[cell.x+1].charAt(cell.y)=='X')
                            q.offer(new Cell(cell.x+1,cell.y));
                        //left
                        if(cell.y-1>=0 && !visited[cell.x][cell.y-1] && A[cell.x].charAt(cell.y-1)=='X')
                            q.offer(new Cell(cell.x,cell.y-1));
                        //
                        if(cell.y+1<col && !visited[cell.x][cell.y+1] && A[cell.x].charAt(cell.y+1)=='X')
                            q.offer(new Cell(cell.x,cell.y+1));

                    }
                    count++;
                }
            }
        }
        return count;

    }

    public static void main(String args[]){

        System.out.println(new BlackShapes().black(new String[]{"OOOXOOO","OOXXOXO","OXOOOXO"}));

    }

}
