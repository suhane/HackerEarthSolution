package interviewBits.Array;

import interviewBits.Array.Interval;

import java.util.ArrayList;

/**
 * Created by labuser on 7/14/17.
 */
public class MergeIntervals {
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        int n=intervals.size();
        ArrayList<Interval> output= new ArrayList<Interval>();

        if(n==0){
            output.add(newInterval);
            return output;
        }

        Interval startInterval=intervals.get(0);
        Interval lastInterval=intervals.get(n-1);

        if(newInterval.end<startInterval.start){
            insertAt(intervals,output,0,newInterval);
            return output;
        }
        if(newInterval.start>lastInterval.end){
            insertAt(intervals,output,n,newInterval);
            return output;
        }

        if(newInterval.start<startInterval.start && newInterval.end>lastInterval.end){
            output.add(newInterval);
            return output;
        }



           for(int i=0;i<n;i++){
               Interval curr=intervals.get(i);

               if(curr.end<newInterval.start && (i==n-2 && newInterval.end<intervals.get(i+1).start)){
                   insertAt(intervals,output,i+1,newInterval);
                   return output;
               }

               int start=i;
               while(i<n && isOverlap(curr,newInterval)){
                   i++;
                   if(i<n)
                        curr=intervals.get(i);
               }
               if(start!=i){
                   int newStart=Math.min(intervals.get(start).start, newInterval.start);
                   int newEnd=Math.max(intervals.get(i-1).end, newInterval.end);
                   Interval insertInterval=new Interval(newStart,newEnd);
                   intervals.set(start,insertInterval);
                   int removeIndex=start+1;
                   for(int j=start+1;j<i;j++){
                       intervals.remove(removeIndex);
                   }
               }
               n=intervals.size();
           }

            return intervals;

    }

    private static void insertAt(ArrayList<Interval> intervals, ArrayList<Interval> output, int index, Interval newInterval) {
        int n=intervals.size();
        int i;
        for(i=0;i<n;i++){
            if(index==i){
                output.add(newInterval);
            }
            output.add(intervals.get(i));
        }
        if(index==n){
            output.add(newInterval);
        }
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
        in2.add(new Interval(3,5));
        in2.add(new Interval(8,10));
        insert(in,new Interval(72706854, 87016111) );

    }
}

