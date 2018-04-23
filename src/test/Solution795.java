package test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution795 {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        Queue<Integer> chunks = new LinkedList<>();
        int ans = 0;
        int cur = 0;
        int max = 0;
        for(int i : A){
        	max = Math.max(max, i);
        	if(max <= R){
        		cur++;
        	}
        	else{
        		chunks.offer(cur);
        		cur = 0;
        		max = 0;
        	}
        }
        chunks.offer(cur);
        while(!chunks.isEmpty()){
        	ans += cal(chunks.poll());
        }
        
        cur = 0;
        chunks = new LinkedList<>();
        for(int i : A){
        	if(i < L){
        		cur++;
        	}
        	else{
        		chunks.offer(cur);
        		cur = 0;
        	}
        }
        chunks.offer(cur);
        while(!chunks.isEmpty()){
        	ans -= cal(chunks.poll());
        }
        return ans;
    }
    
    public int cal(int n){
    	return (n + 1) * n /2;
    }
}
