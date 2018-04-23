package test;

public class Solution583 {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0)return word2.length();
        if(word2.length() == 0)return word1.length();
    	int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    	for(int i = 1; i <= word1.length(); i++){
    		for(int j = 1; j <= word2.length(); j++){
    			if(word1.charAt(i - 1) == word2.charAt(j - 1)){
    				dp[i][j] = dp[i - 1][j - 1] += 1;
    			}
    			else{
    				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
    			}
    		}
    	}
    	return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];  	
    }
    public boolean isSubSequence(String word1, String word2){
    	int index = 0;
    	for(int i = 0; i < word2.length(); i++){
    		if(word1.charAt(index) == word2.charAt(i)){
    			index++;
    			if(index == word1.length())return true;
    		}
    	}
    	return false;
    }
}
