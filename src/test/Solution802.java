package test;

import java.util.*;

public class Solution802 {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        
    	ArrayList<Integer> ans = new ArrayList<>();
    	Queue<Integer> que = new LinkedList<>();
    	ArrayList<Set<Integer>> outDegree = new ArrayList<>();
    	ArrayList<Set<Integer>> inDegree = new ArrayList<>();
    	for(int i = 0; i < graph.length; i++){
    		if(graph[i].length == 0){
    			que.add(i);
    		}
    		outDegree.add(new HashSet<Integer>());
    		inDegree.add(new HashSet<Integer>());
    	}
    	
    	for(int i = 0; i < graph.length; i++){
    		for(int j: graph[i]){
    			outDegree.get(i).add(j);
    			inDegree.get(j).add(i);
    		}
    	}
    	
    	while(que.size() > 0){
    		int next = que.poll();
    		ans.add(next);
    		for(int i: inDegree.get(next)){
    			outDegree.get(i).remove(next);
    			if(outDegree.get(i).size() == 0)que.offer(i);
    		}
    	}
    	
    	Collections.sort(ans);
    	return ans;
    }
}
