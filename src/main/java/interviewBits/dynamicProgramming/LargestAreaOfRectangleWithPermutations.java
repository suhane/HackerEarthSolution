package interviewBits.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class LargestAreaOfRectangleWithPermutations {

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int r=A.size();
        int c=A.get(0).size();
        int[][] output= new int[r][c];
        for(int i=0;i<c;i++){
            output[0][i]=A.get(0).get(i);
            for(int j=1;j<r;j++){
                if(A.get(j).get(i)==1){
                    if(A.get(j-1).get(i)==1)
                        output[j][i]=output[j-1][i]+1;
                    else
                        output[j][i]=1;
                }
            }
        }

        for(int i=0;i<r;i++){
            output[i]=countSort(output[i],r);
        }

        int maxArea=0;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                maxArea= Math.max((j+1)*output[i][j],maxArea);
            }
        }

        return maxArea;

    }

    private int[] countSort(int[] arr,int r){

        int n=arr.length;
        int[] count=new int[r+1];
        int[] output=new int[n];
        for(int i=0;i<n;i++){
            count[arr[i]]++;
        }

        for(int i=1;i<=r;i++){
            count[i]+=count[i-1];
        }

        for(int i=0;i<n;i++){
            int elem=arr[i];
            int cnt=count[elem];
            int pos=n-cnt;
            output[pos]=elem;
            count[elem]--;
        }

        return output;
    }

    public static void main(String s[]){
        ArrayList<ArrayList<Integer>> A= new ArrayList<ArrayList<Integer>>();
        A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 0, 1, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 0, 1, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 0, 1, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 0, 1, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 0, 1, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 1, 0, 1, 0)));
        //A.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 1, 0)));

        LargestAreaOfRectangleWithPermutations sol= new LargestAreaOfRectangleWithPermutations();
        System.out.println(sol.solve(A));


    }
}
