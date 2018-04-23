package test;

import java.util.Arrays;

public class Solution164_MaxGap_PigeonHole {
    public int maximumGap(int[] nums) {
        if(nums.length < 2)return 0;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i: nums){
        	max = Math.max(max, i);
        	min = Math.min(min, i);
        }
        double gap = (max - min) / (double)(nums.length);
        //System.out.println(gap);
        int[][] buckets = new int[nums.length][2];
        for(int i = 0; i < buckets.length; i++){
        	buckets[i] = new int[]{-1,-1};
        }
        for(int i: nums){
            //System.out.println(i);
        	int index = (int)((i - min)/gap);
            //System.out.println(index);
        	int[] bucket = (i != max)?buckets[index]: buckets[buckets.length - 1];
        	int first = bucket[0], second = bucket[1];
        	// System.out.println(first);
        	// System.out.println(second);
        	if(first == -1){
        		first = i;
        		second = i;
        	}
        	else{
        		second = Math.max(i, second);
        		first = Math.min(i, first);
        	}
        	bucket[0] = first;
        	bucket[1] = second;
        }
        
        
        int ans = 0;
        int begin = -1;
        for(int[] bucket: buckets){
        	if(bucket[0] == -1)continue;
        	if(begin == -1)begin = bucket[1];
        	else{
        		ans = Math.max(ans, bucket[0] - begin);
        		begin = bucket[1];
        		}
        }
        return ans;
    }
}
