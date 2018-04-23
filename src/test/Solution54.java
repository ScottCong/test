package test;

import java.util.*;

public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        int yBegin = 0;
        int yEnd = matrix.length - 1;
        int xBegin = 0;
        int xEnd = matrix[0].length;
        while(xEnd >= xBegin && yEnd >= yBegin){
        	for(int x = xBegin; x <= xEnd; x++){
        		ans.add(matrix[yBegin][x]);
        	}
        	yBegin++;
        	for(int y = yBegin; y <= yEnd; y++){
        		ans.add(matrix[y][xEnd]);
        	}
        	xEnd--;
        	if(xBegin <= xEnd){
            	for(int x = xEnd; x >= xBegin; x--){
            		ans.add(matrix[yEnd][x]);
            	}
            	yEnd--;
        	}
        	if(yBegin <= yEnd){
        		for(int y = yEnd; y >= yBegin; y--){
        			ans.add(matrix[y][xBegin]);
        		}
        		xBegin++;
        	}
        }
        return ans;
    }
}
