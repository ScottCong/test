package test;

import java.util.LinkedList;

public class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0)return 0;
        
        LinkedList<Integer> lst = new LinkedList<>();
        LinkedList<Integer> cnt = new LinkedList<>();
        lst.add(1);
        cnt.add(1);
        for(int i = 1; i < nums.length; i++){
        	int toCom = nums[i];
        	int maxLen = 1;
        	for(int j = 0; j < i; j++){
        		if(toCom > nums[j]){
        			maxLen = Math.max(maxLen, lst.get(j) + 1);
        		}
        	}
        	lst.add(maxLen);
        	int count = 0;
        	for(int j = 0; j < i; j++){
        		if(nums[i] > nums[j] && lst.get(j) == maxLen - 1){
        			count += cnt.get(j);
        		}
        	}
            if(maxLen == 1)count = 1;
        	cnt.add(count);
        }
        int maxLen = Integer.MIN_VALUE;
        for(int i: lst){
        	maxLen = Math.max(maxLen, i);
        }
        //System.out.println(cnt);
        if(maxLen == 1){
        	return nums.length;
        }
        int ans = 0;
        for(int i = 0; i < lst.size(); i++){
        	if(lst.get(i) == maxLen){
        		ans += cnt.get(i);
        	}
        }
        return ans;
    }
}
