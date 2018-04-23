package test;

public class Solution529 {
	char[][] ans;
    public char[][] updateBoard(char[][] board, int[] click) {
        ans = new char[board.length][board[0].length];
        if(board[click[0]][click[1]] == 'M'){
        	for(int i = 0; i < board.length; i++){
        		for(int j = 0; j < board[0].length; j++){
        			ans[i][j] = board[i][j];
        		}
        	}
        	ans[click[0]][click[1]] = 'X';
        	return ans;
        }
    	for(int i = 0; i < board.length; i++){
    		for(int j = 0; j < board[0].length; j++){
    			ans[i][j] = ' ';
    		}
    	}
    	reveal(board, click[0],click[1]);
    	for(int i = 0; i < board.length; i++){
    		for(int j = 0; j < board[0].length; j++){
    			if(ans[i][j] == ' ')ans[i][j] = board[i][j];
    		}
    	}
    	return ans;
    }
    public void reveal(char[][] board, int i, int j){
    	if(i < 0 || i >= board.length || j < 0 || j >= board[0].length ||ans[i][j] != ' ')return;
    	int mines = checkMine(board, i, j);
    	if(board[i][j] == 'B' || mines == 0){
    		ans[i][j] = 'B';
    		for(int m = -1; m <= 1; m++){
    			for(int n = -1; n <= 1; n++){
    				reveal(board, i + m, j + n);
    			}
    		}
    	}
    	else{
    		ans[i][j] = (char)(mines + 48);
    	}
    }
    public int checkMine(char[][] board, int i, int j){
    	int mines = 0;
    	for(int l = -1; l <= 1; l++){
    		for(int m = -1; m <= 1; m++){
    			if(l == 0 && m == 0)continue;
    			if(i + l >= 0 && i + l < board.length && j + m >= 0 && j + m < board[0].length && board[i + l][j + m] == 'M')
    				mines++;
    		}
    	}
    	return mines;
    }
}
