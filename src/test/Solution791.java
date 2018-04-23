package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

//custom sort
public class Solution791 {
//    public String customSortString(String S, String T) {
//        char[] arr = T.toCharArray();
//        Character[] chars = new Character[arr.length];
//        for(int i = 0; i < arr.length; i++){
//        	chars[i] = new Character(arr[i]);
//        }
//        HashMap<Character, Integer> map = new HashMap<>();
//        for(int i = 0; i < S.length(); i++){
//        	map.put(S.charAt(i), i);
//        }
//        
//
//        Arrays.sort(chars, new customComparator(map));
//        
//        StringBuilder sb = new StringBuilder();
//        for(char c: chars){
//        	sb.append(c);
//        }
//        return sb.toString();
//    }
	
    public String customSortString(String S, String T) {
    	HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: T.toCharArray()){
        	map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c: S.toCharArray()){
        	if(map.containsKey(c)){
        		for(int i = 0; i < map.get(c); i++)sb.append(c);
        		set.add(c);
        	}
        }
        for(char c: map.keySet()){
        	if(!set.contains(c)){
        		for(int i = 0; i < map.get(c); i++){
        			sb.append(c);
        		}
        	}
        }
        return sb.toString();
    }
}

class customComparator implements Comparator<Character>{

	HashMap<Character, Integer> map;
	
	public customComparator(HashMap<Character, Integer> map){
		this.map = map;
	}

	@Override
	public int compare(Character c1, Character c2) {
		if(!map.containsKey(c1) || !map.containsKey(c2))return 0;
    	if(map.get(c1) < map.get(c2))return -1;
    	else if(map.get(c1) > map.get(c2)) return 1;
    	return 0;
	}
	
}
