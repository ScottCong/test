package test;

import java.util.*;

public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
    	LinkedList<Integer> ans = new LinkedList<>();
        Queue<TreeNode> que1 = new LinkedList<>();
        if(root == null)return ans;
        que1.offer(root);
        ans.add(root.val);
        while(que1.size() > 0){
        	Queue<TreeNode> que2 = new LinkedList<>();
        	while(que1.size() > 0){
        		TreeNode cur = que1.poll();
        		if(cur.right != null)que2.offer(cur.right);
        		if(cur.left != null)que2.offer(cur.left);
        	}
        	if(que2.size() > 0)ans.add(que2.peek().val);
        	que1 = que2;
        }
        return ans;
    }
}
