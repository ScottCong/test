package test;

import java.util.Arrays;

//inorder + postorder = tree
//重点：postorder 最后一个数肯定是根节点
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0)return null;
        if(inorder.length == 1)return new TreeNode(inorder[0]);
        int len = inorder.length;
        int index = 0;
        for(int i = 0;i < len; i++){
        	if(inorder[i] == postorder[len - 1]){
        		index = i;
        		break;
        	}
        }
        TreeNode root = new TreeNode(postorder[len - 1]);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, len);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, index);
        int[] rightPostorder = Arrays.copyOfRange(postorder, index, len - 1);
        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);
        return root;
    } 
}
