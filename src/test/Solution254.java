package test;

import java.util.*;
public class Solution254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new LinkedList<>();
        helper(result, new LinkedList<Integer>(), n, 2);
        return result;
        
    }
    public void helper(List<List<Integer>> result, LinkedList<Integer> item, int n, int start){
    	if(n <= 1){
    		if(item.size() > 1)result.add(new LinkedList<Integer>(item));
    		return;
    	}
    	else{
    		for(int i = start; i <= n; i++){
    			if(n % i == 0){
    				item.add(i);
    				helper(result, item, n/i, i);
    				item.remove(item.size() - 1);
    			}
    		}
    	}
    	
    }
}
