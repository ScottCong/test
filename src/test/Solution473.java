package test;


public class Solution473 {
    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length < 4)return false;
    	double val = 0;
        for(int i : nums){
        	val += i;
        }
        if(val % 4 != 0)return false;
        val /= 4;
        int v = (new Double(val)).intValue();
        int[] sums = new int[4];
        return dfs(nums, sums, 0, v);
        
    }
    public boolean dfs(int[] nums, int[] sums, int index, int target){
    	if(sums[0] == target && sums[1] == target && sums[2] == target && sums[3] == target)return true;
    	for(int i = 0; i < 4; i++){
    		if(sums[i] + nums[index] > target)continue;
    		sums[i] += nums[index];
    		if(dfs(nums, sums, index + 1, target))return true;
    		sums[i] -= nums[index];
    	}
    	return false;
    }
}
