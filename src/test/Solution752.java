package test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//solve lock
//bfs
//imagine lock combinations as treenodes, each treenode with only one digit difference is connected
//the deadnode is counted as visited
public class Solution752 {
    public int openLock(String[] deadends, String target) {
    	
        HashSet<String> visited = new HashSet<>();
        for(String s: deadends){
        	visited.add(s);
        }
        
        if(visited.contains("0000"))return -1;
        Queue<String> que = new LinkedList<>();
        que.offer("0000");
        
        int ans = 0;
        while(!que.isEmpty()){
        	Queue<String> tmp = new LinkedList<>();
        	ans++;
        	while(!que.isEmpty()){
        		String s = que.poll();
        		List<String> neighbors = neighbors(s);
        		for(String neighbor: neighbors){
        			if(neighbor.equals(target))return ans;
        			if(visited.contains(neighbor))continue;
                    //System.out.println(neighbor);
        			tmp.add(neighbor);
        			visited.add(neighbor);
        		}
        	}
            que = tmp;
        }
        
        return -1;
    }
    
    public List<String> neighbors(String s){
    	LinkedList<String> neighbor = new LinkedList<>();
    	for(int i = 0; i < s.length(); i++){
    		char c = s.charAt(i);
    		neighbor.add(s.subSequence(0, i) + add(c) + s.substring(i + 1, s.length()));
    		neighbor.add(s.subSequence(0, i) + minus(c) + s.substring(i + 1, s.length()));
    	}
    	return neighbor;
    }
    
    public String add(char c){
    	if(c == '9')return "0";
    	return Integer.toString(c - '0' + 1);
    }
    
    public String minus(char c){
    	if(c == '0')return "9";
    	return Integer.toString(c - '0' - 1);
    }
}
