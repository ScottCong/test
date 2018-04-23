package test;

public class Solution222 {
    public int countNodes(TreeNode root) {
        if(root == null)return 0;
        return count(root.left) + count(root.right) + 1;
    }
    public int count(TreeNode node){
    	if(node == null)return 0;
    	if(node.left == null && node.right == null)return 1;
    	int Left = Hight(node.left);
    	int Right = Hight(node.right);
    	if(Left == Right)return (int) ((1 << Left) + count(node.right));
    	else if(Left > Right)return (int) (count(node.left) + (1 << Right));
    	System.out.println("??");
    	return 0;
    }
    public int Hight(TreeNode node){
    	if(node == null)return 0;
    	return Hight(node.left) + 1;
    }
}
