package test;

import java.util.Stack;

public class Solution224 {
    public int calculate(String s) {
        Stack<String> stk = new Stack<>();
        char[] chars = s.toCharArray();
        int val = 0;
        for(int i = 0; i < chars.length; i++){
        	String str = String.valueOf(chars[i]);
        	if(str.equals(" "))continue;
        	if(!str.equals(")")){
        		if(str.equals("+") || str.equals("-")){
        			String value = String.valueOf(val);
        			stk.push(value);
        			stk.push(str);
        			val = 0;
        		}
        		else if(str.equals("(")){
        			stk.push(str);
        		}
        		else{
        			val *= 10;
        			val += Integer.valueOf(str);
        		}
        	}
        	else{
                stk.push(String.valueOf(val));
        		Stack<String> tmpStk = new Stack<>();
        		while(true){
                    String pstr = stk.pop();
        			if(!pstr.equals("("))tmpStk.push(pstr);
                    else break;
        		}
        		String parVal = calculateReverse(tmpStk);
                val = Integer.valueOf(parVal);
        	}
        }
        stk.push(String.valueOf(val));
        Stack<String> tmpStk = new Stack<>();
        while(stk.size() > 0){
        	String str = stk.pop();
        	tmpStk.push(str);
        }
        String ans = calculateReverse(tmpStk);
        return Integer.valueOf(ans);
            
    }
    public String calculateReverse(Stack<String> stk){
    	int tmp = 0;
    	int val = 0;
    	String sign = "+";
    	while(stk.size() > 0){
    		String str = stk.pop();
            System.out.println(str);
    		if(str.equals("+") || str.equals("-")){

    			sign = str;
    		}
    		else{
    			tmp = Integer.valueOf(str);
    			if(sign.equals("+")){
    				val = val + tmp;
    			}
    			else if(sign.equals("-")){
    				val = val - tmp;
    			}
    		}
    	}
        // System.out.println(String.valueOf(val));
        // System.out.println("\n");
    	return String.valueOf(val);
    }
}
