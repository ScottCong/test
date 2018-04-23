package test;

import java.util.Arrays;

public class Solution723_candycrush {
    public int[][] candyCrush(int[][] board) {
        boolean isOver = false;
        while(!isOver){
        	isOver = true;
        	int[][] hor = countCrushHor(board); 
        	int[][] ver = countCrushVer(board);
        	isOver = delete(board,hor,ver);
        	resort(board);
        }
        return board;
    }
    
    public int[][] countCrushHor(int[][] board){
    	int[][] count = new int[board.length][board[0].length];
    	for(int[] c: count){
    		Arrays.fill(c, 1);
    	}
    	for(int i = 0; i < board.length; i++){
    		for(int j = 0; j < board[0].length; j++){
    			if(j > 0){
    				if(board[i][j] == board[i][j - 1] && board[i][j] != 0){
    					count[i][j] = count[i][j - 1] + 1;
    				}
    			}
    		}
    	}
    	return count;
    }
    
    public int[][] countCrushVer(int[][] board){
    	int[][] count = new int[board.length][board[0].length];
    	for(int[] c: count){
    		Arrays.fill(c, 1);
    	}
    	for(int i = 0; i < board.length; i++){
    		for(int j = 0; j < board[0].length; j++){
    			if(i > 0){
    				if(board[i][j] == board[i - 1][j] && board[i][j] != 0){
    					count[i][j] = count[i - 1][j] + 1;
    				}
    			}
    		}
    	}
    	return count;
    }
    
    public boolean delete(int[][] board, int[][] hor, int[][] ver){
    	boolean isOver = true;
    	for(int i = 0; i < board.length; i++){
    		for(int j = 0; j < board[0].length; j++){
    			//if(hor[i][j] < 2 && ver[i][j] < 2)continue;
    			if(hor[i][j] >= 3 && board[i][j] != 0){
    				isOver = false;
    				for(int k = 0; k < hor[i][j] ; k++){
    					board[i][j - k] = 0;
    				}
    			}
    			//else if(hor[i][j] > 3 && board[i][j] != 0)board[i][j] = 0;
    			
    			
    			if(ver[i][j] >= 3 && board[i][j] != 0){
    				isOver = false;
    				for(int k = 0; k < ver[i][j]; k++){
    					board[i - k][j] = 0;
    				}
    			}
    			//else if(ver[i][j] > 3 && board[i][j] != 0)board[i][j] = 0;
    		}
    	}
    	return isOver;
    }
    
    public void resort(int[][] board){
    	for(int i = 0; i < board[0].length; i++){
    		int pointerLower = 0;
    		
    		for(int p1 = board.length - 1; p1 >= 0; p1--){
    			//System.out.println(p1);
    			if(board[p1][i] == 0){
    				pointerLower = p1;
    				
    				break;
    			}
    		}
    		for(int p2 = pointerLower - 1; p2 >= 0; p2--){
    			if(board[p2][i] != 0){
    				//System.out.println(board[p2][i]);
    				board[pointerLower][i] = board[p2][i];
    				board[p2][i] = 0;
    				pointerLower -= 1;
    			}
    		}
    	}
    	return;
    }

}
