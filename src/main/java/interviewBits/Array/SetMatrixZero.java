package interviewBits.Array;

import java.util.ArrayList;

/**
 * Created by labuser on 7/13/17.
 */
public class SetMatrixZero {

    public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
        int m=a.size();
        int n=a.get(0).size();
        int i=0,j=0;
        boolean r=true,c=true;
        for(int col=0;col<n;col++) {
            if(a.get(0).get(col)==0) {
                r = false;
                break;
            }
        }
        for(int row=0;row<m;row++) {
            if(a.get(row).get(0)==0) {
                c = false;
                break;
            }
        }

        for(int col=1;col<n;col++){
            for(int row=1;row<m;row++){
                if(a.get(row).get(col)==0)
                    a.get(0).set(col,0);
            }
        }

        for(int row=1;row<m;row++){
            for(int col=1;col<n;col++){
                if(a.get(row).get(col)==0)
                    a.get(row).set(0,0);
            }
        }

        for(int row=1;row<m;row++){
            for(int col=1;col<n;col++){
                if(!(a.get(0).get(col)==1 && a.get(row).get(0)==1))
                    a.get(row).set(col,0);
            }
        }
        if(!r){
            for(int col=0;col<n;col++)
                a.get(0).set(col,0);
        }

        if(!c){
            for(int row=0;row<m;row++)
                a.get(row).set(0,0);
        }




    }

    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> in= new ArrayList<ArrayList<Integer>>();
        int n=3;
        int count=1;
        for(int i=0;i<n;i++){
            ArrayList<Integer> temp=new ArrayList<Integer>();
            for(int j=0;j<n;j++)
                temp.add(1);
            in.add(temp);
        }

        in.get(0).set(1,0);
        //in.get(2).set(1,0);

        setZeroes(in);

    }

}
