package test;

import java.util.*;

public class Solution272 {
	Stack<Integer> inorder = new Stack<>();
	Stack<Integer> reverse = new Stack<>();
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
    	List<Integer> ans = new LinkedList<>();
        inorderPush(root, target);
        ReversePush(root, target);
        while(k > 0){
        	if(inorder.size() == 0){
        		ans.add(reverse.pop());
        		k--;
        	}
        	else if(reverse.size() == 0){
        		ans.add(inorder.pop());
        		k--;
        	}
        	else{
        		if((target - inorder.peek()) > (reverse.peek() - target)){
        			ans.add(reverse.pop());
        			k--;
        		}
        		else{
        			ans.add(inorder.pop());
        			k--;
        		}
        	}
        }
        return ans;
    }
    public void inorderPush(TreeNode node, double target){
    	if(node == null)return;
    	inorderPush(node.left, target);
    	if(node.val >= target)return;
    	inorder.push(node.val);
    	inorderPush(node.right, target);
    }
    public void ReversePush(TreeNode node, double target){
    	if(node == null)return;
    	ReversePush(node.right, target);
    	if(node.val < target)return;
    	reverse.push(node.val);
    	ReversePush(node.left, target);
    }
}
