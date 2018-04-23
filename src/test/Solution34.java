package test;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)return new int[]{-1,-1};
        int start = 0;
        int end = nums.length - 1;
        while(end > start){
        	int mid = (start + end) / 2;
        	int val = nums[mid];
        	if(val > target){
        		end = mid - 1;	
        	}
        	else if(val < target){
                start = mid + 1;
        	}
        	else if(val == target){
        		end = mid;
        	}
        }
        int left =(end >= 0 && nums[end] == target)? end: -1;
        start = 0;
        end = nums.length - 1;
        while(end > start){
        	int mid = (start + end) / 2;
        	int val = nums[mid];
        	if(val > target){
        		end = mid - 1;
        	}
        	else if(val < target){
                start = mid + 1;
                
        	}
        	else if(val == target){
        		if(end - start == 1){
        			start = (nums[end] == target)?end:start;
        			break;
        		}
        		start = mid;
        	}
        }
        int right = (start <= nums.length - 1 && nums[start] == target)?start: -1;
        return new int[]{left,right};
    }
}
