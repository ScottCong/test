package test;

import java.util.SortedSet;
import java.util.TreeSet;

public class Solution220 {
	//Given an array of integers, find out whether there are two distinct indices i and j 
	//in the array such that the absolute difference between nums[i] and nums[j] is at most t 
	//and the absolute difference between i and j is at most k.
	
	
	//跟BST没啥关系， 用treeset(有序的hashset，可以用.subset或者.floor 和.ceiling查值)
	//或者用bucket(每个值除以要求的差值，维持一个长度为k的map，把bucket都放进去，要是已经有一样大小的bucket就有解，
	//或者相邻的bucket符合要求也可以)
	
	
//	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//	    if (k < 1 || t < 0) return false;
//	    TreeSet<Integer> values = new TreeSet<Integer>(); 
//	    for (int i = 0; i < nums.length; i++) {
//	        Integer floor = values.floor(nums[i] + t);
//	        Integer ceiling = values.ceiling(nums[i] - t);
//	        if ((floor != null && floor >= nums[i]) || (ceiling != null && ceiling <= nums[i])) {
//	            return true;
//	        }
//	        if (values.size() >= k) {
//	            values.remove(nums[i - k]);
//	        }
//	        values.add(nums[i]);
//	    }
//	    return false;
//	}
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (k < 1 || t < 0 || nums == null || nums.length < 2) {
            return false;
        }

        SortedSet<Long> set = new TreeSet<Long>();

        for (int j = 0; j < nums.length; j++) {

            SortedSet<Long> subSet = set.subSet((long) nums[j] - t,
                    (long) nums[j] + t + 1);
            // 集合不为空，则表示找到解
            if (!subSet.isEmpty()) {
                return true;
            }

            if (j >= k) {
                set.remove((long) nums[j - k]);
            }

            set.add((long) nums[j]);
        }

        return false;

    }
}
