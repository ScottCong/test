package test;

	public class Solution392 {
	    public boolean isSubsequence(String s, String t) {
	        //t is the set and s is the substring target
	        if(s.length() == 0)return true;
	    	int sIndex = 0, tIndex = 0;
	    	for(int i = 0; i < t.length(); i++){
	    		if(s.charAt(sIndex) == t.charAt(tIndex)){
	    			sIndex++;
	    			tIndex++;
	    		}
	    		else{
	    			tIndex++;
	    		}
	    		if(sIndex == s.length()){
	    			return true;
	    		}
	    	}
	    	return false;
	    }
	}

//s = "abc", t = "ahbgdceh"