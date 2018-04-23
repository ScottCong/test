package test;

public class Solution764 {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        
    	int[][] matrix = new int[N][N];
    	for(int[] mine: mines){
    		matrix[mine[0]][mine[1]] = 1;
    	}
    	
    	int[][] ltr = new int[N][N];
    	int[][] rtl = new int[N][N];
    	int[][] utd = new int[N][N];
    	int[][] dtu = new int[N][N];
    	
    	for(int i = 0; i < N; i++){
    		for(int j = 0; j < N; j++){
    			if(matrix[i][j] == 1)continue;
    			if(i == 0)utd[i][j] = 1;
    			else utd[i][j] = utd[i - 1][j] + 1;
    			if(j == 0)ltr[i][j] = 1;
    			else ltr[i][j] = ltr[i][j - 1] + 1;
    		}
    	}
    	
    	for(int i = N - 1; i >= 0; i--){
    		for(int j = N - 1; j >= 0; j--){
    			if(matrix[i][j] == 1)continue;
    			if(i == N - 1)dtu[i][j] = 1;
    			else dtu[i][j] = dtu[i + 1][j] + 1;
    			if(j == N - 1)rtl[i][j] = 1;
    			else rtl[i][j] =rtl[i][j + 1] + 1;
    		}
    	}
    	
    	int max = 0;
    	for(int i = 0; i < N; i++){
    		for(int j = 0; j < N; j++){
    			max = Math.max(max, findMin(ltr[i][j], rtl[i][j],utd[i][j],dtu[i][j]));
    		}
    	}
    	return max;
    }
    
    int findMin(int a, int b, int c, int d){
    	int min = a;
    	min = Math.min(min, b);
    	min = Math.min(min, c);
    	min = Math.min(min, d);
    	return min;
    }
}
