package test;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution244 {
	HashMap<String,LinkedList<Integer>> map = new HashMap<>();
	String[] strings;
    public Solution244(String[] words) {
        strings = words;
        for(int i = 0; i< this.strings.length; i++){
        	if(map.get(strings[i]) == null){
        		map.put(strings[i],new LinkedList<Integer>());
        	}
        	map.get(strings[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        LinkedList<Integer> list1 = map.get(word1);
        LinkedList<Integer> list2 = map.get(word2);
        if(list1 == null || list2 == null){
        	System.out.println("??");
        	return 0;
        }
        
        int shortest = Integer.MAX_VALUE;
        int index1 = 0, index2 = 0;
        while(index1 < list1.size() && index2 < list2.size()){
        	shortest = Math.min(shortest, Math.abs(list1.get(index1) - list2.get(index2)));
        	if(list1.get(index1) >= list2.get(index2)){
        		index2++;
        	}
        	else index1++;
        }
        return shortest;
    }
}
