package interviewBits.Array;


import java.util.ArrayList;

/**
 * Created by suhane on 7/8/17.
 */
public class Triplets {

    public int solve(ArrayList<String> A) {

        ArrayList<Float> rangeA=new ArrayList<Float>();
        ArrayList<Float> rangeB=new ArrayList<Float>();
        ArrayList<Float> rangeC=new ArrayList<Float>();
        float max1A=0,max2A=0,max3A=0;
        float min1A=Float.MAX_VALUE,min2A=Float.MAX_VALUE,min1B=Float.MAX_VALUE,min2B=Float.MAX_VALUE,min1C=Float.MAX_VALUE;
        for(String s:A){
            float num=Float.parseFloat(s);
            if(num>0 && num<=0.33){
                rangeA.add(num);
            }else
                if(num>0.33 && num<=1){
                    rangeB.add(num);
                }else
                    if(num>1 && num<2){
                        rangeC.add(num);
                    }
        }
        if(max1A+max2A+max3A>1)
            return 1;

            return 0;
    }
}
