package test;

import java.util.*;

public class Solution632 {
    public int[] smallestRange(List<List<Integer>> nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.size(); i++){
        	map.put(i, 0);
        }
        int[] ans = {Integer.MIN_VALUE / 2, Integer.MAX_VALUE / 2};
        while(true){
        	int min = Integer.MAX_VALUE;
        	int max = Integer.MIN_VALUE;
        	int minInd = 0;
        	for(int i = 0; i < nums.size(); i++){
        		int cur = nums.get(i).get(map.get(i));
        		if(cur < min)minInd = i;
        		min = Math.min(cur, min);
        		max = Math.max(cur, max);
        		
        	}
            // System.out.println(min);
            // System.out.println(max);
        	if(max - min < ans[1] - ans[0]){
        		ans[0] = min;
        		ans[1] = max;
        	}
        	if(map.get(minInd) >= nums.get(minInd).size() - 1){
        		break;
        	}
        	else{
        		map.put(minInd, map.get(minInd) + 1);
        	}
        }
        return ans;
    }
}

//public int[] smallestRange(List<List<Integer>> nums) {
//	int min = Integer.MAX_VALUE;
//	int max = Integer.MIN_VALUE;
//    Map<Integer, Integer> left = new HashMap<>();
//    Map<Integer, Integer> right = new HashMap<>();
//    for(int i = 0; i < nums.size(); i++){
//    	List<Integer> lst = nums.get(i);
//    	min = Math.min(min, lst.get(0));
//    	max = Math.max(max, lst.get(lst.size() - 1));
//    	left.put(i, 0);
//    	right.put(i, lst.size() - 1);
//    }
//    int[] ans = {min, max};
//    while(true){
//    	int smallestInd = 0;
//    	int smallest = Integer.MAX_VALUE;
//    	for(int i = 0; i < nums.size(); i++){
//    		List<Integer> lst = nums.get(i);
//    		int cur = lst.get(left.get(i));
//    		if(cur < smallest){
//    			smallest = cur;
//    			smallestInd = i;
//    		}
//    	}
//    	if(left.get(smallestInd) >= nums.get(smallestInd).size() - 1){
//    		ans[0] = smallest;
//    		break;
//    	}
//    	else{
//    		left.put(smallestInd, left.get(smallestInd) + 1);
//    		
//    	}
//    }
//    int maxAns = Integer.MIN_VALUE;
//    while(right.size() > 0){
//    	int maxInd = 0;
//    	int maxVal = Integer.MIN_VALUE;
//    	for(int i = 0; i < nums.size(); i++){
//    		List<Integer> lst = nums.get(i);
//    		if(right.get(i) != null){
//        		int cur = lst.get(right.get(i));
//        		if(cur > maxVal){
//        			maxVal = cur;
//        			maxInd = i;
//        		}
//    		}
//    	}
//    	if(right.get(maxInd) <= 0 || maxVal <= ans[0] || right.get(maxInd) == left.get(maxInd)){
//    		right.remove(maxInd);
//    		maxAns = Math.max(maxAns, maxVal);
//            ans[1] = maxAns;
//    	}
//    	else{
//    		right.put(maxInd, right.get(maxInd) - 1);
//    	}
//    }
//    
//    return ans;
//}
