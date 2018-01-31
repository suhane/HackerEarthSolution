package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ContactSolution {
	
	public class Trie {
		
		public class TrieNode {
			char content;
			boolean isEnd;
			int count;
			LinkedList<TrieNode> childList; 
			/* Constructor */
		    public TrieNode(char c)
		    {
		        childList = new LinkedList<TrieNode>();
		        isEnd = false;
		        content = c;
		        count = 0;
		    }  
		    public TrieNode subNode(char c)
		    {
		        if (childList != null)
		            for (TrieNode eachChild : childList)
		                if (eachChild.content == c)
		                    return eachChild;
		        return null;
		    }
		}
		
		private TrieNode root;
		public Trie()
	    {
	        root = new TrieNode(' '); 
	    }
		
		/* Function to insert word */
	    public int countPatterns(String word)
	    {
	    	TrieNode current = root; 
	    	for(char ch : word.toCharArray()){
	    		TrieNode child = current.subNode(ch);
	    		if (child != null)
	                current = child;
	    		else
	    			return 0;
	    	}
	    	
	    		return current.count;
	    }
	    
		
		/* Function to insert word */
	    public void insert(String word)
	    {
	              
	        TrieNode current = root; 
	        for (char ch : word.toCharArray() )
	        {
	            TrieNode child = current.subNode(ch);
	            if (child != null)
	                current = child;
	            else 
	            {
	                 current.childList.add(new TrieNode(ch));
	                 current = current.subNode(ch);
	            }
	            current.count++;
	        }
	        current.isEnd = true;
	    }
	    
	    /* Function to search for word */
	    public boolean search(String word)
	    {
	        TrieNode current = root;  
	        for (char ch : word.toCharArray() )
	        {
	            if (current.subNode(ch) == null)
	                return false;
	            else
	                current = current.subNode(ch);
	        }      
	        if (current.isEnd == true) 
	            return true;
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
		 long startTime = System.currentTimeMillis();  
		 ContactSolution s=new ContactSolution();
		 InputStream inputStream = System.in;
	     OutputStream outputStream = System.out;
	     InputReader in = s.new InputReader(inputStream);
	     PrintWriter out = new PrintWriter(outputStream);
	        int n = in.nextInt();
	        solve(s,n,in,out);
	        out.close();
	        System.out.println("Time : "+(System.currentTimeMillis()-startTime)+"ms");
	        System.exit(0);
        
          
    }
	
	public static void solve(ContactSolution s,int testNumber, InputReader in, PrintWriter out) {
        String op, word;
        //ArrayList<String > a = new ArrayList<>();
        //ArrayList<String>  q = new ArrayList<>();
        Trie trie = s.new Trie();
        while(testNumber-->0){
            op = in.next();
            word = in.next();
 
 
            if(op.equals("add")){
                //a.add(word);
                trie.insert(word);
            }else if(op.equals("find")){
                //q.add(word);
                out.println(trie.countPatterns(word));
            }
        }
	}   
}
	
	