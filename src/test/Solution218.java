package test;

import java.util.*;
//skyline problem, very interesting 
//观察每个转折点，每个转折点有可能是变化的关键点
//观察每个转折点时保证和覆盖自己的楼的高度作比较，取最高的那点（如果和之前的转折点一样高就不作为答案记下来）
//保证和覆盖自己的楼做对比应该用一个heap，java就是priorityqueue
public class Solution218 {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> criticalPoints = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int[] building: buildings){
        	criticalPoints.add(new int[]{building[0], -building[2]});
        	criticalPoints.add(new int[]{building[1], building[2]});
        }
        Collections.sort(criticalPoints,(a, b) -> {
            if(a[0] != b[0]) 
                return a[0] - b[0];
            return a[1] - b[1];
    });
        List<int[]> ans = new LinkedList<>();
        pq.offer(0);
        int pre = 0;
        for(int[] criticalPoint:criticalPoints){
        	if(criticalPoint[1] <0){
        		pq.offer(-criticalPoint[1]);
        	}
        	else if(criticalPoint[1] > 0){
        		pq.remove(criticalPoint[1]);
        	}
        	int cur = pq.peek();
        	if(cur == pre)continue;
        	else ans.add(new int[]{criticalPoint[0], cur});
        	pre = cur;
        }
        return ans;
    }
}
