package test;

import java.util.*;

public class Solution216 {
	LinkedList<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k > 9 || n > 45)return this.ans;
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        backTracking(0, nums, k, n, new LinkedList<Integer>());
        return this.ans;
        
    }
    public void backTracking(int start, int[] nums,int remain, int target, List<Integer> candidates){
    	if(remain == 0)return;
    	if(start >= nums.length)return;
    	for(int i = start + 1; i < nums.length; i++){
    		int num = nums[i];
    		if(num > target)break;
    		if(num == target && remain == 1){
    			List<Integer> oneAns = new LinkedList<>();
    			oneAns.addAll(candidates);
    			oneAns.add(num);
    			this.ans.add(oneAns);
    			break;
    		}
    		List<Integer> nextCan = new LinkedList<>();
    		nextCan.addAll(candidates);
    		nextCan.add(num);
    		backTracking(i, nums, remain - 1, target - num, nextCan);
    	}
    	return;
    }
}
