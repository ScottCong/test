package test;

public class Solution669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        TreeNode ans;
        ans = treeNodeFilter(root, L, R);
        return ans;
    }
    
    public TreeNode treeNodeFilter(TreeNode node, int L, int R){
    	if(node == null)return null;
    	if(node.val >= L && node.val <= R){
    		node.left = treeNodeFilter(node.left, L, R);
    		node.right = treeNodeFilter(node.right, L, R);
    		return node;
    	}
    	else if(node.val < L){
    		return treeNodeFilter(node.right, L ,R);
    	}
    	else{
    		return treeNodeFilter(node.left, L, R);
    	}
    }
}
