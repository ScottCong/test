package test;
//merge two BST(add together)
public class Solution617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)return null;
        TreeNode dummy = new TreeNode(0);
        merge(dummy,t1,t2);
        return dummy;
    }
    public void merge(TreeNode parent,TreeNode node1,TreeNode node2){
    	if(node1 == null && node2 == null)return;
    	if(node1 == null)node1 = new TreeNode(0);
    	if(node2 == null)node2 = new TreeNode(0);
    	parent.val = node1.val + node2.val;
    	//System.out.println(parent.val);
    	if(node1.left != null || node2.left != null){
    	    parent.left = new TreeNode(0);
    	    merge(parent.left, node1.left, node2.left);
    	}
    	if(node1.right != null || node2.right != null){
    	    parent.right = new TreeNode(0);
    	    merge(parent.right, node1.right, node2.right);
    	}
    }
}
