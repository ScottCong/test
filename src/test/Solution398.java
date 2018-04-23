package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution398 {
//	Map<Integer,List<Integer>> map = new HashMap<>();
//    public Solution398(int[] nums) {
//        for(int i = 0; i < nums.length; i++){
//        	int target = nums[i];
//        	System.out.println(target);
//        	List<Integer> number = map.getOrDefault(target, new LinkedList<>() );
//        	number.add(i);
//        	map.put(target, number);
//        }
//    }
//    
//    public int pick(int target) {
//        List<Integer> ret = map.get(target);
//        int len = ret.size();
//        int rd = (int)(Math.random() * len);
//        return ret.get(rd);
//    }
	int[] nums;
    public Solution398(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int i = 1;
        int ans = 0;
        for(int index = 0; index < this.nums.length; index++){
        	if(nums[index] != target)continue;
        	int randnum = (int)(Math.random() * i);
        	if(randnum == 0){
        		ans = index;
        	}
        	i++;
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
