package test;
//hard
//
//Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
//For example,
//Given:
//s1 = "aabcc",
//s2 = "dbbca",
//
//When s3 = "aadbbcbcac", return true.
//When s3 = "aadbbbaccc", return false.

//做一个 2 维矩阵，矩阵横纵坐标代表s1 s2的位置，每一次看矩阵下一个位置，看s1[i - 1] 或者 s2[j - 1]
//和 s3[i + j - 1]是否匹配
//匹配代表s3这个位置可以在s1 的 i 和 s2的 j 位置匹配
public class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for(int i = 0; i <= s1.length(); i++){
        	for(int j = 0; j <= s2.length(); j++){
        		if(i == 0 && j == 0)continue;
        		if(i == 0)dp[i][j] = (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j-1));
        		else if(j == 0)dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1));
        		else dp[i][j] = (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j-1)) || (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1));
        		
        	}
        }
        return dp[s1.length()][s2.length()];
    }
}
