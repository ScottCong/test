package test;
//hard
//combined from 84
import java.util.Stack;

public class Solution85 {
    public int largestRectangleArea(int[] heights) {
    	int max = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < heights.length; i++){
        	if(stk.size() == 0 || heights[stk.peek()] <= heights[i]){
        		stk.push(i);
        	}
        	else if(heights[stk.peek()] > heights[i] ){
        		while(stk.size() > 0 && heights[stk.peek()] > heights[i]){
        			int currentInd = stk.pop();
        			max = Math.max(max, ( (stk.size() == 0? i: i - stk.peek() - 1)) * heights[currentInd]);
        		}
        		stk.push(i);
        	}
        }
        int finalInd = heights.length;
        while(stk.size() > 0){
        	int currentInd = stk.pop();
        	max = Math.max(max, ((stk.size() == 0 ? finalInd:finalInd - stk.peek() - 1) * heights[currentInd]) );
        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length <=0 || matrix[0].length <=0)return 0;
        int max = 0;
        int[] current = new int[matrix[0].length];
        int[] prev = new int[matrix[0].length];
        for(int i = 0; i<matrix[0].length; i++){
        	if(matrix[0][i] == '1'){
        		current[i] = 1;
        		prev[i] = 1;
        	}
        }
        max = this.largestRectangleArea(current);
        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
            	if(matrix[i][j] == '1'){
            		current[j] += 1;
            	}
            	else current[j] = 0;
            }
            max = Math.max(max, this.largestRectangleArea(current));
        }
        return max;
    }
}
