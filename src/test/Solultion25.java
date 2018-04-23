package test;

public class Solultion25 {
    public ListNode reverseKGroup(ListNode head, int k) {
    	//ListNode dummy = new ListNode(0);
    	
        ListNode cur = head;
        ListNode ans = null;
        ListNode[] nodes = new ListNode[]{null,head};
        while(nodes != null){
        	nodes[1].next = nodes[0];	
        	nodes = reverseNodes(cur, k);
        	if(ans == null)ans = nodes[0];
        	cur = nodes[1]; 
        	
        }
        if(ans == null)return head;
        return ans;
    }
    public ListNode[] reverseNodes(ListNode head, int k){
    	//ListNode ans = null;
    	ListNode[] returnNodes = new ListNode[2];
    	
    	ListNode cur = head;
    	for(int i = 0; i< k - 1; i++){
    		if(cur == null || cur.next == null)return null;
    		cur = cur.next;
    	}
    	ListNode nextNode = cur.next;
    	returnNodes[0] = cur;
    	returnNodes[1] = nextNode;
    	ListNode dummy = new ListNode(0);
    	dummy.next = cur;
    	
    	
    	ListNode prev = null;
    	ListNode current = head;
    	ListNode next = head.next;
    	for(int i = 0; i < k - 1; i++){
            System.out.println(current.val);
    		next = current.next;
    		current.next = prev;
    		prev = current;
    		current = next;
    	}
    	current.next = prev;
    	
    	return returnNodes;
    }
}
