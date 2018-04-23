package test;
//find duplicate subtree

import java.util.*;
public class Solution652 {
	HashMap<String, TreeNode> map = new HashMap<>();
	LinkedList<TreeNode> ans = new LinkedList<>();
	HashSet<String> set = new HashSet<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        postOrder(root);
        return ans;
    }
    public String postOrder(TreeNode node){
    	if(node == null)return "#";
    	String cur = postOrder(node.left)  + postOrder(node.right) + String.valueOf(node.val);
        //System.out.println(cur);
    	if(set.contains(cur))return cur;
    	else if(!map.containsKey(cur)){
    		map.put(cur, node);
    		return cur;
    	}
    	else{
    		ans.add(node);
    		set.add(cur);
    		return cur;
    	}
    }
}
