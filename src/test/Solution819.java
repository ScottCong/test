package test;

import java.util.*;

public class Solution819 {
    public String mostCommonWord(String paragraph, String[] banned) {
     HashSet<String> set = new HashSet<>();
     HashSet<Character> signs = new HashSet<>();
     signs.add(',');signs.add('.');signs.add(';');signs.add('?');signs.add('!');signs.add('\'');
     for(String s: banned)set.add(s);
     String[] words = paragraph.split(" ");
     
     int largest = 0;
     String ans = "";
     Map<String, Integer> showNumber = new HashMap<>();
     for(String word: words){
    	 if(signs.contains(word.charAt(word.length() - 1)))word = word.substring(0, word.length() - 1);
    	 word = word.toLowerCase();
    	 if(set.contains(word))continue;
    	 showNumber.put(word, showNumber.getOrDefault(word, 0) + 1);
    	 if(showNumber.get(word) > largest){
    		 largest = showNumber.get(word);
    		 ans = word;
    	 }
     }
     return ans;
    }
}
