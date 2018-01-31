package interviewBits.Array;

import java.util.ArrayList;

/**
 * Created by suhane on 7/11/17.
 */
public class RotateArrayInPlace {

    public static void rotate(ArrayList<ArrayList<Integer>> a) {

        int n=a.size();
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-1-i;j++){
                int row1=i;
                int col1=j;
                int row2=col1;
                int col2=n-1-row1;
                int row3=col2;
                int col3=n-1-row2;
                int row4=col3;
                int col4=n-1-row3;
                int temp1=a.get(row1).get(col1);
                int temp2=a.get(row2).get(col2);
                int temp3=a.get(row3).get(col3);
                int temp4=a.get(row4).get(col4);
                a.get(row2).set(col2,temp1);
                a.get(row3).set(col3,temp2);
                a.get(row4).set(col4,temp3);
                a.get(row1).set(col1,temp4);
            }
        }
    }

    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> in= new ArrayList<ArrayList<Integer>>();
        int n=2;
        int count=1;
        for(int i=0;i<n;i++){
            ArrayList<Integer> temp=new ArrayList<Integer>();
            for(int j=0;j<n;j++)
                temp.add(count++);
            in.add(temp);
        }

        rotate(in);

    }
}
