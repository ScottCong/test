package test;

import java.util.TreeMap;

//calender problem
//for the meeting room problem, we could imagine the time line in a real line
//for the meeting start, we can set this start as positive 1 (+1) and the end to negative 1 (-1)
//to see how many meeting is running, just sum the numbers up. We don't care which end belongs to which part
public class Solution731_my_calender_2 {
	TreeMap<Integer, Integer> map;
    public Solution731_my_calender_2() {
        map = new TreeMap<Integer,Integer>();
    }
    
    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        
        int active = 0;
        for(int i: map.values()){
        	active += i;
        	if(active >= 3){
                map.put(start, map.getOrDefault(start, 0) - 1);
                map.put(end, map.getOrDefault(end, 0) + 1);
                return false;
        	}
        	
        }
        return true;
    }
}