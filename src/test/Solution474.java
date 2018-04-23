package test;
//backpack
//给定一堆1 和 0，看这堆一和零可以最多组成多少给定的string
//用dp
//数组里记录当一和零小于m n 时最多能组成多少，然后一个string一个string往里面加
//从后往前更新
public class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] counts = new int[strs.length][2];
        for(int i = 0; i < strs.length; i++){
        	String str = strs[i];
        	for(char c:str.toCharArray()){
        		if(c == '0')counts[i][0]++;
        		else if(c == '1')counts[i][1]++;
        	}
        }
        int[][] backPack = new int[m + 1][n + 1];
        for(int i = 0; i < counts.length; i++){
        	int zeros = counts[i][0];
        	int ones = counts[i][1];
        	for(int j = m; j >= zeros; j--){
        		for(int k = n; k >= ones; k--){
        			backPack[j][k] = Math.max(backPack[j][k], backPack[j - zeros][k - ones] + 1);
        			
        		}
        	}
        }
        return backPack[m][n];
    }
}
