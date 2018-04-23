package test;

import java.util.Arrays;

public class Solution698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
    	if(k == 1)return true;
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if(sum % k != 0)return false;
        int target = sum / k;
        int row = nums.length - 1;
        if (nums[row] > target) return false;
        while (row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return search(new int[k], nums, target, k, row);
    }
    public boolean search(int[] sums, int[] nums, int target, int k, int index){
    	if(index == -1){
    		for(int sum : sums){
    			if(sum != target)return false;
    		}
    		return true;
    	}
    	int cur = nums[index];
    	for(int i = 0; i < k; i++){
    		if(sums[i] + cur <= target){
    			sums[i] += cur;
    			boolean res = search(sums, nums, target, k, index - 1);
    			if(res)return true;
    			sums[i] -= cur;
    		}
    	}
    	return false;
    }
}
