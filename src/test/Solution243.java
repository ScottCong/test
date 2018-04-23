package test;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution243 {
    public int shortestDistance(String[] words, String word1, String word2) {
    	HashMap<String,LinkedList<Integer>> map = new HashMap<>();
        for(int i = 0; i< words.length; i++){
        	String word = words[i];
        	LinkedList<Integer> list = map.getOrDefault(word, new LinkedList<>());
        	list.add(i);
        	map.put(word, list);
        }
        LinkedList<Integer> lst1 = map.get(word1);
        LinkedList<Integer> lst2 = map.get(word2);
        return calculate(lst1, lst2);
    }
    public int calculate(LinkedList<Integer> lst1, LinkedList<Integer> lst2){
    	int index1 = 0;
    	int index2 = 0;
    	int ans = Integer.MAX_VALUE;
    	while(index1 < lst1.size() && index2 < lst2.size()){
    		int num1 = lst1.get(index1);
    		int num2 = lst2.get(index2);
    		ans = Math.min(ans, Math.abs(num1 - num2));
    		if(num1 >= num2)index2++;
    		else index1++;
    	}
    	return ans;
    }
}
