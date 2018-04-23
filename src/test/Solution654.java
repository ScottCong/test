package test;

import java.util.Arrays;

public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0)return null;
        int max_index = 0;
        int max_val = nums[0];
        for(int i = 1; i < nums.length; i++){
        	if(nums[i] > max_val){
        		max_val = nums[i];
        		max_index = i;
        	}
        }
        TreeNode node = new TreeNode(max_val);
        node.left = (max_index - 0) <= 0 ? null : constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, max_index));
        //System.out.println(nums.length - max_index);
        node.right = (nums.length - max_index - 1) <= 0? null : constructMaximumBinaryTree(Arrays.copyOfRange(nums, max_index + 1, nums.length));
        return node;
    }
}
