package test;

public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix == null || matrix.length ==0 || matrix[0].length == 0)return false;
    	if(matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target)return false;
        int[] hor = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++){
        	hor[i] = matrix[i][0];
        }
        int horInd = binarySearch(hor, target);
        int[] ver = matrix[horInd];
        int verInd = binarySearch(ver, target);
        if(matrix[horInd][verInd] != target)return false;
        else return true;
    }
    public int binarySearch(int[] nums, int target){
    	if(target > nums[nums.length - 1])return nums.length - 1;
    	int start = 0;
    	int end = nums.length - 1;
    	while(end > start){
    		int mid = (start + end) / 2;
    		if(nums[mid] > target){
    			end = mid - 1;
    		}
    		else if(nums[mid] < target){
    			start = mid + 1;
    		}
    		else return mid;
    	}
    	if(nums[start] > target)return start - 1;
    	else return start;
    }
}
