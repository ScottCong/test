package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution720 {
	String ans = "";
    public String longestWord(String[] words) {

        HashSet<String> starters = new HashSet<>();
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        for(String s: words){
        	if(s.length() == 1)starters.add(s);
        	else{
        		LinkedList<String> lst = map.getOrDefault(s.substring(0, s.length() - 1), new LinkedList<>());
        		lst.add(s);
        		map.put(s.substring(0, s.length() - 1), lst);
        	}
        }
        for(String s: starters){
        	findMax(map, s);
        }
        return this.ans;
        
    }
    
    public void findMax(HashMap<String, LinkedList<String>> map, String cur){
    	if(map.getOrDefault(cur, null) == null){
    		if(cur.length() > ans.length())ans = cur;
    		else if(cur.length() == ans.length())this.ans = (cur.compareTo(this.ans) < 0)? cur: this.ans;
    		return;
    	}
    	
    	else{
    		for(String s: map.get(cur)){
    			findMax(map, s);
    		}
    	}
    }
}
