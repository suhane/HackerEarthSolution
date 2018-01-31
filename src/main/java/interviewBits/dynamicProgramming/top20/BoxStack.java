package interviewBits.dynamicProgramming.top20;

import java.util.ArrayList;
import java.util.Arrays;

public class BoxStack {

    public static int maxStackHeight(ArrayList<ArrayList<Integer>> a){

        int n=a.size();
        Box[] boxes= new Box[3*n];
        int index=0;
        for (int i=0;i<n;i++){

            ArrayList<Integer> box=a.get(i);
            int h=box.get(0);
            int d=box.get(1);
            int w=box.get(2);

            boxes[index++]=new Box(h,d,w);
            boxes[index++]=new Box(d,w,h);
            boxes[index++]=new Box(w,h,d);
        }

        Arrays.sort(boxes);

        int[] height= new int[3*n];
        height[0]=boxes[0].height;
        int max_Height=Integer.MIN_VALUE;
        for(int i=1;i<3*n;i++){
            height[i]=boxes[i].height;

            for(int j=0;j<=i;j++){

                if(boxes[j].width>boxes[i].width && boxes[j].depth>boxes[i].depth){
                    height[i]=Math.max(height[j]+boxes[i].height,height[i]);
                }
            }
            max_Height=Math.max(height[i],max_Height);
        }
        return max_Height;
    }

    private static class Box implements Comparable<Box>{
        int height;
        int depth;
        int width;

        Box(int h, int d, int w){
            this.height=h;
            this.depth=d;
            this.width=w;
        }


        public int compareTo(Box o) {
            return  o.width*o.depth - this.depth*this.width;
        }

        @Override
        public String toString() {
            return "["+height+","+depth+","+width+"]";
        }
    }

    public static void main(String args[]){

        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp= new ArrayList<Integer>();
        temp.add(4);temp.add(6);temp.add(7);
        a.add(temp);
        temp= new ArrayList<Integer>();
        temp.add(1);temp.add(2);temp.add(3);
        a.add(temp);
        temp= new ArrayList<Integer>();
        temp.add(4);temp.add(5);temp.add(6);
        a.add(temp);
        temp= new ArrayList<Integer>();
        temp.add(10);temp.add(12);temp.add(32);
        a.add(temp);

        System.out.println(maxStackHeight(a));

    }
}
