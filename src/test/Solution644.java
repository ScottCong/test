package test;

public class Solution644 {
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        double min  = Integer.MAX_VALUE;
        for(int i: nums){
        	max = Math.max(max, i);
        	min = Math.min(min, i);
        }
        double mid = (max + min)/2;
        double error = max - mid;
        while(error > 0.0001){
        	if(check(mid, k, nums)){
        		min = mid;
        		mid = (max + min) / 2;
        		error = max - mid;
        	}
        	else{
        		max = mid;
        		mid = (max + min) / 2;
        		error = max - mid;
        	}
        }
        return mid;
    }
    
    public boolean check(double mid, int k, int[] nums){
    	double sum = 0;
    	for(int i = 0; i < k; i++){
    			sum += nums[i] - mid;
    	}
    	if(sum >= 0)return true;
    	double subSum = 0;
    	double Minium = 0;
    	for(int i = k; i < nums.length; i++){
    		sum += nums[i] - mid;
    		subSum += nums[i - k] - mid;
    		Minium = Math.min(subSum, Minium);
    		if(sum - Minium >= 0)return true;
    	}
    	return false;
    }
//    public double findMaxAverage(int[] nums, int k) {
//        double max_val = Integer.MIN_VALUE;
//        double min_val = Integer.MAX_VALUE;
//        for (int n: nums) {
//            max_val = Math.max(max_val, n);
//            min_val = Math.min(min_val, n);
//        }
//        double prev_mid = max_val, error = Integer.MAX_VALUE;
//        while (error > 0.00001) {
//            double mid = (max_val + min_val) * 0.5;
//            if (check(nums, mid, k))
//                min_val = mid;
//            else
//                max_val = mid;
//            error = Math.abs(prev_mid - mid);
//            prev_mid = mid;
//        }
//        return min_val;
//    }
//    public boolean check(int[] nums, double mid, int k) {
//        double sum = 0, prev = 0, min_sum = 0;
//        for (int i = 0; i < k; i++)
//            sum += nums[i] - mid;
//        if (sum >= 0)
//            return true;
//        for (int i = k; i < nums.length; i++) {
//            sum += nums[i] - mid;
//            prev += nums[i - k] - mid;
//            min_sum = Math.min(prev, min_sum);
//            if (sum >= min_sum)
//                return true;
//        }
//        return false;
//    }
}
