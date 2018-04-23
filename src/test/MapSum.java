package test;

import java.util.*;

class MapSum {
	TrieNode root;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode(new Character(' '));
    }
    
    public void insert(String key, int val) {
        char[] chars = key.toCharArray();
        TrieNode nextNode = root;
        HashMap<Character, TrieNode> nextMap = nextNode.nextNodes;
        for(int i = 0; i < chars.length; i++){
        	
        	if(!nextMap.containsKey(chars[i])){
        		createNewNodes(chars, i, nextNode, val);
        		return;
        	}
        	else{
        		nextNode = nextMap.get(chars[i]);
        		nextMap = nextMap.get(chars[i]).nextNodes;
        	}
        }
        nextNode.weight = val;
    }
    
    public int sum(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode nextNode = root;
        for(int i = 0; i < chars.length; i++){
        	 if(!nextNode.nextNodes.containsKey(chars[i])){
        	 	return 0;
        	 }
        	nextNode = nextNode.nextNodes.get(chars[i]);
        }
        // System.out.println(nextNode.value);
        // System.out.println(nextNode.weight);
        return BFS(nextNode);
    }
    public void createNewNodes(char[] chars, int index, TrieNode nextNode, int value){
    	HashMap<Character, TrieNode> nextMap = nextNode.nextNodes;
    	for(int i = index; i < chars.length; i++){
    		TrieNode newNode = new TrieNode(chars[i]);
    		nextMap.put(chars[i], newNode);
    		nextMap = newNode.nextNodes;
    		nextNode = newNode;
    	}
    	nextNode.weight = value;
    }
    public int BFS(TrieNode root){
    	int ans = 0;
    	ans += root.weight;
    	Queue<TrieNode> que = new LinkedList<>();
    	que.offer(root);
    	while(que.size() > 0){
    		Queue<TrieNode> tmp = new LinkedList<>();
    		while(que.size() > 0){
    			TrieNode node = que.poll();
    			for(Character c: node.nextNodes.keySet()){
    				TrieNode newNode = node.nextNodes.get(c);
    				tmp.offer(newNode);
    				ans += newNode.weight;
    			}
    		}
    		que = tmp;
    	}
    	
    	return ans;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
class TrieNode{
	Character value;
	int weight;
	HashMap<Character, TrieNode> nextNodes;
	public TrieNode(Character c){
		value = c;
		weight = 0;
		nextNodes = new HashMap<>();
	}
}