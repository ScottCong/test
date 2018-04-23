package test;

import java.util.HashMap;
//用sliding window
//找一串字符串里，只包含k个不同字符时，最长的子串
public class Solution340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int ans = Integer.MIN_VALUE;
        if(k == 0 || s.length() == 0)return 0;
        while(end < s.length()){
        	char toAdd = s.charAt(end);
        	if(map.get(toAdd) == null){
        		map.put(toAdd, 1);
        	}
        	else{
        		map.put(toAdd, map.get(toAdd) + 1);
        	}
        	while(map.size() > k){
        		char toDel = s.charAt(start);
        		int toDelCount = map.get(toDel);
        		//System.out.println(toDelCount);//test, should not have null or 0
        		map.put(toDel, toDelCount - 1);
        		if(toDelCount - 1 == 0)map.remove(toDel);
        		start++;
        	}
        	ans = Math.max(ans, end - start + 1);
        	end++;
        }
        return ans;
    }
}
