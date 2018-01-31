package interviewBits.twopointer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by labuser on 7/26/17.
 */
public class Array3Pointers {

    public static int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
        int l=a.size();
        int m=b.size();
        int n=c.size();

        //calculating minimum MAX(a,b,c)

        int length =Math.min(l,Math.min(m,n));
        int r=0,ptrA=0,ptrB=0,ptrC=0;
        int res=Integer.MAX_VALUE;

        while(r<length){
            int min=Math.min(a.get(ptrA),Math.min(b.get(ptrB),c.get(ptrC)));
            int ans=Math.max(Math.abs(a.get(ptrA)-b.get(ptrB)),Math.max(Math.abs(b.get(ptrB)-c.get(ptrC)),Math.abs(c.get(ptrC)-a.get(ptrA))));
            res=Math.min(ans,res);
            if(min==a.get(ptrA)){
                ptrA++;
                length=l;
                r=ptrA;

            }
            else if(min==b.get(ptrB)){
                ptrB++;
                length=m;
                r=ptrB;
            }
            else{
                ptrC++;
                length=n;
                r=ptrC;
            }

        }

        return res;
        
    }
    public  static void main(String args[]){
        int[] arr={1, 4, 10};
        List<Integer> A=new ArrayList<Integer>();

        for(int x:arr){
            A.add(x);
        }

        List<Integer> B=new ArrayList<Integer>();

        int[] arr1={2, 15, 20};
        for(int x:arr1){
            B.add(x);
        }

        List<Integer> C=new ArrayList<Integer>();

        int[] arr2={10, 12};
        for(int x:arr2){
            C.add(x);
        }

        System.out.print(minimize(A,B,C));
    }

}
