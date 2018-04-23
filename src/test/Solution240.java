package test;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)return false;
        int row = 0;
        int col = matrix[0].length - 1;
        int rows = matrix.length - 1;
        //int cols = matrix[0].length -1;
        while(row <= rows && col >= 0){
        	if(matrix[row][col] == target)return true;
        	if(matrix[row][col] > target)col--;
        	else if(matrix[row][col] < target)row++;
        }
        return false;  
    }
}
