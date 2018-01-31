package interviewBits.graphs;

public class DetectCoursePossible {

    private int find(int[] parent,int v){
        if(parent[v]==-1){
            return v;
        }
        return find(parent,parent[v]);
    }

    private void union(int[] parent, int x,int y){
        int xset=find(parent,x);
        int yset=find(parent,y);
        parent[xset]=yset;
    }

    public int solve(int A, int[] B, int[] C) {

        int[] parent= new int[A];
        for(int i=0;i<A;i++)
            parent[i]=-1;
        for(int i=0;i<B.length;i++){
            int x= find(parent,B[i]-1);
            int y= find(parent,C[i]-1);

            if(x==y)
                return 0;

            union(parent,x,y);
        }
        return 1;

    }

    public static void main(String s[]){
        /*
        int[] A=new int[]{5,5,4,4,2,3};
        int[] B= new int[]{2,0,0,1,3,1};
        */
        int[] A=new int[]{1, 2, 3 };
        int[] B= new int[]{2, 3, 1 };

        System.out.println(new DetectCoursePossible().solve(3,A,B));

    }

}
