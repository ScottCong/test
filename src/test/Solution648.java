package test;

import java.util.*;

public class Solution648 {
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode(' ');
        for(String s: dict){
        	searchTrieNode(s, 0, root);
        }
        StringBuilder sb = new StringBuilder();
        String[] strs = sentence.split(" ");
        for(String s: strs){
        	sb.append(replaceWord(s, 0, root) + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
        
    }
    public void searchTrieNode(String s, int index, TrieNode parent){
    	if(index >= s.length()){
    		parent.isEnd = true;
    		parent.root = s;
    		System.out.println(s);
    		return;
    	}
    	HashMap<Character, TrieNode> map = parent.nextNodes;
    	if(map.containsKey(s.charAt(index))){
    		searchTrieNode(s, index + 1, map.get(s.charAt(index)));
    	}
    	else{
    		buildTrieNode(s, index, parent);
    	}
    	
    }
    public void buildTrieNode(String s, int index, TrieNode parent){
    	if(index >= s.length()){
    		parent.isEnd = true;
    		parent.root = s;
    		System.out.println(s);
    		return;
    	}
    	TrieNode newNode =new TrieNode(s.charAt(index));
    	parent.nextNodes.put(s.charAt(index), newNode);
    	buildTrieNode(s, index + 1, newNode);
    }
    
    public String replaceWord(String s, int index,TrieNode node){
    	if(index >= s.length())return s;
    	if(!node.nextNodes.containsKey(s.charAt(index))){
    		return s;
    	}
    	else{
    		TrieNode nextNode = node.nextNodes.get(s.charAt(index));
    		if(nextNode.isEnd)return nextNode.root;
    		else{
    			return replaceWord(s, index + 1, nextNode);
    		}
    	}
    }
    
    private class TrieNode{
    	String root;
    	HashMap<Character,TrieNode> nextNodes;
    	char val;
    	boolean isEnd;
    	public TrieNode(char c){
    		this.root = null;
    		val = c;
    		nextNodes = new HashMap<>();
    		isEnd = false;
    	}
    }
    
}
