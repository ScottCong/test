package test;
//复习treeset + max rectangle in matrix!!!!!
import java.util.TreeSet;

public class Solution363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix.length == 0 || matrix[0].length == 0)return 0;
        //index of left and right,this will form two loops that iterate all the column combo
        int max = Integer.MIN_VALUE;
        for(int left = 0; left < matrix[0].length; left++){
            int[] colSum = new int[matrix.length];
        	for(int right = left; right < matrix[0].length; right++){
        		for(int i = 0; i < matrix.length; i++){
        			colSum[i] += matrix[i][right];
        		}
        		int curSum = maxSubSum(colSum,k);
        		//System.out.println(curSum);
        		max = Math.max(max, curSum);
        	}
        }      
        return max;
        
    }
    public int maxSubSum(int[] nums,int k){
    	TreeSet<Integer> set = new TreeSet<>();
    	//treeset可以输出给定值小的最大数
    	int cum = 0;
    	int[] sums = new int[nums.length];
    	int max = Integer.MIN_VALUE;
    	for(int i = 0; i < nums.length; i++){
    		cum+= nums[i];
    		sums[i] = cum;
    	}
    	set.add(0);
    	for(int i = 0; i < nums.length; i++){
        	Integer j = set.ceiling(sums[i] - k);
        	if(j != null)max = Math.max(max, sums[i] - j);
        	set.add(sums[i]);
    	}
    	return max;
    }
}
