package test;

import java.util.Stack;

public class Solution536 {
    public TreeNode str2tree(String s) {
       TreeNode node = null;
       if(s.length() == 0)return node;
       int neg = 1;
       Stack<TreeNode> stk = new Stack<>();
       TreeNode dummy = new TreeNode(0);
       stk.push(dummy);
       int val = 0;
       for(int i = 0; i < s.length(); i++){
    	   char c = s.charAt(i);
    	   if(c != '(' && c != ')'){
    		   if(c == '-'){
    			   neg = -1 ;
    			   continue;
    		   }
    		   val = val * 10 + neg * (int)(c - '0');

    	   }
    	   else{
    		   val = val * neg;
    		   neg = 1;
    		   TreeNode newNode =new TreeNode(val);
    		   TreeNode prev = stk.peek();
    		   if(prev.left != null){
    			   prev.right = newNode;
    		   }
    		   else{
    			   prev.left = newNode;
    		   }
    		   stk.push(newNode);
    		   val = 0;
    		   
    		   if(c == '('){
    			   continue;
    		   }
    		   if(c == ')'){
    			   stk.pop();
    		   }
    	   }
       }
       return dummy.left;
    }
}
