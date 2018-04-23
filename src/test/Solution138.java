package test;

import java.util.HashMap;

//return a deep copy of a list whose nodes have random pointer
public class Solution138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        if(head == null)return null;
        RandomListNode curNode = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode newNode;
        newNode = dummy;
        while(curNode.next != null){
        	newNode.next = new RandomListNode(curNode.label);
        	newNode = newNode.next;
        	map.put(curNode.next, newNode);
        	curNode = curNode.next;
        }
        //if random == null: new random == null
        //if random.next == null: new random == lastnode
        //else new random = map.get(random.next)
        newNode.next = new RandomListNode(curNode.label);
        newNode = newNode.next;
        RandomListNode lastNewNode = newNode;
        newNode = dummy.next;
        curNode = head;
        while(newNode != null){
            System.out.println(newNode.label);
        	if(curNode.random == null)newNode.random = null;
        	else if(curNode.random.next == null)newNode.random = lastNewNode;
        	else newNode.random = map.get(curNode.random.next);
            newNode = newNode.next;
        	curNode = curNode.next;
        }
        return dummy.next;
    }
}
class RandomListNode{
	int label;
	RandomListNode next, random;
	public RandomListNode(int x){
		this.label = x;
	}
}