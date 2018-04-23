package test;

import java.util.*;

public class Solution464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    	ArrayList<Integer> lst = new ArrayList<>(); 
    	for(int i = 1; i <= maxChoosableInteger; i++){
    		lst.add(i);
    	}
    	return helper(lst, desiredTotal);
    	
    }
    public boolean helper(ArrayList<Integer> pool, int desiredTotal){
    	for(int i = 0; i < pool.size(); i++){
    		int toChoose = pool.get(i);
    		pool.remove(i);
    		if(helper(pool, desiredTotal - toChoose)){
    			return false;
    		}
    		pool.add(i, toChoose);
    	}
    	return true;
    }
}
