package test;

public class Solution718 {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        for(int a = 0; a < A.length; a++){
        	for(int b = 0; b < B.length; b++){
        		if(A[a] == B[b])dp[a][b] = 1;
        	}
        }
        int ans = 0;
        for(int a = A.length - 2; a >= 0; a--){
        	for(int b = B.length - 2; b >= 0; b--){
        		if(A[a] == B[b]){
        			dp[a][b] = dp[a + 1][b + 1] + 1;
        			ans = Math.max(ans, dp[a][b]);
        		}
        	}
        }
        return ans;
    }
}
