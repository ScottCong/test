package test;

import java.util.Arrays;

public class Solution259 {
    public int threeSumSmaller(int[] nums, int target) {
    	Arrays.sort(nums);
    	int count = 0;
    	for(int i = 0; i < nums.length - 2; i++){
    		count += twoPointer(Arrays.copyOfRange(nums, i + 1, nums.length), target - nums[i]);
            //System.out.println(count);
    	}
    	return count;
    }
    
    public int twoPointer(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while(left < right){
        	if(nums[left] + nums[right] < target){
        		count += right - left;
        		left++;
        	}
        	else if(nums[left] + nums[right] >= target){
        		right--;
        	}
        }
        return count;
    }
}
