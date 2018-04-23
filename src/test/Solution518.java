package test;

public class Solution518 {
    public int change(int amount, int[] coins) {
    	int[][] board = new int[amount + 1][coins.length + 1];
        board[0][0] = 1;
    	for(int i = 1; i <= coins.length; i++){
    		board[0][i] = 1;
    		for(int j = 0; j <= amount; j++){
    			board[j][i] = board[j][i - 1] + (j >= coins[i - 1]? board[j - coins[i - 1]][i]: 0);
    		}
    	}
    	return board[amount][coins.length];
    }
}
