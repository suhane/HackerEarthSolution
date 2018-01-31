package interviewBits.Array;

import java.util.ArrayList;

/**
 * Created by suhane on 7/1/17.
 */
public class SpiralOrder2 {

    public static void main(String args[]){
        int n=3;
        int rowstart=0;
        int rowend=n-1;
        int colstart=0;
        int colend=n-1;
        int counter=1;
        int[][] arr=new int[n][n];
        while(rowstart<=rowend && colstart<=colend){
            for(int i=rowstart,j=colstart;j<=colend;j++)
                arr[i][j]=counter++;
            for(int i=rowstart+1,j=colend;i<=rowend;i++)
                arr[i][j]=counter++;
            for(int i=rowend,j=colend-1;j>=colstart;j--)
                arr[i][j]=counter++;
            for(int i=rowend-1,j=colstart;i>=rowstart+1;i--)
                arr[i][j]=counter++;

            rowstart++;colstart++;rowend--;colend--;

        }

    }


    public ArrayList<ArrayList<Integer>> generateMatrix(int a) {
        int rowstart=0;
        int rowend=a-1;
        int colstart=0;
        int colend=a-1;
        int counter=1;
        int[][] arr=new int[a][a];
        while(rowstart<=rowend && colstart<=colend){
            for(int i=rowstart,j=colstart;j<=colend;j++)
                arr[i][j]=counter++;
            for(int i=rowstart+1,j=colend;i<=rowend;i++)
                arr[i][j]=counter++;
            for(int i=rowend,j=colend-1;j>=colstart;j--)
                arr[i][j]=counter++;
            for(int i=rowend-1,j=colstart;i>=rowstart+1;i--)
                arr[i][j]=counter++;

            rowstart++;colstart++;rowend--;colend--;

        }
        ArrayList<ArrayList<Integer>> out= new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<a;i++){
            ArrayList<Integer> x=new ArrayList<Integer>();
            for(int j=0;j<a;j++){
                x.add(arr[i][j]);
            }
            out.add(x);
        }

        return  out;
    }
}
