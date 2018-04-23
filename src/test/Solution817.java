package test;

import java.util.HashSet;

public class Solution817 {
    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i: G)set.add(new Integer(i));
        boolean preHit = false;
        int counter = 0;
        while(head != null){
        	if(set.contains(head.val)){
        		if(preHit == false){
        			preHit = true;
        			counter++;
        		}
        	}
        	else if(!set.contains(head.val)){
        		if(preHit == true){
        			preHit = false;
        		}
        	}
        	head = head.next;
        }
        return counter;
    }
}
