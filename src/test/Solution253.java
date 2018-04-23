package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution253 {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0){
        	return 0;
        }
        NewMyComparator com = new NewMyComparator();
        AbsComparator absc = new AbsComparator();
        Arrays.sort(intervals,com);
        Integer[] ans = new Integer[intervals.length * 2];
        for(int i = 0; i < intervals.length; i++){
        	ans[i] = intervals[i].start;
        	ans[i + intervals.length] = -1 * intervals[i].end;
        }
        Arrays.sort(ans,absc);
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for(int num : ans){
        	if(num >=0){
        		answer += 1;
        		if(answer > max)max = answer;
        	}
        	else{
        		answer -= 1;
        	}
        }
        return max;
//        intervals = merge(intervals);
//        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//        for(int i = 0; i < intervals.length; i++){
//        	map.put(i, 0);
//        }
//        for(int begin = 0; begin < intervals.length - 1; begin++){
//        	Interval b = intervals[begin];
//        	for(int end = begin + 1; end < intervals.length; end++){
//        		Interval e = intervals[end];
//        		if(b.end - b.start > e.start - b.start){
//        			map.put(begin, map.get(begin) + 1);
//        			map.put(end, map.get(end) + 1);
//        		}
//        		else{break;}
//        	}
//        }
//        int ans = Integer.MIN_VALUE;
//        for(int j :map.values()){
//        	if (j > ans) ans = j;
//        }
//        return ans;
//    }
//    public Interval[] merge(Interval[] intervals){
//    	Interval first = intervals[0];
//    	List<Interval> ans = new LinkedList<>(); 
//    	for(int i = 1; i < intervals.length; i++){
//    		Interval second = intervals[i];
//    		if(first.end < second.start){
//    			first.end = second.end;
//    			continue;
//    		}
//    		else{
//    			ans.add(first);
//    			first = second;
//    		}
//    	}
//    	ans.add(first);
//    	Interval[] ret = new Interval[ans.size()];
//    	for(int j = 0; j < ans.size(); j++ ){
//    		ret[j] = ans.get(j);
//    	}
//    	return ret;
//    }
}
class NewMyComparator implements Comparator<Interval>{
	public int compare(Interval o1, Interval o2){
		if(o1.start > o2.start){
			return 1;
		}
		else if(o1.start < o2.start){
			return -1;
		}
		else{
			if(o1.end > o2.end){
				return 1;
			}
			else if(o1.end < o2.end){
				return -1;
			}
			else
			{
			return 0;
			}
		}
		
	}
}
class AbsComparator implements Comparator<Integer>{
	public int compare(Integer o1, Integer o2){
		if(Math.abs(o1) > Math.abs(o2)){
			return 1;
		}
		else if(Math.abs(o1) < Math.abs(o2)){
			return -1;
		}
		else{
			return 0;}
		}



		
	}
}