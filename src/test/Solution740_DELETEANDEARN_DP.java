package test;

import java.util.*;

public class Solution740_DELETEANDEARN_DP {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0)return 0;
    	TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for(int i: nums){
            //System.out.println(i);
        	set.add(i);
        	map.put(i, map.getOrDefault(i, 0) + 1);
        }
        ArrayList<Integer> cand = new ArrayList<>();
        int[] del = new int[set.size()];
        int[] ndel = new int[set.size()];
        for(int i: set){
        	cand.add(i);
        }
        del[0] = cand.get(0) * map.get(cand.get(0));
        ndel[0] = 0;
        for(int i = 1; i < cand.size(); i++){
        	if(cand.get(i) != (cand.get(i - 1) + 1)){
        		del[i] = Math.max(del[i - 1], ndel[i - 1]) + cand.get(i) * map.get(cand.get(i));
        		ndel[i] = Math.max(del[i - 1], ndel[i - 1]);
        	}
        	else{
        		del[i] = ndel[i - 1] + cand.get(i) * map.get(cand.get(i));
        		ndel[i] = Math.max(del[i - 1], ndel[i - 1]);
        	}
        }
        // System.out.println(Arrays.toString(del));
        // System.out.println(Arrays.toString(ndel));
        
        return Math.max(del[del.length - 1], ndel[ndel.length - 1]);
    }
}
