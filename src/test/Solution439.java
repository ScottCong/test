package test;

import java.util.Stack;

public class Solution439 {
    public String parseTernary(String expression) {
        if(expression == null || expression.length() == 0)return "";
        Stack<Character> stk = new Stack<>();
        for(int idx = expression.length() - 1; idx >= 0; idx--){
        	if(stk.size() > 0 && stk.peek() == '?'){
        		stk.pop();
        		Character ifTrue = stk.pop();
        		stk.pop();
        		Character ifFalse = stk.pop();
        		if(expression.charAt(idx) == 'T')stk.push(ifTrue);
        		if(expression.charAt(idx) == 'F')stk.push(ifFalse);
        	}
        	else{
        		stk.push(expression.charAt(idx));
        	}
        }
        String ans = String.valueOf(stk.pop());
        return ans;
    }
}
