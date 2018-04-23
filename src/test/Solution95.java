package test;

import java.util.*;

public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        if(n ==0){
            return new LinkedList<>();
        }
        List<TreeNode> ans = genTree(1,n);
        return ans;
    }
    public List<TreeNode> genTree(int start, int end){
    	List<TreeNode> ans = new LinkedList<>();
    	if(start > end){
    		ans.add(null);
    		return ans;
    	}
    	if(start == end){
    		TreeNode n = new TreeNode(start);
    		ans.add(n);
    		return ans;
    	}
    	for(int i = start; i <= end; i++){
    		List<TreeNode> leftNodes = genTree(start, i - 1);
    		List<TreeNode> rightNodes = genTree(i + 1, end);
    		for(TreeNode leftNode: leftNodes){
    			for(TreeNode rightNode: rightNodes){
    				TreeNode n = new TreeNode(i);
    				n.left = leftNode;
    				n.right = rightNode;
    				ans.add(n);
    			}
    		}
    	}
    	return ans;
    }
}
