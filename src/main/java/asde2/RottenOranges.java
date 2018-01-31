package asde2;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    static class Elem{
        int x;
        int y;

        public Elem(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public String toString() {
            return "["+x+","+y+"]";
        }
    }

    public int minTimeFrame(int[][] arr, int r ,int c){

        Queue<Elem> q= new LinkedList<Elem>();
        int rotCount=0,timeFrame=0,emptyCellCount=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(arr[i][j]==2){
                    q.offer(new Elem(i,j));
                    rotCount++;
                }
                if(arr[i][j]==0)
                    emptyCellCount++;
            }

        }
        q.offer(null);

        while(!q.isEmpty()){

            Elem elem= q.poll();
            if(elem!=null){
                int i=elem.x;
                int j=elem.y;
                if(isValidIndices(i-1,j,r,c) && arr[i-1][j]==1){
                    q.offer(new Elem(i-1,j));
                    arr[i-1][j]=2;
                    rotCount++;
                }
                if(isValidIndices(i,j-1,r,c) && arr[i][j-1]==1){
                    q.offer(new Elem(i,j-1));
                    arr[i][j-1]=2;
                    rotCount++;
                }
                if(isValidIndices(i+1,j,r,c) && arr[i+1][j]==1){
                    q.offer(new Elem(i+1,j));
                    arr[i+1][j]=2;
                    rotCount++;
                }
                if(isValidIndices(i,j+1,r,c) && arr[i][j+1]==1){
                    q.offer(new Elem(i,j+1));
                    arr[i][j+1]=2;
                    rotCount++;
                }
            }
            else{
                if(!q.isEmpty()){
                    timeFrame++;
                    q.offer(null);
                }

            }

        }

        if(rotCount==c*r-emptyCellCount)
            return timeFrame;
        else
            return -1;


    }

    private boolean isValidIndices(int i, int j,int n, int m){
        return (i>=0 && i<n && j>=0 && j<m);
    }

    @Test
    public void test(){
        int arr[][] = { {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};
        int ans = minTimeFrame(arr,3,5);
        if(ans == -1)
            System.out.println("All oranges cannot rot");
        else
            System.out.println("Time required for all oranges to rot = " + ans);
    }
}


