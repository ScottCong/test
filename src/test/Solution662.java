package test;

import java.util.*;

public class Solution662 {
    public int widthOfBinaryTree(TreeNode root) {
    	int ans = 1;
        Queue<TreeNode> que = new LinkedList<>();
        if(root == null)return 1;
        que.offer(root);
        while(que.size() > 0){
        	Queue<TreeNode> tmp = new LinkedList<>();
        	while(que.size() > 0){
        		TreeNode cur = que.poll();
        		if(cur == null){
        			tmp.offer(null);
    				tmp.offer(null);
        		}
        		else{
        			tmp.offer(cur.left);
        			tmp.offer(cur.right);
        		}
        	}
        	int N = 0;
        	while(tmp.size() > 0){
        		TreeNode cur = tmp.poll();
        		if(cur == null && que.size() == 0)continue;
        		if(cur == null){
        			N++;
        		}
        		else{
        			for(int i =0; i < N;i++){
        				que.offer(null);
        			}
        			que.offer(cur);
        			N = 0;
        		}
        	}
        	ans = Math.max(ans, que.size());
        }
        return ans;
    }
}
