package test;

import java.util.*;

public class Solution681 {
    public String nextClosestTime(String time) {
        String[] timeDig = time.split(":");
        HashSet<Integer> set = new HashSet<>();
        int[] targetTime = new int[4];
        for(int i = 0; i < 2; i++){
        	String s = timeDig[i];
        	int t = Integer.valueOf(s);
        	set.add(t / 10);
        	targetTime[i * 2] = t / 10;
        	set.add(t % 10);
        	targetTime[i * 2 + 1] = t % 10;
        }
        Queue<Integer[]> que = new LinkedList<>();
        que.offer(new Integer[4]);
        for(int i = 0; i < 4; i++){
        	Queue<Integer[]> tmp = new LinkedList<>();
        	while(que.size() > 0){
        		Integer[] cur = que.poll();
        		for(int dig : set){
        			Integer[] newArray = cur.clone();
        			newArray[i] = dig;
        			tmp.offer(newArray);
        		}
        	}
        	que = tmp;
        }
        Integer MinTime = 24 * 60;
        String ans = time;
        while(que.size() > 0){
        	Integer[] cur = que.poll();
        	if((cur[0] * 10 + cur[1]) >= 24 ||cur[2] > 5)continue;
        	int timeDiff = (cur[0] * 10 + cur[1] - targetTime[0] * 10 - targetTime[1])*60 + (cur[2]* 10 + cur[3] - targetTime[2] * 10 - targetTime[3]);
        	timeDiff = (timeDiff <= 0)?(timeDiff + 24 * 60): timeDiff;
            //System.out.println(timeDiff);
        	if(timeDiff < MinTime){
        		ans = String.valueOf(cur[0]) + String.valueOf(cur[1]) + ":" + String.valueOf(cur[2]) + String.valueOf(cur[3]);
        		MinTime = timeDiff;
        	}
        }
        return ans;
    }
}
