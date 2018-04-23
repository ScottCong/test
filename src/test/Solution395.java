package test;

import java.util.*;

public class Solution395 {
    public int longestSubstring(String s, int k) {
        return helper(s, k);
    }
    public int helper(String s, int k){
        //System.out.println(s);
    	if(s.length() < k)return 0;
    	LinkedList<Integer> max = new LinkedList<>();
    	HashMap<Character, Integer> count = new HashMap<>();
    	for(char c: s.toCharArray()){
    		count.put(c, count.getOrDefault(c, 0) + 1);
    	}
    	HashSet<Character> set = new HashSet<>();
    	for(Character c: count.keySet()){
    		if(count.get(c) < k)set.add(c);
    	}
    	if(set.size() == 0)return s.length();
    	int start = 0;
    	for(int i = 0; i <= s.length(); i++){
    		if(i == s.length() || set.contains(s.charAt(i)) ){
    			max.add(helper(s.substring(start, i), k));
                start = i + 1;
    		}
    	}
    	int ans = 0;
    	for(int i: max){
    		ans = Math.max(ans, i);
    	}
    	return ans;
    }
}
