package test;

public class Sloution549 {
	int max = 0;
    public int longestConsecutive(TreeNode root) {
        postOrder(root);
        return this.max;
    }
    public consecutive postOrder(TreeNode node){
    	if(node == null){
    		return null;
    	}
    	consecutive leftCon = postOrder(node.left);
    	consecutive rightCon = postOrder(node.right);
    	
    	consecutive curr = new consecutive(1,1);
    	if(leftCon != null){
    		if(node.val - node.left.val == 1){
    			curr.inc = leftCon.inc + 1;
    		}
    		else if(node.val - node.left.val == -1){
    			curr.dec = leftCon.dec + 1;
    		}
    	}
    	if(rightCon != null){
    		if(node.val - node.right.val == 1){
    			curr.inc = Math.max(curr.inc, rightCon.inc + 1);
    		}
    		else if(node.val - node.right.val == -1){
    			curr.dec = Math.max(curr.dec, rightCon.dec + 1);
    		}
    	}
    	this.max = Math.max(max, curr.inc + curr.dec - 1);
    	return curr;
}
    	
    }


class consecutive{
	int inc;
	int dec;
	public consecutive(int inc, int dec){
		this.inc = inc;
		this.dec = dec;
	}
}
