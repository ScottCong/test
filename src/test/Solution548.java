package test;

import java.util.HashSet;

//Example:
//Input: [1,2,1,2,1,2,1]
//Output: True
//Explanation:
//i = 1, j = 3, k = 5. 
//sum(0, i - 1) = sum(0, 0) = 1
//sum(i + 1, j - 1) = sum(2, 2) = 1
//sum(j + 1, k - 1) = sum(4, 4) = 1
//sum(k + 1, n - 1) = sum(6, 6) = 1

//Here j is used for middle cut, i for left cut and k for right cut.
//Iterate middle cuts and then find left cuts which divides the first half into two equal quarters, 
//store that quarter sums in the hashset. 
//Then find right cuts which divides the second half into two equal quarters and check if quarter sum is present in the hashset. 
//If yes return true.
public class Solution548 {
    public boolean splitArray(int[] nums) {
    	int[] sum = new int[nums.length];
    	int s = 0;
    	for(int i = 0; i < nums.length; i++){
    		s += nums[i];
    		sum[i] = s;
    	}
    	//System.out.println(Arrays.toString(sum));
        if(nums.length < 7)return false;
        for(int i = 3; i <= nums.length - 4; i++){
        	HashSet<Integer> set = new HashSet<>();
        	for(int x = 1; x <= i - 2; x++){
        		if(sum[x - 1] == sum[i - 1] - sum[x])set.add(sum[x]-nums[x]);
        	}
        	for(int x = i + 2; x<= nums.length - 2; x++){
        		if(sum[x - 1] - sum[i] == sum[nums.length - 1] - sum[x] && set.contains(sum[nums.length - 1] - sum[x])){
        			return true;
        		}
        	}
        }
        return false;
    }   
}
