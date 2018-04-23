package test;

public class Solution671 {
	int minium = Integer.MAX_VALUE;
	int sec = Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        if(sec == Integer.MAX_VALUE)sec = -1;
        return sec;
    }
    public void dfs(TreeNode node){
    	int val;
    	if(node == null)return;
    	else if(node.left == null){
    		val = node.val;
    		
    	}
    	else{
    	dfs(node.left);
    	dfs(node.right);
    	val = Math.min(node.left.val, node.right.val);
        //System.out.println(val);
    	}
    	if(val < minium){
            sec = minium;
    		minium = val;
    	}
    	else if(val > minium && val < sec){
    		sec = val;
    	}
    }
}
