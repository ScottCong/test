package test;

import java.util.Stack;

public class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
        	int asteroid = asteroids[i];
        	if(stk.size() == 0)stk.push(asteroid);
        	else{
        		if(asteroid > 0){
        			stk.push(new Integer(asteroid));
        		}
        		else{
        			while(stk.size() > 0 && stk.peek() > 0 && asteroid < 0){
        				if(Math.abs(stk.peek()) < Math.abs(asteroid)){
        					stk.pop();
        				}
        				else if(Math.abs(stk.peek()) > Math.abs(asteroid)){
        					asteroid = 0;
        				}
        				else{
        					stk.pop();
        					asteroid = 0;
        				}
        			}
        			if(asteroid != 0)stk.push(asteroid);
        		}
        	}
        	
        }
        int[] ans = new int[stk.size()];
        for(int i = ans.length - 1; i >= 0; i--){
        	ans[i] = stk.pop();
        }
        return ans;
    }
}
