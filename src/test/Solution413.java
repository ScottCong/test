package test;
//等差数列数量计算
public class Solution413 {
    public int numberOfArithmeticSlices(int[] A) {
    	if(A.length == 0)return 0;
    	if(A.length == 1)return 1;
        boolean[][] isArith = new boolean[A.length][A.length];
        int[][] interval = new int[A.length][A.length];
        for(int i = 0; i< A.length ; i++){
        	isArith[i][i] = true;
        	interval[i][i] = 0;
        }
        for(int i = 0; i<A.length - 1; i++){
        	isArith[i][i+1] = true;
        	interval[i][i+1] = A[i+1] - A[i];
        }
        int counter = 0;
        for(int length = 2; length < A.length; length++){
        	for(int start = 0; start < A.length; start++){
        		int end = start + length;
        		if(end > A.length)break;
        		if(isArith[start][end - 1]){
        			//in this step,[start][end -1] is Arithmetic, so we want to check if [start][end] is Arith
        			if(A[end] - A[end - 1] == interval[start][end - 1]){
        				counter++;
        				interval[start][end] = interval[start][end - 1];
        				isArith[start][end] = true;
        			}
        		}
        	}
        }
        return counter;
    }
}
