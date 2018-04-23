package test;

import java.util.*;

public class Task_with_cool_down {
	public int TaskTime(String tasks, int cooldown){
		char[] taskList = tasks.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		int timeline = 0;
		for(char task: taskList){
			if(!map.containsKey(task)){
				map.put(task, timeline);
				timeline += 1;
			}
			else{
				int prevTime = map.get(task);
				if(timeline - prevTime <= cooldown){
					timeline = prevTime + cooldown + 2;
				}
				else{
					timeline += 1;
				}
			}
		}
		return timeline;
	}
}
