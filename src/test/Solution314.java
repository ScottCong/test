package test;

import java.util.*;

public class Solution314 {
	HashMap<Integer, LinkedList<Integer>> ans = new HashMap<>();
	int smallest;
	int largest;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        this.smallest = Integer.MAX_VALUE;
        this.largest = Integer.MIN_VALUE;
        List<List<Integer>> answer = new LinkedList<>();
        if(root == null)return answer;
        Vlevel rootNode = new Vlevel(0, root);
        Queue<Vlevel> que = new LinkedList<>();
        que.offer(rootNode);
        while(que.size() > 0){
        	Queue<Vlevel> tmp = new LinkedList<>();
        	while(que.size() > 0){
        		Vlevel node = que.poll();
        		if(node.node == null)continue;
        		LinkedList<Integer> lst = this.ans.getOrDefault(node.level, new LinkedList<Integer>());
        		lst.add(node.node.val);
        		ans.put(node.level, lst);
            	this.smallest = Math.min(node.level, this.smallest);
            	this.largest = Math.max(node.level, this.largest);
        		Vlevel left = new Vlevel(node.level - 1, node.node.left);
        		Vlevel right = new Vlevel(node.level + 1, node.node.right);
        		tmp.offer(left);
        		tmp.offer(right);
        	}
        	que = tmp;
        }
        for(int i = this.smallest; i <= this.largest; i++){
        	LinkedList<Integer> lst = ans.get(i);
        	if(lst != null)answer.add(lst);
        }
        return answer;
        
    }
    
}
class Vlevel{
	int level;
	TreeNode node;
	public Vlevel(int level, TreeNode node){
		this.level = level;
		this.node = node;
	}
}
