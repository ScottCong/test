package test;

import java.util.*;

public class Solution611 {
    public int triangleNumber(int[] nums) {
    	Arrays.sort(nums);
    	int ans = 0;
    	if(nums.length <= 2)return 0;
    	for(int i = 0; i < nums.length - 2; i++){
    		int j = i + 1;
    		while(j < nums.length - 1){
    			for(int k = j + 1; k< nums.length;k++){
    				if(nums[i] + nums[j] > nums[k])ans++;
    				else break;
    			}
    			j++;
    		}
    	}
    	return ans;   
    }
}
