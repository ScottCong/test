package test;

import java.util.*;

public class Solution623 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
    	if(d == 1){
    		TreeNode newNode = new TreeNode(v);
    		newNode.left = root;
    		return newNode;
    	}
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        for(int i = 1; i < d - 1; i++){
        	Queue<TreeNode> tmp = new LinkedList<>();
        	while(que.size() > 0){
        		TreeNode t = que.poll();
        		if(t.left != null)tmp.offer(t.left);
        		if(t.right != null)tmp.offer(t.right);
        	}
        	que = tmp;
        }
        while(que.size() > 0){
        	TreeNode t = que.poll();
        	TreeNode left = t.left;
        	t.left = new TreeNode(v);
        	t.left.left = left;
        	TreeNode right = t.right;
        	t.right = new TreeNode(v);
        	t.right.right = right;
        }
        return root;
    }
}
