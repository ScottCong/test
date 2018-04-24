package test;

public class Solution729_my_calender_1 {
	SegmentTreeNode root;
    public  Solution729_my_calender_1() {
        
    }
    
    public boolean book(int start, int end) {
        if(this.root == null){
        	this.root = new SegmentTreeNode(start, end);
        	return true;
        }
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        return insertNode(node, root);
    }
    
    public boolean insertNode(SegmentTreeNode node, SegmentTreeNode curNode){
    	if(node.start < curNode.start){
    		if(node.end > curNode.start)return false;
    		if(curNode.left == null){
    			curNode.left = node;
    			return true;
    		}
    		else{
    			return insertNode(node, curNode.left);
    		}
    	}
    	
    	else if(node.start >= curNode.end){
    		if(curNode.right == null){
    			curNode.right = node;
    			return true;
    		}
    		else{
    			return insertNode(node, curNode.right);
    		}
    	}
    	
    	else{
    		return false;
    	}
    }
    
}


class SegmentTreeNode{
	
	SegmentTreeNode left;
	SegmentTreeNode right;
	int start;
	int end;
	public SegmentTreeNode(int start, int end){
		this.start = start;
		this.end = end;
	}
}