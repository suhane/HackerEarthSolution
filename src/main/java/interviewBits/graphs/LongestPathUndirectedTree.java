package interviewBits.graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LongestPathUndirectedTree {

    class Graph{
        int V;

        LinkedList<Integer> adj[];

        public Graph(int v){

            this.V=v;
            adj=new LinkedList[v];
            for(int i=0;i<v;i++){
                adj[i]=new LinkedList<Integer>();
            }
        }

        public void addEdge(int i, int j){
            adj[i].add(j);
            adj[j].add(i);
        }

        public Pair bfs(int v){

            int[] dis=new int[V];
            Pair pair=new Pair();
            pair.distance = 0;
            Arrays.fill(dis,-1);
            Queue<Integer> q= new LinkedList<Integer>();
            q.offer(v);
            dis[v]=0;
            while(!q.isEmpty()){
                int t=q.poll();
                Iterator<Integer> it= adj[t].iterator();
                while(it.hasNext()){
                    int u=it.next();
                    if(dis[u]==-1){
                        q.offer(u);
                        dis[u]=dis[t]+1;
                        if (dis[u] > pair.distance)
                        {
                            pair.distance = dis[u];
                            pair.vertex = u;
                        }
                    }
                }

            }
            return pair;

        }


    }

    class Pair{
        int vertex;
        int distance;
    }

    public int solve(int[] A) {
        Graph g=new Graph(A.length);
        for(int i=0;i<A.length;i++){
            if(A[i]==-1)
                continue;
            g.addEdge(i,A[i]);
        }

        Pair p1= g.bfs(0);
        Pair p2= g.bfs(p1.vertex);
        return p2.distance;
    }

    public static void main(String args[]){
        System.out.println(new LongestPathUndirectedTree().solve(new int[]{-1, 0, 0, 0, 3}));
    }
}
