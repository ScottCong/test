package test;

import java.util.Stack;

public class Solution394 {
    public String decodeString(String s) {
        int k = 0;
        Stack<String> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
        	String str = String.valueOf(chars[i]);
            //System.out.println(str);
        	if(str.equals("[")){
        		Stack<String> kStk = new Stack<>();
        		while(stk.size() > 0){
        			kStk.push(stk.pop());
        		}
        		k = calculateK(kStk);
        	}
        	else if(str.equals("]")){
        		Stack<String> strStk = new Stack<>();
        		while(stk.size() > 0){
        			strStk.push(stk.pop());
        		}
        		addToBuilder(sb, k, strStk);
        	}
            else{
        		stk.push(str);
        	}
        }
        String ans = sb.toString();
        return ans;
    }
    public int calculateK(Stack<String> stk){
    	int val = 0;
    	while(stk.size() > 0){
    		val *= 10;
    		val += Integer.valueOf(stk.pop());
    	}
    	return val;
    }
    public void addToBuilder(StringBuilder sb, int k, Stack<String> stk){
    	String str = "";
    	while(stk.size() > 0){
    		str = str + stk.pop();
    	}
    	for(int i = 0; i < k; i++){
    		sb.append(str);
    	}
    	return;
    }
}
