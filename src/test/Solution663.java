package test;

public class Solution663 {
    public boolean checkEqualTree(TreeNode root) {
        TreeNodeSum newRoot = new TreeNodeSum(root.val);
        construct(root, newRoot);
        calSum(newRoot);
        return detect(newRoot, newRoot.sum);
    }
    public boolean detect(TreeNodeSum node, int total){
    	if(node == null)return false;
    	if(node.left == null && node.right == null)return false;
    	if(node.left != null){
    		if(total - node.left.sum == node.left.sum)return true;
    		boolean isInLeft = detect(node.left, total);
    		if(isInLeft)return true;
    	}
    	if(node.right != null){
    		if(total - node.right.sum == node.right.sum)return true;
    		boolean isInRight = detect(node.right, total);
    		if(isInRight)return true;
    	}
    	return false;
    }
    public int calSum(TreeNodeSum node){
    	if(node == null)return 0;
    	if(node.left == null && node.right == null){
    		node.sum = node.val;
    		return node.sum;
    	}
    	else{
    		node.sum = node.val + calSum(node.left) + calSum(node.right);
    		return node.sum;
    	}
    	
    }
    public void construct(TreeNode node1, TreeNodeSum node2){
    	if(node1.left != null){
    		node2.left = new TreeNodeSum(node1.left.val);
    		construct(node1.left, node2.left);
    	}
    	if(node1.right != null){
    		node2.right = new TreeNodeSum(node1.right.val);
    		construct(node1.right, node2.right);
    	}
    }
}

class TreeNodeSum extends TreeNode{
	int sum;
	TreeNodeSum left;
	TreeNodeSum right;
	public TreeNodeSum(int val){
		super(val);
		sum = 0;
	}
}
