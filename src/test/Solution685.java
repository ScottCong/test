package test;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
    	int[] ans = new int[]{-1,-1};
    	HashMap<Integer, Integer> degree = new HashMap<>();
    	HashMap<Integer, Integer> outer = new HashMap<>();
    	LinkedList<Integer> candidates = new LinkedList<>();
    	int ID = -1;
        for(int[] edge: edges){
        	degree.put(edge[1], degree.getOrDefault(edge[1], 0) + 1);
        	outer.put(edge[0], outer.getOrDefault(edge[0], 0) + 1);
        }
        for(int i: degree.keySet()){
        	if(degree.get(i) >= 2)ID = i;
        }
        if(ID != -1){
        	
        	for(int i = 0; i < edges.length;i++){
        		if(edges[i][1] == ID)candidates.add(i);
        	}
        	
        }
        if(candidates.size() > 0){
        	ans = new int[]{edges[candidates.get(1)][0],edges[candidates.get(1)][1]};
        	edges[candidates.get(1)] = new int[]{-1,-1};
        }
       
        	//union find
        	HashMap<Integer, Node> nodes = new HashMap<>();
        	for(int[] edge: edges){
        		if(edge[0] == -1)continue;
        		Node parent;
        		if(!nodes.containsKey(edge[0])){
        			parent = new Node(edge[0]);
        			parent.parent = new Node(-1);
        			nodes.put(edge[0], parent);
        		}
        		else parent = nodes.get(edge[0]);
        		
        		int root = root(parent);
        		
        		if(root != edge[1]){
        			if(!nodes.containsKey(edge[1])){
            			Node child = new Node(edge[1]);
            			child.parent = parent;
            			nodes.put(edge[1], child);
        			}
        			else{
        				Node child = nodes.get(edge[1]);
        				child.parent = parent;
        			}
        		}
     		
        		else{
        			//loop found
        			if(candidates.size() > 0)return edges[candidates.get(0)];
        			return edge;        			
        		}
        	}

        return ans;
    }
    private int root(Node node){
    	if(node.parent.id == -1)return node.id;
    	else{
    		return root(node.parent);
    	}
    }
    
    private class Node{
    	Node parent;
    	int id;
    	public Node(int id){
    		this.id = id;
    		
    	}
    }
    
}


