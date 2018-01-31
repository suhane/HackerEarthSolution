package interviewBits.graphs;

public class UnionFind {

    int V,E;
    Edge[] edges;
    class Edge{
        int src,dest;
    }

    UnionFind(int v,int e){
        this.V=v;
        this.E=e;

        edges=new Edge[e];
        for(int i=0;i<e;i++){
            edges[i]=new Edge();
        }
    }

    public int find(int[] parent, int i){
        if(parent[i]==-1)
            return i;
        return find(parent,parent[i]);
    }

    public void union(int[] parent, int x, int y){
        int xset=find(parent,x);
        int yset=find(parent,y);
        parent[xset]=yset;
    }

    public boolean detectCycle(){
        int[] parent= new int[V];
        for(int i=0;i<V;i++)
            parent[i]=-1;

        for(int i=0;i<E;i++){

            int x=find(parent,edges[i].src);
            int y=find(parent,edges[i].dest);

            if(x==y)
                return true;
            union(parent,x,y);

        }
        return false;
    }



}
