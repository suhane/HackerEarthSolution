package interviewBits.Array;

import java.util.ArrayList;

/**
 * Created by suhane on 7/1/17.
 */
public class AntiDiagnal {

    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
        int n=a.size();
        ArrayList<ArrayList<Integer>> out= new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++){
            ArrayList<Integer> temp=new ArrayList<Integer>();
            int row=0;
            int col=i;
            while(col>=0 && row<n){
                temp.add(a.get(row).get(col));
                row++;
                col--;
            }

            out.add(temp);
        }
        for(int i=1;i<n;i++){
            ArrayList<Integer> temp=new ArrayList<Integer>();
            int row=i;
            int col=n-1;
            while(col>=0 && row<n){
                temp.add(a.get(row).get(col));
                row++;
                col--;
            }
            out.add(temp);

        }
        return out;
    }

    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> in= new ArrayList<ArrayList<Integer>>();
        int n=3;
        int count=1;
        for(int i=0;i<n;i++){
            ArrayList<Integer> temp=new ArrayList<Integer>();
            for(int j=0;j<n;j++)
                temp.add(count++);
            in.add(temp);
        }

        diagonal(in);

    }
}
