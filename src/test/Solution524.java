package test;

import java.util.*;

public class Solution524 {
    public String findLongestWord(String s, List<String> d) {
    	String ans = "";
    	HashMap<String, Queue<Word>> map = new HashMap<>();
        for(String str: d){
        	Word word = new Word(0, str);
        	Queue<Word> lst = map.getOrDefault(String.valueOf(str.charAt(0)), new LinkedList<>());
        	lst.offer(word);
            map.put(String.valueOf(str.charAt(0)), lst);
        }
        for(int i = 0; i < s.length(); i++){
        	Queue<Word> que = map.get(String.valueOf(s.charAt(i)));
            if(que == null)continue;
            //System.out.println(que.size());
        	Queue<Word> tmp = new LinkedList<>();
        	while(que.size() > 0){
        		tmp.offer(que.poll());
        	}
        	while(tmp.size() > 0){
        		Word w = tmp.poll();
        		w.index += 1;
                // System.out.println(String.valueOf(s.charAt(i)));
                // System.out.println(w.val);
                // System.out.println(w.index);
        		if(w.index >= w.val.length()){
        			if(ans.equals("") || w.val.length() > ans.length())ans = w.val;
        			else if(w.val.length() == ans.length()){
        				if(ans.compareTo(w.val) > 0)ans = w.val;
        			}
        		}
        		else{
        			Queue<Word> q = map.getOrDefault(String.valueOf(w.val.charAt(w.index)), new LinkedList<>());
            		q.offer(w);
                    map.put(String.valueOf(w.val.charAt(w.index)), q);
        		}
        	}
        }
        return ans;
    }
}
 class Word{
	 int index;
	 String val;
	 public Word(int index, String val){
		 this.index = index;
		 this.val = val;
	 }
 }