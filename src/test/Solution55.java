package test;

import java.util.LinkedList;

public class Solution55 {
    public boolean canJump(int[] nums) {
        LinkedList<Integer> Zeros = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
        	if(nums[i] <= 0){
        		Zeros.add(i);
        	}
        }
        if(Zeros.size() == 0){
        	return true;
        }
        int init = Zeros.get(Zeros.size() - 1);
        for(int i = Zeros.size() - 1; i >=0; i--){
        	int zero = Zeros.get(i);
        	if(zero > init)continue;
        	init = zero;
        	while(nums[init] <= zero - init){
        		init--;
        		if(init < 0){
        			return false;
        		}
        	}
        	
        }
        return true;
    }
}