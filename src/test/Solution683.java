package test;

import java.util.*;

public class Solution683 {
    public int kEmptySlots(int[] flowers, int k) {
    		Integer a;
    		
            int max = flowers.length;
            int min = 1;
            HashMap<Integer, Integer> map = new HashMap<>();
            HashSet<Integer> gaps = new HashSet<>();
            ArrayList<LinkNode> lst = new ArrayList<>();
            LinkNode head = new LinkNode(min - 1);
            LinkNode tail = new LinkNode(max + 1);
            head.Next = tail;
            tail.Prev = head;
            lst.add(head);
            lst.add(tail);
            for(int day = 0; day < max; day++){
            	int insert = binarySearch(lst, flowers[day]);
            	//System.out.println(insert);
            	LinkNode pre = lst.get(insert);
            	LinkNode aft = pre.Next;
            	LinkNode mid = new LinkNode(flowers[day]);
            	if(pre.val != head.val && gaps.add(mid.val - pre.val - 1)){
            		map.put(mid.val - pre.val-1, day + 1);
            	}
            	if(aft.val != tail.val && gaps.add(aft.val - mid.val - 1)){
            		map.put(aft.val - mid.val-1, day + 1);
            	}
            	pre.Next = mid;
            	aft.Prev = mid;
            	mid.Prev = pre;
            	mid.Next = aft;
            	lst.add(insert + 1, mid);
            }
            if(!gaps.contains(k))return -1;
            return map.get(k);
        }
        public int binarySearch(ArrayList<LinkNode> lst, int inserted){
        	int start = 0;
        	int end = lst.size() - 1;
        	if(inserted == lst.get(start).val || inserted == lst.get(end).val)return inserted;
        	while(start < end){
        		int mid = (start + end) / 2;
        		if(inserted > lst.get(mid).val){
        			start = mid + 1;
        		}
        		else if(inserted < lst.get(mid).val){
        			end = mid - 1;
        		}
        	}
        	if(lst.get(start).val > inserted)return start - 1;
        	else return start;
        }
}

class LinkNode{
	LinkNode Prev = null;
	LinkNode Next = null;
	int val;
	public LinkNode(int n){
		this.val = n;
	}
}
