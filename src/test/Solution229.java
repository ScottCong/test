package test;

import java.util.*;

public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
    	List<Integer> ans = new LinkedList<>();
        int count1 =0, count2 = 0;
        int cand1 = Integer.MAX_VALUE,cand2 = Integer.MAX_VALUE - 1;
        for(int i = 0; i< nums.length; i++){
        	if(nums[i] == cand1){
        		count1++;
        	}
        	else if(nums[i] == cand2){
        		count2++;
        	}
        	else if(count1 == 0){
        		cand1 = nums[i];
        		count1++;
        	}
        	else if(count2 == 0){
        		cand2 = nums[i];
        		count2++;
        	}
        	else{
        		count1--;
        		count2--;
        	}
        }
        count1 = 0;
        count2 = 0;
        for(int i : nums){
        	if(i == cand1)count1++;
        	if(i == cand2)count2++;
        }
        if(count1 > nums.length/3){
        	ans.add(cand1);
        }
        if(count2 > nums.length/3){
        	ans.add(cand2);
        }
        return ans;
    }
}
