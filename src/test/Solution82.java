package test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null || head.next == null)return head;
        ListNode dummy = new ListNode(head.val - 1);
        dummy.next = head;
        ListNode current = head;
        ListNode prev = dummy;
        while(current != null){
        	if(current.next == null)break;
        	if(current.next.val == current.val){
        		int dup = current.val;
        		while(current.next != null && current.next.val == dup){
        			current = current.next;
        		}
        		prev.next = current.next;
        		if(current.next == null)break;
        		current = current.next;
        	}
        	else{
        		prev = current;
        		current = current.next;
        	}
        	
        }
        return dummy.next;
    }
}
