package test;
//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//Find the minimum element.
//
//The array may contain duplicates.
public class Solution154 {
    public int findMin(int[] nums) {
        if(nums.length == 0)return Integer.MIN_VALUE;
        if(nums.length == 1)return nums[0];
        if(nums[nums.length - 1] > nums[0])return nums[0];
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            // System.out.println(low);
            // System.out.println(high);
        	if(nums[low] < nums[high])return nums[low];
        	int mid = (high + low) / 2;
        	if(high == mid || low == mid)return Math.min(nums[low], nums[high]);
        	if(nums[mid] > nums[low] || nums[mid] > nums[high])low = mid;
        	else if(nums[mid] < nums[high] || nums[mid] < nums[low])high = mid;
        	else if(nums[mid] == nums[high] && nums[mid] == nums[low]){
        		high--;
        		low++;
        	}
        }
        System.out.println(high);
        System.out.println(low);
        return nums[high];
    }
}
