package test;

import java.util.Arrays;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)return new int[0];
        int start = 0;
        int end = k - 1;
        int curMaxIndex = findMaxIndex(Arrays.copyOfRange(nums, start, end + 1));
        int[] ans = new int[nums.length - k + 1];
        ans[0] = nums[curMaxIndex];
        for(int i = 1; i <= nums.length - k ; i++){
        	start++;
        	end++;
        	if(start > curMaxIndex){
        		curMaxIndex = i + findMaxIndex(Arrays.copyOfRange(nums, start, end + 1));
        		ans[i] = nums[curMaxIndex];
        	}
        	else if(nums[end] >= nums[curMaxIndex]){
        		curMaxIndex = end;
        		ans[i] = nums[curMaxIndex];
        	}
        	else{
        		ans[i] = nums[curMaxIndex];
        	}
        }
        return ans;
    }
    public int findMaxIndex(int[] nums){
    	int index = 0;
    	int max = Integer.MIN_VALUE;
    	for(int i = 0; i < nums.length; i++){
    		if(nums[i] >= max){
    			max = nums[i];
    			index = i;
    		}
    	}
    	return index;
    }
}
