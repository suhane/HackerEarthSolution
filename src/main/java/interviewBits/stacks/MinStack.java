package interviewBits.stacks;

import java.util.Stack;

public class MinStack {

    Stack<Integer> s1;
    Stack<Integer> s2;

    MinStack(){
        s1=new Stack<Integer>();
        s2= new Stack<Integer>();
    }


    public void push(int x) {
        s1.push(x);
        if(s2.isEmpty())
            s2.push(x);
        else{
            if(x<=s2.peek());
                s2.push(x);
        }
    }

    public void pop() {
        if(!s1.isEmpty()){
            int x=s1.pop();
            if(!s2.isEmpty() && x==s2.peek())
                s2.pop();
        }

    }

    public int top() {
        if(s1.isEmpty())
            return -1;
        return s1.peek();
    }

    public int getMin() {
        if(s2.isEmpty())
            return -1;
        return s2.peek();

    }

    public static void main(String s[]){
        MinStack sol= new MinStack();
        sol.push(10);
        sol.push(9);
        System.out.println(sol.getMin());
        sol.push(8);
        System.out.println(sol.getMin());
        sol.push(7);
        System.out.println(sol.getMin());
        sol.push(6);
        System.out.println(sol.getMin());
        sol.pop();
        System.out.println(sol.getMin());
        sol.pop();
        System.out.println(sol.getMin());
        sol.pop();
        System.out.println(sol.getMin());
        sol.pop();
        System.out.println(sol.getMin());
        sol.pop();
        System.out.println(sol.getMin());
    }
}
