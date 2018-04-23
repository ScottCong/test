package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

//backtracking tle
public class Solution767 {
	String ans = "";
    public String reorganizeString(String S) {
    	int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(Character c: S.toCharArray()){
        	map.put(c, map.getOrDefault(c, 0) + 1);
        	maxLen = Math.max(maxLen, map.get(c));
        }
        
        if(maxLen > (S.length() - maxLen) + 1)return "";
        
        Character starter = ' ';
        for(Character key: map.keySet()){
        	if(map.get(key) == maxLen){
        		starter = key;
        		break;
        	}
        }
        
        Queue<Character> ans = new LinkedList<>();
        Queue<Character> tmp = new LinkedList<>();
        for(int i = 0; i < maxLen; i++){
        	ans.offer(starter);
        }
        
        for(Character c: map.keySet()){
        	if(c.equals(starter))continue;
        	for(int i = 0; i < map.get(c); i++){
        		tmp.offer(ans.poll());
        		tmp.offer(c);
        		if(ans.size() == 0){
        			ans = tmp;
        			tmp = new LinkedList<>();
        		}
        	}
        }
        StringBuilder sb = new StringBuilder();
        while(ans.size() > 0){
        	tmp.offer(ans.poll());
        }
        while(tmp.size() > 0){
        	sb.append(tmp.poll());
        }
        return sb.toString();
        
//        int len = S.length();
//        Stack<Character> stk = new Stack<>();
//        String ans = backTracking(len,stk,map);
    }
    
    public String backTracking(int len, Stack<Character> stk, Map<Character, Integer> map){
    	if(ans.length() > 0)return ans;
    	if(len == 0){
    		this.ans = transferToString(stk);
    		return ans;
    	}
    	Character notSame = stk.isEmpty()? ' ': stk.peek();
    	for(Character c: map.keySet()){
    		if(!c.equals(notSame) && map.get(c) > 0){
    			map.put(c, map.get(c) - 1);
    			stk.push(c);
    			String tmp = backTracking(len - 1, stk, map);
    			if(tmp.length() > 0)return tmp;
    			System.out.println(tmp);
    			stk.pop();
    			map.put(c, map.get(c) + 1);
    		}
    	}
    	return this.ans;
    }
    
    public String transferToString(Stack<Character> stk){
    	StringBuilder sb = new StringBuilder();
    	while(!stk.isEmpty()){
    		sb.append(stk.pop());
    	}
    	sb.reverse();
    	return sb.toString();
    	
    }
}
