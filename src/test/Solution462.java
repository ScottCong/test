package test;

import java.util.Arrays;

public class Solution462 {
    public int minMoves2(int[] nums) {
    	if(nums.length <= 1) return 0;
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int steps = 0;
        while(i < j){
        	steps += nums[j] - nums[i];
        	j--;
        	i++;
        }
        return steps;
    }
}
