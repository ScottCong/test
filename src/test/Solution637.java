package test;

import java.util.*;

public class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new LinkedList<>();
        if(root == null)return ans;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(que.size() > 0){
        	Queue<TreeNode> tmp = new LinkedList<>();
        	double count = 0;
        	double sum = 0;
        	while(que.size() > 0){
        		TreeNode cur = que.poll();
        		count += 1;
        		sum += cur.val;
        		if(cur.left != null)tmp.offer(cur.left);
        		if(cur.right != null)tmp.offer(cur.right);
        	}
        	ans.add(sum / count);
        	que = tmp;
        }
        return ans;
    }
}
