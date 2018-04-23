package test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution513 {
public int findBottomLeftValue(TreeNode root) {
	   if(root.left == null && root.right == null){
		   return root.val;
	   }
       int ans = 0;
       Queue<TreeNode> que = new LinkedList<TreeNode>();
       que.offer(root);
//       Integer no = null;
//       TreeNode none = new TreeNode(no);
//       que.offer(none);
       while(!que.isEmpty()){
    	   Queue<TreeNode> next = new LinkedList<>();
    	   Queue<Integer> level = new LinkedList<>();
    	   for(int i = 0; i < que.size();i ++){
    		   if(i == 0){ans = que.peek().val;}
    		   TreeNode node = que.poll();
    		   if(node.left != null)
    		   {
    			   next.offer(node.left);
    			   level.offer(node.left.val);
    		   }
    		   if(node.right != null)
    		   {
    			   next.offer(node.right);
    			   level.offer(node.right.val);
    			   }
    	   }
    	   que = next;
       }
       
       return ans;
    }
}
