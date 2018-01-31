package test;
import java.io.*;
import java.util.*;

public class PrefixSolution {
    class TrieNode{
        char content;
        int count;
        boolean isEnd;
        LinkedList<TrieNode> childlist;
        
        //constructor
        TrieNode(char c){
            childlist=new LinkedList<TrieNode>();
            content=c;
            count=0;
            isEnd=false;
        }
        
        TrieNode subnode(char c){
            if(childlist!=null){
                for(TrieNode child: childlist){
                    if(child.content==c)
                        return child;
                }
            }
            return null;
        }
        
    }
    class Trie{
        TrieNode root;
        //constructor
        Trie(){
            root=new TrieNode(' ');
        }
        
        public boolean insertAndCheckPrefix(String word){
            TrieNode current=root;
            for(char ch:word.toCharArray() ){
                TrieNode child=current.subnode(ch);
                if(child!=null){
                	if(child.isEnd==true)
                		return true;
                	else
                		current=child;
                }
                else{
                	current.childlist.add(new TrieNode(ch));
                	current=current.subnode(ch);
                    
                }
            }
            current.isEnd=true;
            if(current.childlist.size()!=0){
            	return true;
            }
            
            return false;
        }
    }
    class InputReader {
	    private BufferedReader reader;
	    private StringTokenizer tokenizer;
	 
	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream));
	        tokenizer = null;
	    }
	 
	    public String next() {
	        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
	            try {
	                tokenizer = new StringTokenizer(reader.readLine());
	            } catch (IOException e) {
	                throw new RuntimeException(e);
	            }
	        }
	        return tokenizer.nextToken();
	    }
	 
	    public int nextInt() {
	        return Integer.parseInt(next());
	    }
	 
	}
    public static void main(String[] args) {
    	PrefixSolution pre=new PrefixSolution();
    	InputStream inputStream = System.in;
    	OutputStream outputStream = System.out;
    	InputReader in = pre.new InputReader(inputStream);
    	PrintWriter out = new PrintWriter(outputStream);
    	int n = in.nextInt();
        solve(pre,n,in,out);
        out.close();
        System.exit(0);
    }
    
    public static void solve(PrefixSolution s,int testNumber, InputReader in, PrintWriter out) {
        String word;
        //ArrayList<String > a = new ArrayList<>();
        //ArrayList<String>  q = new ArrayList<>();
        Trie trie = s.new Trie();
        boolean isSetDetermined=false;
        while(testNumber-->0){
            word = in.next();
            if(isSetDetermined==false){
            	if(trie.insertAndCheckPrefix(word)==true){
            		out.println("BAD SET");
            		out.println(word);
            		isSetDetermined=true;
            	}		
            }
        }
        if(isSetDetermined==false){
            out.println("GOOD SET");
        }
	}   
}