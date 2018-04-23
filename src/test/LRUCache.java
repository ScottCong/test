package test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	int cap;
	DLN start = new DLN();
	DLN end = new DLN();
	Map<Integer,DLN> map = new HashMap<Integer,DLN>();
	Map<DLN, Integer> searchMap = new HashMap<DLN,Integer>();
    public LRUCache(int capacity) {
        this.cap = capacity;
        start.next = end;
        end.pre = start;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
        	DLN Reached = map.get(key);
        	Reached.pre.next = Reached.next;
        	Reached.next.pre = Reached.pre;
        	Reached.next = end;
        	Reached.pre = end.pre;
        	end.pre.next = Reached;
        	end.pre = Reached;
        	return map.get(key).val;
        }
        else{
        	return -1;
        }
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).val = value;
        	DLN Reached = map.get(key);
        	Reached.pre.next = Reached.next;
        	Reached.next.pre = Reached.pre;
        	Reached.next = end;
        	Reached.pre = end.pre;
        	end.pre.next = Reached;
        	end.pre = Reached;
        	return;
        }
        if(map.size() < this.cap){
        	this.addNode(key, value);
        }
        else if(map.size() >= this.cap){
        	DLN Remove = start.next;
        	DLN Next = Remove.next;
        	start.next = Next;
        	Next.pre = start;
        	map.remove(searchMap.get(Remove));
        	searchMap.remove(key);
        	this.addNode(key, value);
        }
        else{
        	System.out.println("impossible");
        }
    }
    public void addNode(int key, int value){
        DLN newNode = new DLN();
        newNode.val = value;
        newNode.next = this.end;
        newNode.pre = this.end.pre;
        end.pre = newNode;
        newNode.pre.next = newNode; 
        end.pre = newNode;
        map.put(key, newNode);
        searchMap.put(newNode, key);
    }
}

class DLN{
	Integer val = 0 ;
	DLN pre;
	DLN next;
}
