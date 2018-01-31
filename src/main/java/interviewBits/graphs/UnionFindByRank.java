package interviewBits.graphs;

public class UnionFindByRank {

    int V,E;
    Edge[] edges;
    class Edge{
        int src,dest;
    }

    class Subset {

        int parent;
        int rank;
    }

    UnionFindByRank(int v, int e){
        this.V=v;
        this.E=e;

        edges=new Edge[e];
        for(int i=0;i<e;i++){
            edges[i]=new Edge();
        }
    }

    public int find(Subset[] subsets, int i){

        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    public void union(Subset[] subsets, int x, int y){
        int xroot=find(subsets,x);
        int yroot=find(subsets,y);

        // Attach smaller rank tree under root of high rank tree
        // (Union by Rank)

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

            // If ranks are same, then make one as root and increment
            // its rank by one
        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    public boolean detectCycle(){
        Subset[] subsets= new Subset[V];
        for (int v = 0; v < V; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        for(int i=0;i<E;i++){

            int x=find(subsets,edges[i].src);
            int y=find(subsets,edges[i].dest);

            if(x==y)
                return true;
            union(subsets,x,y);

        }
        return false;
    }

    

}
