package test;

import java.util.*;

public class Solution636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        int[] last_start = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(String s: logs){
        	String[] log = s.split(":");
        	int index = Integer.valueOf(log[0]);
        	int timeStamp = Integer.valueOf(log[2]);
        	String op = log[1];
        	if(op.equals("start")){
        		if(stk.size() == 0){
        			stk.push(index);
        			last_start[index] = timeStamp;
        			ans[index] += 1;
        		}
        		else{
        			int last_index = stk.peek();
        			ans[last_index] += timeStamp - last_start[last_index] - 1;
        			last_start[index] = timeStamp;
        			ans[index] += 1;
                    stk.push(index);
        		}
        		
        	}
        	else if(op.equals("end")){
        		if(stk.isEmpty())System.out.println("input??");
        		if(stk.peek() != index)System.out.println("meh");
        		int end_index = stk.pop();
        		ans[end_index] += timeStamp - last_start[end_index];
        		if(stk.size() > 0)last_start[stk.peek()] = timeStamp;
        	}
        }
        return ans;
    }
}
