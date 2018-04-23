package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//find unique pairs
public class Solution532 {
    public int findPairs(int[] nums, int k) {
        if(k == 0){
        	findEqual(nums);
        }
        int ans = 0;
        //Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        for(Integer i: nums){
        	set.add(i);
        }
        Integer[] Newnums = new Integer[set.size()];
        int init = 0;
        for(int i : set){
        	Newnums[init] = i;
        	init++;
        }
        Arrays.sort(Newnums);
        int index1 = 0;
        int index2 = 0;
        while(index2 < Newnums.length){
        	if((Newnums[index2] - Newnums[index1]) == k){
        		ans++;
        		index1++;
        		index2++;
        	}
        	else if((Newnums[index2] - Newnums[index1]) > k){
        		index1++;
        	}
        	else if((Newnums[index2] - Newnums[index1]) < k){
        		index2++;
        	}
        }
        return ans;
        
    }
    public int findEqual(int[] nums){
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	int ans = 0;
    	for(int i: nums){
    		map.put(i, map.getOrDefault(i, 0) + 1);
    	}
    	for(int i: map.values()){
    		if(i > 0)ans++;
    	}
    	return ans;
    }
}


//smarter way
//public class Solution {
//    public int findPairs(int[] nums, int k) {
//        if (nums == null || nums.length == 0 || k < 0)   return 0;
//        
//        Map<Integer, Integer> map = new HashMap<>();
//        int count = 0;
//        for (int i : nums) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//        
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (k == 0) {
//                //count how many elements in the array that appear more than twice.
//                if (entry.getValue() >= 2) {
//                    count++;
//                } 
//            } else {
//                if (map.containsKey(entry.getKey() + k)) {
//                    count++;
//                }
//            }
//        }
//        
//        return count;
//    }
//}