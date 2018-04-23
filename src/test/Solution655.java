package test;
import java.util.*;

public class Solution655 {
	int depth;
	HashMap<Integer, LinkedList<String>> map;
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> ans = new LinkedList<>();
        depth = 0;
        dfs(root, 1);
        compensate(root, depth);
        map = new HashMap<>();
        construct(root, depth);
        for(int i = depth; i >=1; i--){
        	ans.add(map.get(i));
        }
        return ans;
    }
    public void construct(TreeNode node, int dph){
    	if(dph < 1){
    		return;
    	}
    	else{
    		LinkedList<String> lst = map.getOrDefault(dph, new LinkedList<String>());
    		for(double i = 0; i < Math.pow(2, dph - 1) - 1; i++){
    			lst.add("");
    		}
            //System.out.println(node.val);
    		lst.add((node.val == Integer.MAX_VALUE ? "":Integer.toString(node.val)));
    		for(double i = 0; i < Math.pow(2, dph - 1) - 1; i++){
    			lst.add("");
    		}
    		map.put(dph, lst);
    	}
    	construct(node.left, dph - 1);
    	for(int i = dph - 1; i >= 1; i--){
            map.get(i).add("");
        }
    	construct(node.right, dph - 1);
    }
    public void dfs(TreeNode node, int dph){
    	if(node == null)return;
    	depth = Math.max(depth, dph);
    	dfs(node.left, dph + 1);
    	dfs(node.right, dph + 1);
    }
    public void compensate(TreeNode node, int dph){
    	if(dph < 1)return;
    	if(node.left == null){
    		node.left = new TreeNode(Integer.MAX_VALUE);
    	}
        compensate(node.left,dph - 1);
    	if(node.right == null){
    		node.right = new TreeNode(Integer.MAX_VALUE);
    	}
        compensate(node.right,dph - 1);
    	return;
    }
}
