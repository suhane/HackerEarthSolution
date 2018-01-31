package interviewBits.Array;

import java.util.ArrayList;

/**
 * Created by suhane on 7/1/17.
 */
public class PasacalTriangle {

    public static ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> out=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<a;i++){
            ArrayList<Integer> col=new ArrayList<Integer>();
            for(int j=0;j<i;j++){
                if(i-1>=0){
                    ArrayList<Integer> prevArray=out.get(i-1);
                    int sumTillhere=j>0?(prevArray.get(j) + prevArray.get(j-1)):1;
                    col.add(sumTillhere);
                }
            }
            col.add(1);
            out.add(col);

        }
        return out;
    }

    public static ArrayList<Integer> generateKth(int a) {


        if(a==0){
            ArrayList<Integer> col=new ArrayList<Integer>();
            col.add(1);
            return col;
        }
        ArrayList<ArrayList<Integer>> out=new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<a+1;i++){
            ArrayList<Integer> col=new ArrayList<Integer>();
            for(int j=0;j<i;j++){
                if(i-1>=0){
                    ArrayList<Integer> prevArray=out.get(i-1);
                    int sumTillhere=j>0?(prevArray.get(j) + prevArray.get(j-1)):1;
                    col.add(sumTillhere);
                }
            }
            col.add(1);
            out.add(col);

        }
        return out.get(a);
    }

    public static void main(String args[]){
        generateKth(2);
    }

}
