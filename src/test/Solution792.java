package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//process all the word in words in batch
//iterate char in S, process every word currently point to that char and go to next queue
//somehow greedy
public class Solution792 {
    public int numMatchingSubseq(String S, String[] words) {
    	int ans = 0;
        Map<Character, Queue<wordWithPointer>> charMap = new HashMap<>();
        for(String word: words){
        	wordWithPointer wd = new wordWithPointer(word);
        	if(!charMap.containsKey(word.charAt(0))){
        		charMap.put(word.charAt(0), new LinkedList<wordWithPointer>());
        	}
        	charMap.get(word.charAt(0)).offer(wd);
        }
        
        for(char chr: S.toCharArray()){
        	if(!charMap.containsKey(chr))continue;
        	Queue<wordWithPointer> que = charMap.get(chr);
        	Queue<wordWithPointer> tmp = new LinkedList<>();
        	while(!que.isEmpty()){
        		wordWithPointer wd = que.poll();
        		wd.pointer++;
        		if(wd.isFinished())ans++;
        		else if(wd.currentChar() == chr){
        			tmp.offer(wd);
        		}
        		else{
        			if(!charMap.containsKey(wd.currentChar()))charMap.put(wd.currentChar(), new LinkedList<wordWithPointer>());
        			Queue<wordWithPointer> target = charMap.get(wd.currentChar());
        			target.offer(wd);
        		}
        	}
        	charMap.put(chr, tmp);
        }
        return ans;
    }
    
    
    private class wordWithPointer{
    	String str;
    	int pointer;
    	public wordWithPointer(String str){
    		this.str = str;
    		pointer = 0;
    	}
    	
    	public boolean isFinished(){
    		return pointer == str.length();
    	}
    	
    	public char currentChar(){
    		if(this.isFinished())return ' ';
    		return str.charAt(pointer);
    	}
    }
}
