package interviewBits.Array;

import interviewBits.Array.Interval;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by labuser on 7/15/17.
 */
public class MergeOverlappingIntervals {
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int n=intervals.size();
        Interval[] intervalArr=new Interval[n];
        int index=0;
        for(Interval el:intervals){
            intervalArr[index++]=el;
        }
        Arrays.sort(intervalArr);
        index=0;
        for(Interval el:intervalArr){
            intervals.set(index++,el);
        }

        for(int i=0;i<n-1;i++){
            Interval curr=intervals.get(i);
            Interval next=intervals.get(i+1);
            if(isOverlap(curr,next)){
                int newStart=Math.min(curr.start, next.start);
                int newEnd=Math.max(curr.end, next.end);
                Interval insertInterval=new Interval(newStart,newEnd);
                intervals.set(i,insertInterval);
                intervals.remove(i+1);
                i--;
                n--;

            }
        }

        return intervals;

    }
    private static boolean isOverlap(Interval curr, Interval newInterval) {
        return Math.max(curr.start,newInterval.start)<=Math.min(curr.end,newInterval.end);
    }

    public static void main(String args[]){
        ArrayList<Interval> in= new ArrayList<Interval>();

        int[] times={2141136, 6363582,49844342, 69670172,75717793, 86352601};
        int n=times.length;
        for(int i=0;i<n-1;i+=2){
            in.add(new Interval(times[i],times[i+1]));
        }


        ArrayList<Interval> in2= new ArrayList<Interval>();
        in2.add(new Interval(1,3));
        in2.add(new Interval(2,6));
        in2.add(new Interval(8,10));
        in2.add(new Interval(15,18));
        merge(in2 );

    }
}
