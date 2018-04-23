package test;
//delete node in BST

//这里自己真是巨傻逼
//注意两点
//1.涉及到treenode的问题，如果要改变点，一定要用parent.left and parent.right，
//用reference是无法改变parent的属性的
//2.BST里面，第一个比一个点大的数是node.right.left.left.left......把那个数替换到这个点上对BST没有影响
//别想着窜来窜去的，是错的
public class Solution450 {
	public TreeNode deleteNode(TreeNode root, int key) {
	    if(root == null){
	        return null;
	    }
	    if(key < root.val){
	        root.left = deleteNode(root.left, key);
	    }else if(key > root.val){
	        root.right = deleteNode(root.right, key);
	    }else{
	        if(root.left == null){
	            return root.right;
	        }else if(root.right == null){
	            return root.left;
	        }
	        
	        TreeNode minNode = findMin(root.right);
	        root.val = minNode.val;
	        root.right = deleteNode(root.right, root.val);
	    }
	    return root;
	}

	private TreeNode findMin(TreeNode node){
	    while(node.left != null){
	        node = node.left;
	    }
	    return node;
	}
}
