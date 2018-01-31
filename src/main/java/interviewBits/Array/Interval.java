package interviewBits.Array;

/**
 * Created by labuser on 7/14/17.
 */
public class Interval implements Comparable<Interval>{
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

    public int compareTo(Interval that){
        return this.start-that.start;
    }

    public String toString(){
        return "["+this.start+","+this.end+"]";
    }
    }