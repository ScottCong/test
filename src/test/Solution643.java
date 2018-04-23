package test;

public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        double count = 0;
        int index = 0;
        double sum = 0;
        double max = Double.MIN_VALUE;
        for(int i: nums){
            if(count < k){
                sum += i;
                count++;
            }
            else{
                max = Math.max(max, sum / k);
                max += i;
                max = max - (double)(nums[index]);
                index++;
            }
        }
        max = Math.max(max, sum / k);
        return max;
        
    }
}
