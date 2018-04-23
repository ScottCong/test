package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import test.Interval;
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution56 {
    public class NewMyComparator {

	}

	public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0){
            return new LinkedList<Interval>();
        }
    	NewMyComparator com = new NewMyComparator();
        intervals.sort((Comparator<? super Interval>) com);
        //intervals.add(new Interval(0,0));//dummy
        Interval first = intervals.get(0);
        List<Interval> ans = new LinkedList<Interval>();
        for(int i = 1; i < intervals.size()  ; i++){
        	//System.out.println(intervals.get(i).start);
        	Interval second = intervals.get(i);
        	if(first.end >second.end ){
        	    //System.out.println(1);
        		continue;
        	}
        	if(first.end - first.start >= second.start - first.start){
        		first = new Interval(first.start,second.end);
        		//System.out.println(2);
        	}
        	else if(first.end - first.start < second.start - first.start){
        		ans.add(first);
        		first = second;
        		//System.out.println(3);
        	}
        }
        ans.add(first);
        return ans;
    }
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