package test;

public class Solution606 {
	StringBuilder sb;
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        if(t == null)return sb.toString();
        this.sb = sb;
        dfs(t);
        String ans = sb.toString();
        return ans;
    }
    public void dfs(TreeNode node){
    	if(node == null)return;
    	this.sb.append(Integer.toString(node.val));
    	if(node.left == null && node.right == null)return;
    	else if(node.left == null && node.right != null){
    		sb.append("()");
    		sb.append('(');
    		dfs(node.right);
    		sb.append(')');
    		return;
    	}
    	else if(node.left != null && node.right == null){
    		sb.append('(');
    		dfs(node.left);
    		sb.append(')');
    	}
    	else if(node.left != null && node.right != null){
    		sb.append('(');
    		dfs(node.left);
    		sb.append(')');
    		sb.append('(');
    		dfs(node.right);
    		sb.append(')');
    	}
    }
}
