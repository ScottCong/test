package test;

import java.util.Stack;

public class Solution682 {
    public int calPoints(String[] ops) {
    	int ans = 0;
        Stack<Integer> stk = new Stack<Integer>();
        for(String s: ops){
            //System.out.println(s);
        	switch(s){
        	case "D":
                stk.push(stk.peek() * 2);
        		ans += stk.peek();
        	    break;
        	case "C":
        		ans -= stk.pop();
                break;
        	case "+":
                int toPush = 0;
        		int tmp = stk.pop();
                toPush += tmp;
                toPush += stk.peek();
        		ans += tmp;
        		ans += stk.peek();
        		stk.push(tmp);
                stk.push(toPush);
                break;
        	default:
        		stk.push(Integer.valueOf(s));
                ans += stk.peek();
                break;
        	}
        		
        }
        return ans;
    }
}
