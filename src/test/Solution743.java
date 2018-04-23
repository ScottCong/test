package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution743 {
    public int networkDelayTime(int[][] times, int N, int K) {
        int nodes = N - 1;
        int delay = 0;
        HashMap<Integer, LinkedList<Integer[]>> edges = new HashMap<>();
        for(int[] edge: times){
        	LinkedList<Integer[]> lst =edges.getOrDefault(edge[0], new LinkedList<Integer[]>());
        	lst.add(new Integer[]{edge[1],edge[2]});
            edges.put(edge[0], lst);
        }
        HashMap<Integer, Boolean> marked = new HashMap<>();
        HashMap<Integer, Integer> lengthToGo = new HashMap<>();
        Queue<Integer> starter = new LinkedList<>();
        HashSet<Integer> nextNodes = new HashSet<>();
        starter.offer(K);
        for(int i = 1; i <= N; i++){
        	marked.put(i, false);
        	lengthToGo.put(i, Integer.MAX_VALUE);
        }
        marked.put(K, true);
        lengthToGo.put(K, 0);
        while(starter.size() > 0){
        	while(starter.size() > 0){
        		int s = starter.poll();
                //System.out.println(s);
        		LinkedList<Integer[]> edgeSet = edges.get(s);
                if(edgeSet == null)continue;
        		for(Integer[] e: edgeSet){
        			if(!marked.get(e[0])){
        				lengthToGo.put(e[0], Math.min(lengthToGo.get(e[0]), e[1]));
        				nextNodes.add(e[0]);
        			}
        		}
        	}
            if(nextNodes.size() == 0)break;
    		LinkedList<Integer> lengths = new LinkedList<>();
    		for(int i: nextNodes){
    			lengths.add(lengthToGo.get(i));
    		}
    		Collections.sort(lengths);
    		int shortest = lengths.get(0);
    		delay += shortest;
    		for(int i: nextNodes){
    			lengthToGo.put(i, lengthToGo.get(i) - shortest);
    			if(lengthToGo.get(i) == 0){
    				starter.add(i);
    				marked.put(i, true);
                    nodes--;
    			}
    		}
            for(int i: starter){
                nextNodes.remove(i);
            }
    		
        	
        }
        System.out.println(nodes);
        if(nodes != 0)return -1;
        return delay;
    }
}
