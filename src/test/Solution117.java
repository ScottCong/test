package test;

class TreeLinkedNode{
	TreeLinkedNode left = null;
	TreeLinkedNode right = null;
	TreeLinkedNode next = null;
	int val;
	public TreeLinkedNode(int val){
		this.val = val;
	}
}
public class Solution117 {
    public void connect(TreeLinkedNode root) {
        TreeLinkedNode cur= root;
        TreeLinkedNode head = null;
        TreeLinkedNode leading = null;
	    while(cur != null){
	        	while(cur != null){
	        	if(cur.left != null){
	        		if(head == null){
	        			head = cur.left;
	        			leading = cur.left;
	        		}
	        		else {
	        			leading.next = cur.left;
	        			leading = leading.next;
	        		}
	        	}
	        	if(cur.right != null){
	        		if(head == null){
	        			head = cur.right;
	        			leading = cur.right;
	        		}
	        		else{
	        			leading.next = cur.right;
	        			leading = leading.next;
	        		}
	        	}
	        	cur = cur.next;
	        }
	        cur = head;
	        head = null;
	        leading = null;
	    }
        return;

    }
}
