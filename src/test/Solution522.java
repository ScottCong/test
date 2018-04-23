package test;

public class Solution522 {
    public int findLUSlength(String[] strs) {
    	int ans = -1;
        for(int i = 0; i < strs.length; i++){
        	for(int j = 0; j < strs.length; j++){
        		if(i == j)continue;
        		if(isSubSequence(strs[i],strs[j]))break;
        		if(j == strs.length - 1 || (i == strs.length - 1 && j == strs.length - 2)){
        			ans = Math.max(ans, strs[i].length());
        		}
        	}
        }
        return ans;
    }
    public boolean isSubSequence(String s1, String s2){
        if(s1.equals(s2))return true;
    	if(s1.length() > s2.length())return false;
    	//s1 suppose shorter than s2
    	int index = 0;
    	for(int i = 0; i < s2.length(); i++){
    		if(s1.charAt(index) == s2.charAt(i)){
    			index++;
    			if(index == s1.length())return true;
    		}
    	}
    	if(index == s1.length())return true;
    	return false;
    }
}
