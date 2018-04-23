package test;

public class Solution236 {
	TreeNode nodeP, nodeQ, ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        nodeP = null;
        nodeQ = null;
        ans = null;
        dfs(root, p , q);
        if(ans == null){
            ans = (nodeP == null)?nodeQ: nodeP;
            return ans;
        }
        return ans;
    }
    public boolean dfs(TreeNode node, TreeNode p, TreeNode q){
    	if(node == null)return false;
    	if(node == p){
    		nodeP = node;
    		return true;
    	}
    	else if(node == q){
    		nodeQ = node;
    		return true;
    	}
    	boolean left = dfs(node.left, p , q);
    	boolean right = dfs(node.right, p, q);
    	if(left && right && (ans == null)){
    		ans = node;
    		return true;
    	}
    	else if(left || right)return true;
    	return false;
    }
}
