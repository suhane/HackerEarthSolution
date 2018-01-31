package interviewBits.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class ValidPath {

    public String solve(int A, int B, int C, int D, int[] E, int[] F) {

        int row=A+1;
        int col=B+1;
        int[][] path= new int[row][col];
        boolean[][] visited=new boolean[row][col];

        for(int i=0;i<C;i++){
            //up
            if(E[i]-D>=0){
                int count=0;
                while (count<=D)
                    path[E[i]-count++][F[i]]=1;
            }

            //down
            if(E[i]+D<row){
                int count=0;
                while (count<=D)
                    path[E[i]+count++][F[i]]=1;

            }
            //left
            if(F[i]-D>=0){
                int count=0;
                while (count<=D)
                    path[E[i]][F[i]-count++]=1;

            }
            //right
            if(F[i]+D<col){
                int count=0;
                while (count<=D)
                    path[E[i]][F[i]+count++]=1;

            }
            //left up
            int diag= (int) (D/Math.sqrt(2));

            if(E[i]-diag>=0 && F[i]-diag>=0){
                int count=0;
                while (count<=diag)
                    path[E[i]-count][F[i]-count++]=1;

            }

            // right up
            if(E[i]-diag>=0 && F[i]+diag<col){
                int count=0;
                while (count<=diag)
                    path[E[i]-count][F[i]+count++]=1;

            }
            //down right
            if(E[i]+diag<row && F[i]+diag<col){
                int count=0;
                while (count<=diag)
                    path[E[i]+count][F[i]+count++]=1;

            }
            //down left
            if(E[i]+diag<row && F[i]-diag>=0){
                int count=0;
                while (count<=diag)
                    path[E[i]+count][F[i]-count++]=1;

            }
        }

        /*for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(path[i][j]+ " ");
            }
            System.out.println();
        }*/

        Queue<Cell> q= new LinkedList<Cell>();
        Cell startCell=new Cell(0,0);
        Cell destCell=new Cell(A,B);
        visited[0][0]=true;
        q.offer(startCell);
        while (!q.isEmpty()){
            Cell cell=q.poll();
            int i=cell.rowindex;
            int j=cell.colindex;

            //move up
            if(i-1>=0 && path[i-1][j]==0){
                if(destCell.isReached(i-1,j))
                    return "YES";
                if(!visited[i-1][j])
                    q.offer(new Cell(i-1,j));
                visited[i-1][j]=true;
            }
            //move up left
            if(i-1>=0 && j-1>=0 && path[i-1][j-1]==0){
                if(destCell.isReached(i-1,j-1))
                    return "YES";
                if(!visited[i-1][j-1])
                    q.offer(new Cell(i-1,j-1));
                visited[i-1][j-1]=true;
            }
            //move up right

            if(i-1>=0 && j+1<col && path[i-1][j+1]==0){
                if(destCell.isReached(i-1,j+1))
                    return "YES";
                if(!visited[i-1][j+1])
                    q.offer(new Cell(i-1,j+1));
                visited[i-1][j+1]=true;
            }
            //move left
            if(j-1>=0 && path[i][j-1]==0){
                if(destCell.isReached(i,j-1))
                    return "YES";
                if(!visited[i][j-1])
                    q.offer(new Cell(i,j-1));
                visited[i][j-1]=true;
            }
            //move right
            if(j+1<col && path[i][j+1]==0){
                if(destCell.isReached(i,j+1))
                    return "YES";
                if(!visited[i][j+1])
                    q.offer(new Cell(i,j+1));
                visited[i][j+1]=true;
            }
            //move down
            if(i+1<row && path[i+1][j]==0){
                if(destCell.isReached(i+1,j))
                    return "YES";
                if(!visited[i+1][j])
                    q.offer(new Cell(i+1,j));
                visited[i+1][j]=true;
            }
            //move down right
            if(i+1<row && j+1<col && path[i+1][j+1]==0){
                if(destCell.isReached(i+1,j+1))
                    return "YES";
                if(!visited[i+1][j+1])
                    q.offer(new Cell(i+1,j+1));
                visited[i+1][j+1]=true;
            }

            //move down left
            if(i+1<row && j-1>=0 && path[i+1][j-1]==0){
                if(destCell.isReached(i+1,j-1))
                    return "YES";
                if(!visited[i+1][j-1])
                    q.offer(new Cell(i+1,j-1));
                visited[i+1][j-1]=true;
            }

        }




        return "NO";
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

        public String toString(){
            return "["+rowindex+","+colindex+"]";
        }



    }
    public static void main(String s[]){
        int[] e= {2};
        int[] f={3};
        System.out.println(new ValidPath().solve(2,3,1,1,e,f));
    }
}
