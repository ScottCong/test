package test;

public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int xBegin = 0;
        int xEnd = n - 1;
        int yBegin = 0;
        int yEnd = n - 1;
        int count = 1;
        while(xBegin <= xEnd && yBegin <= yEnd){
        	for(int x = xBegin; x <= xEnd; x++){
        		ans[yBegin][x] = count;
        		count++;
        	}
        	yBegin++;
        	for(int y = yBegin; y <= yEnd; y++){
        		ans[y][xEnd] = count;
        		count++;
        	}
        	xEnd--;
        	if(yBegin <= yEnd){
        		for(int x = xEnd; x >= xBegin; x--){
        			ans[yEnd][x] = count;
        			count++;
        		}
        	}
        	yEnd--;
        	if(xBegin <= xEnd){
        		for(int y = yEnd; y >= yBegin; y--){
        			ans[y][xBegin] = count;
        			count++;
        		}
        	}
        	xBegin++;
        }
        return ans;
    }
}
