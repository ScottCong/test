package test;

import java.util.Stack;

public class Solution739_DailyTmp_Stack {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i= 0; i < temperatures.length; i++){
        	if(stk.size() == 0){
        		stk.push(i);
        	}
        	else{
        		if(temperatures[i] <= temperatures[stk.peek()]){
        			stk.push(i);
        		}
        		else{
        			while(stk.size() > 0 && temperatures[i] > temperatures[stk.peek()]){
        				int ind = stk.pop();
        				ans[ind] = i - ind;
        			}
        			stk.push(i);
        		}
        	}
        }
        while(stk.size() > 0){
        	ans[stk.pop()] = 0;
        }
        return ans;
    }
}
