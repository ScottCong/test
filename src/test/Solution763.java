package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution763 {
    public List<Integer> partitionLabels(String S) {
    	HashMap<Character, Integer> map = new HashMap<>();
    	for(int i = 0; i < S.length(); i++){
    		Character c = S.charAt(i);
    		if(!map.containsKey(c)){
    			map.put(c, i);
    		}
    		else{
    			map.put(c, i);
    		}
    	}
    	
    	List<Integer> lst = new LinkedList<Integer>();
    	int pointer1 = 0;
    	int pointer2 = 0;
    	while(pointer1 < S.length()){
    		pointer2 = map.get(S.charAt(pointer1));
    		int tmp = pointer1;
    		for(int i = pointer1; i<= pointer2; i++){
    			pointer2 = Math.max(pointer2, map.get(S.charAt(i)));
    		}
    		pointer2++;
    		lst.add(pointer2 - tmp);
    		pointer1 = pointer2;
    	}
    	return lst;
    }
}
