package test;

import java.util.*;
//generate all the subsets
public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
        	if(map.get(num) == null){
        		map.put(num, 0);
        	}
        	map.put(num, map.get(num)+ 1);
        	set.add(num);
        }
        ans.add(new LinkedList<Integer>());
        for(int num: set){
        	LinkedList<LinkedList<Integer>> tmp = new LinkedList<>();
        	for(int i = 1; i<= map.get(num); i++){
        		for(List<Integer> subset: ans){
        			if(subset.size() ==0 && i == 0)continue;
        			LinkedList<Integer> tmpLst = new LinkedList<>();
        			tmpLst.addAll(subset);
        			for(int j = 0; j < i; j++)tmpLst.add(num);
        			tmp.add(tmpLst);
        		}
        	}
        	ans.addAll(tmp);
        }
        return ans;
    }
}
