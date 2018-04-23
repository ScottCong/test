package test;


import java.util.Stack;

import test.TreeNode;
public class Solution156 {
	Stack<TreeNode> que = new Stack<>();
public TreeNode upsideDownBinaryTree(TreeNode root) {
	if(root.left == null && root.right == null){
		return root;
	}
	Traverse(root);
	TreeNode ans = Assemble();
	return ans;
	
    }
public void Traverse(TreeNode root){
	que.push(root);
	
	if(root.left == null && root.right == null){
		return;
	}
	que.push(root.right);
	Traverse(root.left);
}
public TreeNode Assemble(){
	TreeNode newNode = new TreeNode(0);
	TreeNode newNode2 = new TreeNode(0);
	
	if(!que.isEmpty()){
		newNode.val = que.pop().val;
		System.out.println(newNode.val);
	}
	if(!que.isEmpty()){
		newNode2.val = que.pop().val;
		newNode.left = newNode2;
		newNode.right = Assemble();
		return newNode;
	}
	else{
		return newNode;
	}
}	

	
}
