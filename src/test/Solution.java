package test;

public class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] Table = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
        	Table[i][i] = 1;
        }
        for(int j = 0; j < s.length() - 1; j++){
        	if(s.charAt(j) == s.charAt(j + 1)){
        		Table[j][j + 1] = 2;
        	}
        	else{
        		Table[j][j + 1] = 1;
        	}
        }
        for(int len = 2; len < s.length(); len++){
        	for(int init = 0; (init + len) < s.length(); init ++){
        		if(s.charAt(init) == s.charAt(init + len)){
        			Table[init][init + len] = Table[init + 1][ init + len - 1] + 2;
        			
        		}
        		else{
        			Table[init][init + len] = Math.max(Table[init + 1][init + len], Table[init][init + len - 1]);
        			
        		}
        	}
        }
        return Table[0][s.length() - 1];
    }
}
