package interviewBits.graphs;

import java.util.*;




public class CommutableIslands {

    class Graph{

        int V, E;    // V-> no. of vertices & E->no.of edges
        Edge edges[]; // collection of all edges

        // Creates a graph with V vertices and E edges
        Graph(int v, int e)
        {
            V = v;
            E = e;
            edges = new Edge[E];
            for (int i=0; i<e; ++i)
                edges[i] = new Edge();
        }

        public int find(Subset[] subsets,int x){

            if(subsets[x].parent!=x){
                subsets[x].parent=find(subsets,subsets[x].parent);
            }
            return subsets[x].parent;

        }

        public void union(Subset[] subsets, int x, int y){

            int xroot= find(subsets,x);
            int yroot= find(subsets,y);

            if(subsets[xroot].rank>subsets[yroot].rank){
                subsets[yroot].parent=xroot;
            }else if(subsets[xroot].rank<subsets[yroot].rank){
                subsets[xroot].parent=yroot;
            }
            else {
                subsets[xroot].parent=yroot;
                subsets[yroot].rank++;
            }

        }


    }

    class Subset{
        int parent;
        int rank;
    }

    class Edge implements Comparable<Edge>
    {
        int src, dest, weight;


        // Comparator function used for sorting edges based on
        // their weight
        public int compareTo(Edge compareEdge)
        {
            return this.weight-compareEdge.weight;
        }
    }

    public int solve(int A, int[][] B) {
        int result=0;
        int E= B.length;
        Graph graph= new Graph(A,E);
        Subset[] subsets= new Subset[A];

        for(int i=0;i<A;i++) {
            subsets[i] =new Subset();
            subsets[i].parent=i;
            subsets[i].rank=0;
        }


        for(int i=0;i<B.length;i++){
            graph.edges[i].src=B[i][0]-1;
            graph.edges[i].dest=B[i][1]-1;
            graph.edges[i].weight=B[i][2];
        }
        Arrays.sort(graph.edges);
        int mstEdges=0;
        int i=0;

        while (mstEdges<A-1){
            Edge next_Edge= graph.edges[i++];

            int x= graph.find(subsets,next_Edge.src);
            int y= graph.find(subsets,next_Edge.dest);

            if(x!=y){
                result+=next_Edge.weight;
                graph.union(subsets,x,y);
                mstEdges++;
            }

        }
        return result;

    }

    public static void main(String s[]){

        int[][] weights= new int[5][3];
        weights[0]=new int[]{1,2 ,1 };
        weights[1]=new int[]{2,3 ,4 };
        weights[2]=new int[]{1,4 ,3 };
        weights[3]=new int[]{4,3 ,2 };
        weights[4]=new int[]{1,3 ,10 };

        System.out.println(new CommutableIslands().solve(4,weights));

    }

}
