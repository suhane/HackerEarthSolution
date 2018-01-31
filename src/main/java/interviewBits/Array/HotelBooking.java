package interviewBits.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by suhane on 7/2/17.
 */
public class HotelBooking {
    public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

        int n=arrive.size();
        Event[] events=new Event[n*2];
        for(int i=0;i<n;i++){
            events[i]= new Event(arrive.get(i),EventType.ARRIVAL);
        }
        for(int i=0;i<n;i++){
            events[n+i]= new Event(depart.get(i),EventType.DEPARTURE);
        }

        Arrays.sort(events);
        int guests=0;
        for(Event e :events){
            if(e.eventtype.equals(EventType.ARRIVAL)){
                guests++;
            }
            else
                guests--;

            if(guests>K)
                return false;
        }

        return true;

    }



    public enum EventType {
        ARRIVAL,
        DEPARTURE;
    }

    static class Event implements Comparable<Event>{
        public int getDay() {
            return day;
        }

        private int day;

        public EventType getEventtype() {
            return eventtype;
        }

        private EventType eventtype;

        public Event(int day,EventType ev){
            this.day=day;
            this.eventtype=ev;
        }

        public int compareTo(Event that){
            if(this.day==that.day){
                if(this.eventtype.equals(EventType.DEPARTURE))
                    return -1;
                else
                    return 1;
            }
            return this.day-that.day;

        }
        public String toString(){

            return "["+this.day+","+this.eventtype.toString()+"]";
        }

    }


    public static void main(String args[]){
        ArrayList<Integer>  arrival= new ArrayList<Integer>();
        ArrayList<Integer>  departure= new ArrayList<Integer>();
        arrival.add(1);arrival.add(2);arrival.add(3);// arrival.add(5); arrival.add(5);
        departure.add(2);departure.add(3);departure.add(4);// departure.add(9); departure.add(12);
        hotel(arrival,departure,3);

    }
   static class Booking implements Comparable<Booking> {
        private int start;
        private int end;

        public int getStart(){
            return this.start;
        }
       public int getEnd(){
           return this.end;
       }

        public Booking(int start, int end){
            this.start=start;
            this.end=end;
        }

        public int compareTo(Booking that){
            return this.end-that.end;
        }

        public String toString(){

            return "["+this.start+","+this.end+"]";
        }



    }
}
