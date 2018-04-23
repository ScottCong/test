package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import test.TreeNode;
public class Solution508 {
	Map<Integer,Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
    	int Max = Integer.MIN_VALUE;
        PostTreverse(root);
        for(int key :map.keySet()){
        	if(Max < map.get(key)){
        		Max = map.get(key);
        	}
        }
        List<Integer> lst = new LinkedList<>();
        for(int key : map.keySet()){
        	if(map.get(key) == Max){
        		lst.add(key);
        	}
        }
        int[] ans =  new int[lst.size()];
        for(int i = 0; i < lst.size(); i++){
        	ans[i] = lst.get(i);
        }
        return ans;
    }
    public int PostTreverse(TreeNode node){
    	if(node != null){
    		int left = PostTreverse(node.left);
    		int right = PostTreverse(node.right);
    		int cur = node.val + left + right;
    		int IntToPut = map.getOrDefault(cur, 0);
    		map.put(cur, IntToPut+1);
    		return cur;
    	}
    	return 0;
    }
}