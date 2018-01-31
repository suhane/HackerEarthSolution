package interviewBits.arrayMath;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by labuser on 7/16/17.
 */
public class PointsInRectangle {

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D) {


        int n=C.size();
        int count=0;
        int aX=A.get(0);
        int aY=B.get(0);
        int bX=A.get(1);
        int bY=B.get(1);
        int cX=A.get(2);
        int cY=B.get(2);
        int dX=A.get(3);
        int dY=B.get(3);

        double areaABD=Math.abs(aX*(bY-dY)+bX*(dY-aY)+dX*(aY-bY))/2;
        double areaBCD=Math.abs(bX*(cY-dY)+cX*(dY-bY)+dX*(bY-cY))/2;

        double area= areaABD+ areaBCD;
        area=Math.round(area * 100D) / 100D;

        for(int i=0;i<n;i++){
            double sum=0;
            int pX=C.get(i);
            int pY=D.get(i);
            double areaApB=Math.abs(aX*(pY-bY)+pX*(bY-aY)+bX*(aY-pY))/2;
            double areaCpB=Math.abs(cX*(pY-bY)+pX*(bY-cY)+bX*(cY-pY))/2;
            double areaDpA=Math.abs(dX*(pY-aY)+pX*(aY-dY)+aX*(dY-pY))/2;
            double areaDpC=Math.abs(dX*(pY-cY)+pX*(cY-dY)+cX*(dY-pY))/2;
            if(areaApB==0|| areaCpB==0|| areaDpA==0 || areaDpC==0)
                continue;
            sum=areaApB+areaCpB+areaDpA+areaDpC;
            sum=Math.round(sum * 100D) / 100D;
            if(sum==area)
                count++;


        }
        return count;
    }

    public static void main(String args[]){
        ArrayList<Integer> a=new ArrayList<Integer>();
        ArrayList<Integer> b=new ArrayList<Integer>();
        ArrayList<Integer> c=new ArrayList<Integer>();
        ArrayList<Integer> d=new ArrayList<Integer>();
        a.add(0);a.add(-2);a.add(2);a.add(4);
        b.add(0);b.add(2);b.add(6);b.add(4);
        c.add(1);c.add(2);c.add(1);c.add(5);c.add(-3);//c.add(2);
        d.add(3);d.add(4);d.add(2);d.add(5);d.add(1);//d.add(2);
        //a.add(6);//a.add(5);a.add(3);
        solve(a,b,c,d);
    }


}
