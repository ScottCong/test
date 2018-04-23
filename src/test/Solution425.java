package test;

import java.util.*;

public class Solution425 {
    int len;
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new LinkedList<>();
        if(words.length == 0)return new LinkedList<>();
        if(words[0].length() == 1){
            for(String word: words){
                LinkedList<String> lst = new LinkedList<>();
                lst.add(word);
                ans.add(lst);  
            }
            return ans;
        }
        len = words[0].length();
        List<String> lst = new LinkedList<>();
        for(String word: words)lst.add(word);
        TrieNode root = new TrieNode("root", lst);
        InitializeTrie(lst, 0 ,root);
        Queue<List<String>> que = new LinkedList<>();
        for(String word: words){
        	List<String> tmp = new LinkedList<>();
        	tmp.add(word);
        	que = new LinkedList<>();
        	que.add(tmp);
            
        	for(int i = 0; i < word.length() - 1; i++){
                //System.out.println(que.size());
        		Queue<List<String>> tmpQue = new LinkedList<>();
        		while(que.size() > 0){
        			List<String> cur = que.poll();
        			List<String> startWith = new LinkedList<>();
        			for(int j = 0; j < cur.size(); j++){
        				startWith.add(String.valueOf(cur.get(j).charAt(i + 1)));
        			}
        			List<String> match = findPrefix(startWith, root);
        			if(match == null)continue;
        			for(String str: match){
            			List<String> newCur = new LinkedList<>();
                        for(int k = 0; k < cur.size(); k++){
                            newCur.add(cur.get(k));
                        }
            			newCur.add(str);
            			tmpQue.offer(newCur);
        			}
        		}
                for(List<String> l: tmpQue){
                    if(l.size() == len)ans.add(l);
                }
        		que = tmpQue;
        	}
        }

		return ans;
        
        
    }
    
    public void InitializeTrie(List<String> words, int index,TrieNode root){
    	if(words.size() == 0)return;
        if(index >= len)return;
    	Map<String, List<String>> map = new HashMap<>();
    	for(String word: words){
    		List<String> lst = map.getOrDefault(String.valueOf(word.charAt(index)), new LinkedList<String>());
    		lst.add(word);
    		map.put(String.valueOf(word.charAt(index)), lst);
    	}
    	for(String key: map.keySet()){
    		TrieNode node = new TrieNode(key, map.get(key));
    		InitializeTrie(map.get(key), index + 1, node);
    		root.next.put(key, node);
    	}
    	return;
    }
    
    public List<String> findPrefix(List<String> startWith, TrieNode root){
    	if(startWith == null)return null;
    	TrieNode node = null;
    	for(int i = 0; i < startWith.size(); i++){
    		node = root.next.get(startWith.get(i));
    		if(node == null)return null;
    		root = node;
    	}
    	return node.words;
    } 
}

class TrieNode{
	Map<String, TrieNode> next;
	String val;
	List<String> words;
	public TrieNode(String val, List<String>words){
		this.val = val;
		next = new HashMap<>();
		this.words = words;
	}
}
