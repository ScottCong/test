package test;

import java.util.*;

public class Soution488 {
	HashMap<Character, Integer> map;
	int ans = Integer.MAX_VALUE;
    public int findMinStep(String board, String hand) {
    	map = new HashMap<>();
        board = board + "#";
        for(int i = 0; i < hand.length(); i++){
        	int val = map.getOrDefault(hand.charAt(i), 0);
        	map.put(hand.charAt(i), val + 1);
        }
        helper(board, 0);
        ans = ans == Integer.MAX_VALUE? -1: ans;
        return ans;
    }
    public void helper(String board, int steps){
    	String s = deleteDup(board);
       // System.out.println(board);
    	if(s.equals("#")){
            //System.out.println(steps);
    		ans = Math.min(ans, steps);
    	}
    	for(int i = 0, j = 0; j < s.length(); j++){
    		if(s.charAt(i) == s.charAt(j))continue;
    		int need = 3 - (j - i);
    		if(map.keySet().contains(s.charAt(i)) && map.get(s.charAt(i)) >= need){
    			map.put(s.charAt(i),map.get(s.charAt(i)) - need);
    			helper(s.substring(0, i) + s.substring(j), steps + need);
    			map.put(s.charAt(i),map.get(s.charAt(i)) + need);
    		}
            i = j;
    	}
    	
    }
    public String deleteDup(String s){
    	for(int i = 0, j = 0; j < s.length(); j++){
//    		if(j == s.length() && (j - i) > 3){
//    			return deleteDup(s.substring(0, i));
//    		}
    		if(s.charAt(i) == s.charAt(j))continue;
    		else if((j - i) >= 3)return deleteDup(s.substring(0, i) + s.substring(j));
    		else i = j;
    	}
    	return s;
    }
}
