package test;

public class Solution647 {
    public int countSubstrings(String s) {
        boolean[][] table  = new boolean[s.length() + 1][s.length() + 1];
        for(int i = 0; i < s.length(); i++){
        	table[i][i] = true;
        	table[i][i + 1] = true;
        }
        int ans = s.length();
        for(int gap = 2; gap <= s.length(); gap++){
        	for(int begin = 0; begin + gap <= s.length(); begin++){
        		if(table[begin + 1][begin + gap - 1] && s.charAt(begin) == s.charAt(begin + gap - 1)){
                    //System.out.println(s.substring(begin, begin + gap));
        			table[begin][begin + gap] = true;
        			ans += 1;
        		}
        	}
        }
        return ans;
    }
}
