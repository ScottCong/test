package test;

import java.util.*;

public class Solution742 {
    public int findClosestLeaf(TreeNode root, int k) {
    	if(root.left == null && root.right == null)return k;
    	undirectedGraphNode node = new undirectedGraphNode(null,null,null, root.val);
    	node.left = createGraph(node, root.left);
    	node.right = createGraph(node, root.right);
    	undirectedGraphNode target = dfs(node, k);
    	target.marked = true;
    	Queue<undirectedGraphNode> que = new LinkedList<>();
    	que.offer(target);
    	while(que.size() > 0){
    		Queue<undirectedGraphNode> tmp = new LinkedList<>();
    		while(que.size() > 0){
    			undirectedGraphNode n = que.poll();
    			if(n.left == null && n.right == null)return n.val;
    			if(n.parent != null && !n.parent.marked){
    				tmp.offer(n.parent);
    				n.parent.marked = true;
    			}
    			if(n.left != null && !n.left.marked){
    				tmp.offer(n.left);
    				n.left.marked = true;
    			}
    			if(n.right != null && !n.right.marked){
    				tmp.offer(n.right);
    				n.right.marked = true;
    			}
    		}
    		que = tmp;
    	}
    	return 0;
    }
    public undirectedGraphNode createGraph(undirectedGraphNode parent, TreeNode node){
    	if(node == null)return null;
    	undirectedGraphNode n = new undirectedGraphNode(parent,null,null, node.val);
    	n.parent = parent;
    	n.left = createGraph(n,node.left);
    	n.right = createGraph(n, node.right);
    	return n;
    }
    public undirectedGraphNode dfs(undirectedGraphNode node, int k){
    	if(node == null) return null;
    	if(node.val == k)return node;
    	undirectedGraphNode left = dfs(node.left, k);
    	undirectedGraphNode right = dfs(node.right, k);
    	if(left != null)return left;
    	if(right != null) return right;
    	return null;
    }
    
    

    
   private class undirectedGraphNode{
	   undirectedGraphNode parent;
	   undirectedGraphNode left;
	   undirectedGraphNode right;
	   int val;
	   boolean marked;
	   public undirectedGraphNode(undirectedGraphNode parent, undirectedGraphNode left, undirectedGraphNode right, int val){
		   this.parent = parent;
		   this.left = left;
		   this.right = right;
		   this.val = val;
		   this.marked = false;
	   }
   }

}

