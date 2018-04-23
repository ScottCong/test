package test;

import java.util.HashMap;

class MagicDictionary {
	TrieNode root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode(' ');
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String s: dict){
        	addWord(s);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        return search(chars, 0, false, root);
    }
    public boolean search(char[] chars,int index, boolean isModified, TrieNode node){
    	if(index >= chars.length){
    		if(isModified && node.isEnd)return true;
    		return false;
    	}
    	HashMap<Character, TrieNode> map = node.nextNodes;
    	if(isModified && !map.containsKey(chars[index]))return false;
    	boolean result = false;
    	for(Character c: map.keySet()){
    		if(c != chars[index] && !isModified)result = result || search(chars, index + 1, !isModified, map.get(c));
    		else if(c == chars[index])result = result || search(chars, index + 1, isModified, map.get(c));
    		
    	}
    	return result;
    }
    public void addWord(String word){
        //System.out.println("add word");
    	char[] chars = word.toCharArray();
    	searchNode(chars, 0, root);
    }
    public void searchNode(char[] chars, int index, TrieNode node){
        //System.out.println("search Node");
    	if(index >= chars.length){
    		node.isEnd = true;
    		return;
    	}
    	HashMap<Character, TrieNode> map = node.nextNodes;
    	if(map.containsKey(chars[index])){
    		searchNode(chars, index + 1, map.get(chars[index]));
    	}
    	else{
    		addNode(chars, index, node);
    	}
    }
    public void addNode(char[] chars, int index, TrieNode node){
        //System.out.println(node.value);
        
    	if(index >= chars.length){
    		node.isEnd = true;
    		return;
    	}
    	HashMap<Character, TrieNode> map = node.nextNodes;
    	TrieNode newNode = new TrieNode(chars[index]);
    	map.put(chars[index], newNode);
    	addNode(chars, index + 1, map.get(chars[index]));
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
class TrieNode{
	boolean isEnd;
	HashMap<Character, TrieNode> nextNodes;
	Character value;
	public TrieNode(char c){
		value = c;
		nextNodes = new HashMap<>();
		isEnd = false;
	}
}
