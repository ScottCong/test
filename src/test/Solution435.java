package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

public class Solution435 {
    public int eraseOverlapIntervals(Interval[] intervals) {
    	if(intervals.length < 1)return intervals.length;
        int ans = 1;
        MyComp com = new MyComp();
        Arrays.sort(intervals,com);
        Set<Integer> set = new HashSet<>();
        Map<Integer, Interval> startWith = new HashMap<>();
        Map<Integer, Integer> max = new HashMap<>();
        for(int i = 0; i < intervals.length; i++){
        	if(startWith.containsKey(intervals[i].start)){
        		continue;
        	}
        	if(max.size() == 0){
        		max.put(intervals[i].end, 1);
        		startWith.put(intervals[i].start, intervals[i]);
        		set.add(intervals[i].end);
        	}
        	else{
        		int curmax = 1;
        		for(int j: set){
        			if(j <= intervals[i].start){
        				curmax = Math.max(curmax, max.get(j) + 1);
        			}
        		}
        		curmax = Math.max(curmax, max.getOrDefault(intervals[i].end, 1));
        		max.put(intervals[i].end, curmax);
        		ans = Math.max(ans, curmax);
        		set.add(intervals[i].end);
        	}
        }
        return intervals.length - ans;
    }
}

class MyComp implements Comparator<Interval>{

	@Override
	public int compare(Interval o1, Interval o2) {
		// TODO Auto-generated method stub
		if(o1.start < o2.start)return -1;
		else if(o1.start > o2.start)return 1;
		else{
			if(o1.end - o2.end < 0)return -1;
			else if(o1.end - o2.end > 0)return 1;
			else return 0;
		}
	}
	
}
