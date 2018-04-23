package test;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> lst = new ArrayList<Integer>();
        lst.add(-1);
        map.put(0, lst);
        for(int i = 0; i< nums.length; i++){
        	sum += nums[i];
        	ArrayList<Integer> list = map.get(sum - k);
        	if(list != null)ans += list.size();
            list = map.getOrDefault(sum, new ArrayList<Integer>());
            list.add(sum);
            map.put(sum,list);
        }
        return ans;
    }
}
