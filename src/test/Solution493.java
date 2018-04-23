package test;

import java.util.*;

public class Solution493 {
    public int reversePairs(int[] nums) {
        if(nums.length <= 1)return 0;
        int ans = 0;
        PairTreeNode root = null;
        Map<Integer, PairTreeNode> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
        	int target = nums[i] * 2 + 1;
            ans += find(root, 0, target);
        	if(root == null){
        		root = new PairTreeNode(nums[i]);
        		map.put(nums[i], root);
        	}
        	else{
        		if(map.keySet().contains(nums[i])){
        			map.get(nums[i]).count += 1;
        		}
        		else{
        			PairTreeNode newNode = addNode(root, nums[i]);
        			map.put(nums[i], newNode);
        		}
        	}
            //System.out.print(root.count);
        }
        return ans;
    }
    public int find(PairTreeNode node, int count, int target){
    	if(node == null)return count;
    	if(node.val >= target){
    		count += node.count;
    		count = find(node.right, count, target);
    		count = find(node.left, count, target);
    		return count;
    	}
    	else{
    		count = find(node.right, count, target);
    		return count;
    	}
    }
    public PairTreeNode addNode(PairTreeNode node, int target){
    	if(target > node.val){
    		if(node.right == null){
    			PairTreeNode newNode = new PairTreeNode(target);
    			node.right = newNode;
    			return newNode;
    		}
    		else return addNode(node.right, target);
    	}
    	else{
    		if(node.left == null){
    			PairTreeNode newNode = new PairTreeNode(target);
    			node.left = newNode;
    			return newNode;
    		}
    		else return addNode(node.left, target);
    	}
    }
}
class PairTreeNode{
	int count;
	PairTreeNode left;
	PairTreeNode right;
	int val;
	public PairTreeNode(int val){
		this.val = val;
		left = null;
		right = null;
		count = 1;
	}
}
