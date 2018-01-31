package interviewBits.tree.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by labuser on 8/8/17.
 */
public class ShortestUniquePrefix {

    TrieNode root;
    public ArrayList<String> prefix(ArrayList<String> a) {

        root= new TrieNode(' ');
        ArrayList<String> output= new ArrayList<String>();
        for(String str: a){
            insert(str);
        }

        for(String str: a){
            output.add(find(str));
        }
        return output;

    }

    private String find(String str) {

        String res="";
        TrieNode current = root;
        for(char ch: str.toCharArray()){
            TrieNode child=current.subNode(ch);
            res+=child.content;
            if(child.count==1)
                return res;
            else{
                current=child;
            }

        }
        return res;
    }

    private void insert(String a) {
        TrieNode current = root;
        for(char ch: a.toCharArray()){

            TrieNode child=current.subNode(ch);
            if(child!=null){
                current=child;
            }else{
                current.childList.add(new TrieNode(ch));
                current = current.subNode(ch);
            }
            current.count++;
        }
        current.isEnd=true;

    }

    private class TrieNode{
        char content;
        boolean isEnd;
        int count;
        LinkedList<TrieNode> childList=null;

        public TrieNode(char c){
            content=c;
            childList= new LinkedList<TrieNode>();
            count=0;
            isEnd=false;
        }

        public TrieNode subNode(char ch){
            if(childList!=null){
                for(TrieNode eachChild: childList){
                    if(eachChild.content==ch)
                        return eachChild;
                }
            }
            return null;
        }

    }
    public static void main(String args[]) {
        ArrayList<String> input= new ArrayList<String>(Arrays.asList("zebra", "dog", "duck", "dove"));
        ShortestUniquePrefix sol= new ShortestUniquePrefix();
        System.out.println(sol.prefix(input));
    }

}
