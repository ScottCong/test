package test;

import java.util.HashMap;

public class Solution748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String ans = "";
        HashMap<Character, Integer> original = convertToMap(licensePlate);
        for(String word: words){
        	if(ans.equals("") || word.length() < ans.length()){
        		boolean valid = true;
        		HashMap<Character, Integer> curMap = convertToMap(word);
        		for(Character c : original.keySet()){
        			if(!curMap.containsKey(c) || curMap.get(c) < original.get(c)){
        				valid = false;
        				break;
        			}
        		}
        		if(valid)ans = word;
        	}
        }
        return ans;
    }
    
    public HashMap<Character, Integer> convertToMap(String word){
    	HashMap<Character, Integer> ans = new HashMap<>();
    	for(char c: word.toCharArray()){
    		if(c <= 'Z' && c >= 'A'){
    			c = Character.toLowerCase(c);
    			ans.put(c, ans.getOrDefault(c, 0) + 1);
    		}
    		else if(c <= 'z' && c >= 'a') ans.put(c, ans.getOrDefault(c, 0) + 1);
    	}
    	return ans;
    }
}
