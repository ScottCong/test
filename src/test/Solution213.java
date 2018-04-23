package test;

import java.util.Arrays;

public class Solution213 {
    public int rob(int[] nums) {
        if(nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];
        int rob1 = robNoCir(Arrays.copyOfRange(nums, 1, nums.length));
        int rob2 = robNoCir(Arrays.copyOfRange(nums, 0, nums.length - 1));
        return Math.max(rob1, rob2);
    }
    public int robNoCir(int[] nums){
    	int[] robCur = new int[nums.length];
    	int[] noRobCur = new int[nums.length];
    	robCur[0] = nums[0];
    	noRobCur[0] = 0;
    	for(int i = 1; i < nums.length; i++){
    		robCur[i] = noRobCur[i - 1] + nums[i];
    		noRobCur[i] = Math.max(robCur[i - 1], noRobCur[i - 1]);
    	}
    	return Math.max(robCur[nums.length - 1], noRobCur[nums.length - 1]);
    }
}
