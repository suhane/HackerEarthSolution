package prep.set348.telephonic;

import java.util.Stack;

public class Graph {

    private boolean[][] adjmatrix;

    private class Vertex{
        private char label;
        private boolean isVisited;

        public Vertex(char label){
            this.label=label;
            this.isVisited=false;
        }
    }

    public Graph(){


    }

    public void dfs(){

        Stack<Vertex> s= new Stack<Vertex>();
        
    }




}
