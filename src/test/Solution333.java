package test;

public class Solution333 {
    public int largestBSTSubtree(TreeNode root) {
        BST RootBST = DFS(root);
        return RootBST.LargestSize;
    }
    public BST DFS(TreeNode node){
        if(node == null)return new BST(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    	if(node.left == null && node.right == null){
    		return new BST(true,1, node.val,node.val);
    	}
    	BST leftBST = DFS(node.left);
    	BST rightBST = DFS(node.right);
    	if(leftBST.isBST && rightBST.isBST){
    		int leftVal = (leftBST.LargestSize == 0)? Integer.MIN_VALUE:leftBST.largest;
    		int rightVal = (rightBST.LargestSize == 0)? Integer.MAX_VALUE: rightBST.smallest;
    		
    		if(node.val > leftVal && node.val < rightVal){
    			int smallest = (leftBST.LargestSize == 0)?node.val: leftBST.smallest;
    			int largest = (rightBST.LargestSize == 0)?node.val: rightBST.largest;
    			return new BST(true, leftBST.LargestSize + rightBST.LargestSize + 1, smallest, largest);
    		}		
    	}
    	return new BST(false, Math.max(leftBST.LargestSize, rightBST.LargestSize), node.val, node.val);
    }
}
class BST{
	boolean isBST;
	int LargestSize;
	int smallest;
	int largest;
	public BST(boolean isBST, int size, int smallest, int largest){
		this.smallest = smallest;
		this.largest = largest;
		this.isBST = isBST;
		this.LargestSize = size;
	}
}
