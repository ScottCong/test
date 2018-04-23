package test;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        if(nums.length <= 1)return;
        int Zero = 0;
        while(nums[Zero] != 0)Zero++;
        int NZero = Zero;
        for(int i = NZero; i < nums.length; i++){
        	if(nums[NZero] == 0)continue;
        	int tmp = nums[NZero];
        	nums[NZero] = 0;
        	nums[Zero] = tmp;
        	Zero++;
        }
        return;
    }
}
