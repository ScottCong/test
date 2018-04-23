package test;

public class Solution143 {
    public void reorderList(ListNode head) {
        if(head == null)return;
        int len = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head.next != null){
        	len += 1;
        	head = head.next;
        }
        
        if(len <= 2)return;
        if(len % 2 == 0)len = len /2;
        else len = (len /2) ;
        ListNode dummy2 = new ListNode(0);
        head.next = dummy2;
        head = dummy.next;
        for(int i = 0; i < len; i++){
        	head = head.next;
        }
        ListNode tmp = head.next;
        head.next = null;
        head = tmp;
        ListNode PrevNode = null;
        while(head.next != null){
        	ListNode tmpNode = head.next;
        	head.next = PrevNode;
        	PrevNode = head;
        	head = tmpNode;
        }
        head.next = PrevNode;
        ListNode head1 = dummy.next;
        ListNode head2 = dummy2.next;
        while(head2 != null){
        // System.out.println(head1.val);
        // System.out.println(head2.val);
        	ListNode tmp1 = head1.next;
        	ListNode tmp2 = head2.next;
        	head1.next = head2;
        	head2.next = tmp1;
        	head1 = tmp1;
        	head2 = tmp2;
        }
        return;
        
    }
}
