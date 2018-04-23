package test;

import java.util.Stack;

public class Solution32 {
    public int longestValidParentheses(String s) {
    	int largest = 0;
    	Stack<Integer> stk = new Stack<>();
    	stk.push(-1);
    	for(int i = 0; i < s.length(); i++){
    		char c = s.charAt(i);
    		if(c == '('){
    			stk.push(i);
    		}
    		if(c == ')'){
    			stk.pop();
    			if(stk.size() == 0){
    				stk.push(i);
    			}
    			else{
    				largest = Math.max(largest, i - stk.peek());
    			}
    			
    		}
    		
    	}
    	return largest;
    }
}
