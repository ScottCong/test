package test;
//注意有环
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
    	if(head == null || head.next == null)return head;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode smaller = dummy1;
        ListNode larger = dummy2;
        while(head != null){
            
        	if(head.val < x){                
        		smaller.next = head;
        		smaller = smaller.next;
        		head = head.next;
        	}
        	else{                
        		larger.next = head;
        		larger = larger.next;
        		head = head.next;
        	}
        }
        smaller.next = null;
        larger.next = null;
        smaller.next = dummy2.next;
        return dummy1.next;
    }
}
