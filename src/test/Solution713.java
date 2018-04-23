package test;

//import java.util.Arrays;

public class Solution713 {
	//int ans = 0;
    public int numSubarrayProductLessThanK(int[] nums, int k) {
    	int ans = 0;
    	int prod = 1, left = 0;
    	for(int right = 0; right < nums.length; right++){
    		prod *= nums[right];
    		while(prod > k){
    			prod /= nums[left];
    			left++;
    		}
    		ans += right - left + 1;
    	}
    	return ans;
    }
//    public void helper(int[] nums, int index, int product, int k){
//    	if(index >= nums.length)return;
//    	while(index < nums.length){
//    		if(product * nums[index] <= k){
//    			ans += 1;
//    			helper(nums, index + 1, product * nums[index], k);
//    		}
//			while(index + 1 < nums.length && nums[index + 1] == nums[index])index++;
//			index++;
//    	}
//    }
}
