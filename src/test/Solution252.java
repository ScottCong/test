package test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution252 {
    public boolean canAttendMeetings(Interval[] intervals) {
    	if(intervals.length == 0){
    		return true;
    	}
    	NewMyComparator com = new NewMyComparator();
    	Arrays.sort(intervals, com);
        Interval First = intervals[0];
        Interval Second;
        for(int i =1; i < intervals.length; i++){
        	Second = intervals[i];
        	if(First.end - First.start > Second.start - First.start){
        		return false;
        	}
        	First = Second;
        }
        return true;
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