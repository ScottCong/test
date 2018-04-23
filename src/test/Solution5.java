package test;

public class Solution5 {
    public String longestPalindrome(String s) {
    	int ans = 1;
    	int[] ansIndex = new int[2];
        int len = s.length();
        boolean[][] isPalindrome = new boolean[len + 1][len + 1];
        int[][] lenPalidrome = new int[len + 1][len + 1];
        for(int i = 0; i < len; i++){
        	lenPalidrome[i][i + 1] = 1;
        	isPalindrome[i][i + 1] = true;
        }
        for(int length = 2; length <= len; length++){
        	for(int index = 0; index + length <= len; index++){
        		if(s.charAt(index) == s.charAt(index + length) && isPalindrome[index + 1][index + length - 1]){
        			isPalindrome[index][index + length] = true;
        			lenPalidrome[index][index + length] = lenPalidrome[index + 1][index + length - 1] + 2;
        			if(lenPalidrome[index][index + length] > ans){
        				ans = lenPalidrome[index][index + length];
        				ansIndex[0] = index;
        				ansIndex[1] = index + length;
        			}
        		}
        	}
        }
        return s.substring(ansIndex[0], ansIndex[1]);
    }
}
