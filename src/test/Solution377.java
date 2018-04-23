package test;

import java.util.Arrays;
import java.util.*;

public class Solution377 {
	HashSet<Integer> set;
	HashMap<Integer,Integer> map;
    public int combinationSum4(int[] nums, int target) {
    	set = new HashSet<>();
    	map = new HashMap<>();
    	Arrays.sort(nums);
        for(int num: nums){
        	set.add(num);
        	map.put(0, 1);
        }
        int ans = dp(nums, target);
        return ans;
    }
    public int dp(int[] nums, int target){
    	if(map.containsKey(target))return map.get(target);
    	int ans = 0;
    	for(int num: set){
    		if(target - num >= 0){
    			if(map.containsKey(target - num)){
    				ans += map.get(target - num);
    			}
    			else ans += dp(nums, target - num);
    		}
    	}
    	map.put(target, ans);
    	return ans;
    }

}
