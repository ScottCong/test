package test;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution124 {
	int max_val = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
       int ans = 0;
       ans = FindLargest(root);
       return max_val;
    }
	public int FindLargest(TreeNode node){
		if(node == null){
			return 0;
		}
		max_val = Math.max(max_val, node.val);
		if(node.left == null && node.right == null){
		    max_val = Math.max(max_val, node.val);
			return node.val;
		}
		int left = Math.max(FindLargest(node.left),0);
		int right = Math.max(FindLargest(node.right),0);
		max_val = Math.max(max_val, left + right + node.val);
		return Math.max(left  + node.val, right + node.val);
	}
}
