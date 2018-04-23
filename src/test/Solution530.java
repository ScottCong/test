package test;

import java.util.LinkedList;
import test.TreeNode;
//Easy BST in-order traverse
public class Solution530 {
	LinkedList<Integer> lst = new LinkedList<>();
    public int getMinimumDifference(TreeNode root) {
      InOrder(root);
      int ans = Integer.MAX_VALUE;
//      if(lst.size() == 2){
//    	  return Math.abs(lst.get(0) - lst.get(1));
//      }
      for(int i = 0; i< lst.size() - 1; i++){
    	  ans = Math.min(ans, Math.abs(lst.get(i) - lst.get(i+1)));
      }
      return ans;
    }
    public void InOrder(TreeNode node){
    	if(node == null){
    		return;
    	}
//    	if(node.left == null && node.right == null){
//    		lst.add(node.val);
//    		return;
//    	}
    	InOrder(node.left);
    	lst.add(node.val);
    	InOrder(node.right);
    }
}