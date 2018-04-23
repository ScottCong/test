package test;

public class Solution445_Linkedlist_add {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = countLength(l1);
        int len2 = countLength(l2);
        ListNode longer, shorter;
        int targetLen, shorterLen;
        if(len1 >= len2){
        	longer = l1;
        	shorter = l2;
        	targetLen = len1;
        	shorterLen = len2;
        }
        else{
        	longer = l2;
        	shorter = l1;
        	targetLen = len2;
        	shorterLen = len1;
        }
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        for(int i = 1; i <= targetLen; i++){
        	cur.next = new ListNode(0);
        	cur = cur.next;
        }
        int addOne = addNode(ans.next, longer, shorter, 0, (targetLen - shorterLen));
        if(addOne == 0){
        	return ans.next;
        }
        else{
        	ans.val = 1;
        	return ans;
        }
    }
    public int addNode(ListNode cur, ListNode longer, ListNode shorter, int index,int lenDiff){
    	if(cur == null)return 0;
    	int addOne, sum;
    	if(index >= lenDiff){
    		addOne = addNode(cur.next, longer.next, shorter.next, index + 1, lenDiff);
    	}
    	else{
    		addOne = addNode(cur.next, longer.next, shorter, index + 1, lenDiff);
    	}
    	if(index >= lenDiff){
    		sum = longer.val + shorter.val + addOne;
    	}
    	else{
    		sum = longer.val + addOne;
    	}
    	cur.val = sum % 10;
    	return sum / 10;
    }
    public int countLength(ListNode n){
    	int l = 0;
    	while(n != null){
    		l++;
    		n = n.next;
    	}
    	return l;
    }
}
