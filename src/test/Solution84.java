package test;
//hard
//Given n non-negative integers representing the histogram's bar height 
//where the width of each bar is 1, 
//find the area of largest rectangle in the histogram.
//For example,
//Given heights = [2,1,5,6,2,3],
//return 10.

//For explanation, please see http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
//核心就是计算以每一个长方形为最短边时，最大的矩形是多少
//矩形以升序排列时，往stack里push，当遇上降序时，在stack里的bar如果比当前bar大，就可以算出当前bar为最小的最大矩形
//当前bar为右极限，stack.peek()为左极限，
//( (stk.size() == 0? i: i - stk.peek() - 1)) * heights[currentInd])就是最大矩形

import java.util.Stack;

public class Solution84 {
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
}
