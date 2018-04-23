package test;

import java.util.*;

public class Codec {

    public String serialize(TreeNode root) {
    	if(root == null)return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(que.size() > 0){
        	Queue<TreeNode> tmp = new LinkedList<>();
        	while(que.size()> 0){
        		TreeNode node = que.poll();
        		if(node == null){      			
        			sb.append('n');
                    sb.append(',');
        			continue;
        		}
    			sb.append(node.val);
                sb.append(',');
        		tmp.offer(node.left);
        		tmp.offer(node.right);
        	}
        	que = tmp;
        }
        String ans = sb.toString();
        for(String str: ans.split(",")){
        	//System.out.println(str);
        }
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data.length() == 0)return null;
        String[] strs = data.split(",");
        Queue<String> que = new LinkedList<>();
        for(String str:strs)que.offer(str);                            
        if(que.size() == 0 || que.peek() == "n")return null;
        TreeNode root = new TreeNode(Integer.valueOf(que.poll()));
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);
        while(treeNodes.size() > 0){
        	Queue<TreeNode> tmp = new LinkedList<>();
        	while(treeNodes.size() > 0){
            	String left = que.poll();
            	System.out.print(left);
            	System.out.println(left.equals("n"));
            	String right = que.poll();
            	System.out.print(right);
            	System.out.println(right.equals("n"));
            	TreeNode node = treeNodes.poll();
            	if(left.equals("n"))node.left = null;
            	else{
            		
            		TreeNode leftNode = new TreeNode(Integer.valueOf(left));
            		node.left = leftNode;
            		tmp.offer(leftNode);
            	}
            	if(right.equals("n"))node.right = null;
            	else{
            		
            		TreeNode rightNode = new TreeNode(Integer.valueOf(right));
            		node.left = rightNode;
            		tmp.offer(rightNode);
            	}
        	}
        	treeNodes = tmp;
        }
        return root;
        
    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));