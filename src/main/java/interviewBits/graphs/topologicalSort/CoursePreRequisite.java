package interviewBits.graphs.topologicalSort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class CoursePreRequisite {


    class Graph{

        int V;
        LinkedList<Integer> adj[];

        public Graph(int v){
            V=v;
            adj=new LinkedList[v];
            for(int i=0;i<v;i++){
                adj[i]=new LinkedList<Integer>();
            }
        }

        public void addEdge(int src, int dest){
            adj[src].add(dest);
        }
    }

    public int solve(int A, int[] B, int[] C) {

        Graph g= new Graph(A);
        int edges=B.length;
        for(int i=0;i<edges;i++){
            g.addEdge(B[i],C[i]);
        }
        Stack<Integer> stack= new Stack<Integer>();
        boolean visited[] = new boolean[A];
        for(int i=0;i<A;i++){
            if(!visited[i])
                topologicalSort(i,stack,visited,g);

        }
        return 0;
    }

    private void topologicalSort(int v, Stack<Integer> stack, boolean[] visited, Graph g) {

        visited[v]=true;
        Iterator<Integer> it= g.adj[v].iterator();
        while (it.hasNext()){
            int i=it.next();
            if(!visited[i])
                topologicalSort(i,stack,visited,g);
        }
        stack.push(v);

    }

    public static void main(String s[]){

        int[] A=new int[]{5,5,4,4,2,3};
        int[] B= new int[]{2,0,0,1,3,1};



        new CoursePreRequisite().solve(6,A,B);

    }


}
