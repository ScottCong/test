package test;

public class Solution813 {
    public double largestSumOfAverages(int[] A, int K) {
        int N = A.length;
        double[][] memo = new double[N+1][N+1];
        double cur = 0;
        for (int i = 0; i < N; ++i) {
            cur += A[i];
            memo[i + 1][1] = cur / (i + 1);
        }
        return search(memo, K, N, A);
    }
    
    public double search(double[][] memo, int k, int n, int[] A){
    	if(memo[n][k] > 0) return memo[n][k];
    	double cur = 0;
    	for(int i = n - 1; i > 0; i--){
    		cur += A[i];
    		memo[n][k] = Math.max(memo[n][k], search(memo, k - 1, i, A) + cur / (n - i)) ;
    	}
    	return memo[n][k];
    }
}
