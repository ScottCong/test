package test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import test.TreeNode;
public class Solution515 {
	Map<Integer,List<Integer>> map = new HashMap<>();
    public List<Integer> largestValues(TreeNode root) {
    	traverse(root, 0);
        List<Integer> ans = new LinkedList<>();
        
        int i = 0;
        while(true){
        	if(map.getOrDefault(i, null) != null){
        		ans.add((Integer) Collections.max(map.get(i)));
        	}
        	else break;
        	i++;
        }
        return ans;
    }
    public void traverse(TreeNode node, int level){
    	List<Integer> lst = new ArrayList<>();
    
    	lst = map.getOrDefault(level, lst);
    	lst.add(node.val);
    	map.put(level, lst);
    	if(node.left != null){
    		traverse(node.left, level +1);
    	}
    	if(node.right != null){
    		traverse(node.right , level + 1);
    	}
    }
}

