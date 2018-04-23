package test;

public class Solution725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int counts = 0;
        counts = countNodes(root);
        int length = counts / k;
        int plusOne = counts % k;
        ListNode current = root;
        ListNode[] ans = new ListNode[k];
        for(int i = 1; i <= k; i++){
        	ans[i - 1] = current;
        	current = countToNextNode(current, (i <= plusOne)? length + 1:length);
        }
        return ans;
    }
    public int countNodes(ListNode node){
    	int ans = 0;
    	while(node != null){
    		ans++;
    		node = node.next;
    	}
    	return ans;
    }
    public ListNode countToNextNode(ListNode node, int count){
    	if(count == 0 || node == null)return null;
    	for(int i = 0; i < count - 1; i++){
    		node = node.next;
    	}
    	ListNode ans = node.next;
    	node.next = null;
    	return ans;
    }
}
