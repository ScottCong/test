package test;

//妈的超时了
//public int jump(int[] nums) {
//	if(nums.length <= 1)return 0;
//    int[] jumpSteps = new int[nums.length];
//    for(int i = 0; i < nums.length; i++){
//    	jumpSteps[i] = Integer.MAX_VALUE;
//    }
//    jumpSteps[0] = 0;
//    for(int index = 0; index < nums.length; index++){
//        //System.out.println(jumpSteps[index]);
//    	int steps = nums[index];
//    	int initStep = jumpSteps[index];
//    	for(int step = 1; step <= steps; step++){
//    		if(index + step < nums.length)jumpSteps[index + step] = Math.min(jumpSteps[index + step], initStep + 1);
//    	}
//    }
//    return jumpSteps[nums.length - 1];
//}


public class Solution45 {
    public int jump(int[] nums) {
    	if(nums.length <= 1)return 0;
    	int smallestIndex = nums.length - 1;
    	int step = 0;
    	while(smallestIndex > 0){
    		int smallest = 0;
    		for(int i = smallestIndex - 1; i >=0; i--){
    			if(i + nums[i] >= smallestIndex)smallest = i;
    		}
    		step++;
    		smallestIndex = smallest;
    		//System.out.println(smallestIndex);
    	}
    	return step;
    }
}
