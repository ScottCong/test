package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution684 {
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        HashMap<Integer, LinkedList<Integer>> edgeMap = new HashMap<>();
        int[] ans = new int[2];
        for(int[] edge: edges){
            for(int i: edge){
                map.put(i, false);
            }
        	LinkedList<Integer> nodes = edgeMap.getOrDefault(edge[0], new LinkedList<Integer>());
        	nodes.add(edge[1]);
        	edgeMap.put(edge[0], nodes);
        	nodes = edgeMap.getOrDefault(edge[1], new LinkedList<Integer>());
        	nodes.add(edge[0]);
        	edgeMap.put(edge[1], nodes);
        }
        // for(int i: edgeMap.keySet()){
        //     System.out.println(edgeMap.get(i));
        // }
        for(int[] edge: edges){
        	if(isRedundant(map, edgeMap, edge[0], edge[1])){
                // System.out.println(edge[0]);
                // System.out.println(edge[1]);
                ans = edge;
            }
            for(int i : map.keySet()){
    		map.put(i, false);
    	}
                    //System.out.println("  ");
        }
        return ans;
    }
    public boolean isRedundant(HashMap<Integer, Boolean> map,HashMap<Integer, LinkedList<Integer>> edgeMap, int first, int second){
    	Queue<Integer> que = new LinkedList<>();
        map.put(first, true);
        //map.put(second,true);
    	for(int i: edgeMap.get(first)){
    		if(i == second)continue;
    		else{
    			que.offer(i);
    		}
    	}
        //System.out.println(second);
    	while(que.size() > 0){
            //System.out.println(que);
    		Queue<Integer> tmp = new LinkedList<>();
    		while(que.size() > 0){
    			int nextNode = que.poll();
                //System.out.println(nextNode);
    			if(nextNode == second){
                    //System.out.println("true");
                    return true;
                }
    			if(map.get(nextNode))continue;
    			else{
                    LinkedList<Integer> nextNodes = edgeMap.get(nextNode);
    				for(int i: nextNodes)if(!map.get(i))tmp.offer(i);
    				map.put(nextNode, true);
    			}
    		}
    		que = tmp;
            
    	}

    	return false;
    }
}
