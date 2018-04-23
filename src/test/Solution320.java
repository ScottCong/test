package test;

import java.util.*;

public class Solution320 {
	List<String> ans = new LinkedList<>();
    public List<String> generateAbbreviations(String word) {
        formString(word, "", 0, 0);
        return ans;
    }
    public void formString(String word, String str, int numAbr, int index){
    	if(index == word.length()){
    		if(numAbr == 0)ans.add(str);
    		else{
    			ans.add(str + String.valueOf(numAbr));
    		}
            System.out.println(str + String.valueOf(numAbr));
            return;
    	}
    		
    		formString(word, str, numAbr + 1, index+1);
    		if(numAbr > 0){
    			String newStr = str + String.valueOf(numAbr) + String.valueOf(word.charAt(index));
    			formString(word, newStr, 0, index+ 1);
    		}
    		else formString(word, str + word.substring(index, index + 1), 0, index + 1);
    	
    	
    }
}
