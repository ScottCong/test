package test;

import java.util.LinkedList;
import java.util.List;

public class Solution163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int toAdd = lower;
        LinkedList<String> ans = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
        	int num = nums[i];
        	if(num == toAdd){
        		toAdd += 1;
        		continue;
        	}
        	if(num > toAdd){
        		String toAppend = getRange(toAdd, num - 1);
        		ans.add(toAppend);
        	}
        }
        if(upper > nums[nums.length - 1]){
        	ans.add(getRange(nums[nums.length - 1], upper));
        }
        return ans;
    }
    public String getRange(int n1, int n2){
    	long N1 = (long)n1;
    	long N2 = (long)n2;
    	String ans = (N1 == N2)?String.valueOf(N1):String.valueOf(N1) + "->" + String.valueOf(N2);
    	return ans;
    }
}
