package test;

import java.util.HashMap;

public class Solution274 {
    public int hIndex(int[] citations) {
    	int largest = 0;
    	int smallest = Integer.MAX_VALUE;
        HashMap<Integer, Integer> bucket = new HashMap<>();
        for(int i: citations){
        	int count = bucket.getOrDefault(i, 0);
        	bucket.put(i, count + 1);
        	largest = Math.max(largest, i);
        	smallest = Math.min(smallest, i);
        }
        int paper_count = 0;
        int ans = 0;
        for(int i = largest; i >= smallest; i--){
        	if(!bucket.containsKey(i))continue;
        	paper_count += bucket.getOrDefault(i, 0);
        	ans = Math.max(ans, Math.min(paper_count, i));
        	
        }
        return ans;
    }
}
