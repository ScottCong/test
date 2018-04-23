package test;

import java.util.*;

public class Solution433_MinGenMut {
	int ans = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
    	int[] used = new int[bank.length];
//        HashSet<String> set = new HashSet<>();
//        for(String s: bank)set.add(s);
//        if(!set.contains(end))return -1;
    	helper(start, end, used, bank, 0);
        if(ans == Integer.MAX_VALUE)return -1;
        return ans;
        
    }
    public void helper(String cur, String target,int[] used, String[] bank,int steps){
    	if(cur.equals(target)){
    		ans = Math.min(ans, steps);
    		return;
    	}
    	for(int i = 0; i < bank.length; i++){
    		if(used[i] == 0 && ChangeOne(cur, bank[i])){
    			used[i] = 1;
    			helper(bank[i], target, used, bank, steps + 1);
    			used[i] = 0;
    		}
    	}
    	return;
    }
    public boolean ChangeOne(String first, String second){
    	if(first.length() != second.length())return false;
    	int dif = 0;
    	for(int i =0; i < first.length(); i++){
    		if(first.charAt(i) != second.charAt(i)){
    			dif += 1;
    			if(dif > 1)return false;
    		}
    	}
    	if(dif == 1)return true;
    	else return false;
    }
}
