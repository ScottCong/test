package test;

import java.util.LinkedList;
import java.util.List;

public class Soution797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    	List<List<Integer>> ans = new LinkedList<>();
    	LinkedList<Integer> path = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        int cur = 0;
        dfs(graph, ans, visited, cur, path);
        return ans;
    }
    
    public void dfs(int[][] graph, List<List<Integer>> ans, boolean[] visited, int cur, LinkedList<Integer> path){
    	
    	if(cur == graph.length - 1){
    		ans.add(path);
    		return;
    	}
    	if(cur == 0 && !visited[cur]){
    		for(int next: graph[cur]){
    			path = new LinkedList<>();
    			visited[cur] = true;
    			dfs(graph, ans, visited, next, path);
    			visited[cur] = false;
    		}
    	}
    	
    	else{
    		if(visited[cur])return;
    		for(int next: graph[cur]){
    			visited[cur] = true;
    			LinkedList<Integer> newPath = new LinkedList<>(path);
    			newPath.add(cur);
    			dfs(graph, ans, visited, next, newPath);
    			visited[cur] = false;
    		}
    	}
    }
}
