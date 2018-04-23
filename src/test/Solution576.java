package test;

public class Solution576 {
    public int findPaths(int m, int n, int N, int i, int j) {
    	int mod = 1000000007;
        int[][] board = new int[m][n];
        board[i][j] = 1;
        int ans = 0;
        for(int step = 0; step <= N; step++){
        	for(int ver = 0; ver < n; ver++){
        		ans = (ans + board[0][ver]) % mod;
        		ans = (ans + board[m - 1][ver])% mod;
        		
        	}
        	for(int hor = 0; hor < i; hor++){
        		ans = (ans + board[hor][0]) % mod;
        		ans = (ans + board[hor][n - 1])% mod;
        	}
        	ans = (ans - board[0][0] - board[m - 1][0] - board[0][n - 1] - board[m - 1][n - 1])%mod;
        	int[][] next = new int[m][n];
        	for(int p = 0; p < m; p++){
        		for(int q = 0; q < n; q++){
        			int upper = (q - 1)< 0? 0: board[p][q - 1];
        			int left = (p - 1)<0? 0: board[p - 1][q];
        			int down = (q + 1)>=n?0:board[p][q+ 1];
        			int right = (p + 1)>=m?0:board[p + 1][q];
        			next[p][q] = upper + left + down + right;
        		}
        	}
        }
        return ans;
    }
}
