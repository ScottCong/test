package test;

import java.util.HashMap;

//如果一个数i除以 k 的余数是 m，另外一个数j除以k的余数也是 m ， 那么 i-j一定可以整除k
public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
        	sum += nums[i];
        	int target = sum;
        	target = (k == 0)? target:target % k;
        	if(map.containsKey(target)){
        		if(i - map.get(target) > 1)return true;
        	}
        	else map.put(target, i);
        }
        return false;
        
    }
}
