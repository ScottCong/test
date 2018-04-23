package test;

import java.util.LinkedList;

public class Solution382 {
	LinkedList<ListNode> llst = new LinkedList<>();
	ListNode node;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution382(ListNode head) {
        node = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = node;
        int ans = cur.val;
        int i = 2;
        cur = cur.next;
        while(cur != null){
        	int j = (int) (Math.random() * (i)) % i;
        	if(j == 0){ans = cur.val;}
        	i++;
        	cur = cur.next;
        }
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */