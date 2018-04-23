package test;

import java.util.*;

public class Task_Rearrangment {
    public int leastInterval(char[] tasks, int n) {
    	int ans = 0;
    	int remainTask = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: tasks){
        	remainTask+=1;
        	if(!map.containsKey(c)){
        		map.put(c, 1);
        	}
        	else map.put(c, map.get(c) + 1);
        }
        PriorityQueue<Task> readyPool = new PriorityQueue<Task>(new MyComparator());
        for(Character c: map.keySet()){
            // System.out.println(c);
            // System.out.println(map.get(c));
        	readyPool.offer(new Task(c, map.get(c)));
        }
        Queue<Task> waitLine = new LinkedList<>();
        while(remainTask > 0){
        	ans += 1;
        	Task nextReady = null;
          // System.out.println(remainTask);
        	if(waitLine.size() >= n + 1){
        		nextReady = waitLine.poll();
        		if(nextReady.name != '*'){
        			readyPool.offer(nextReady);
        		}
        		
            	if(readyPool.size() == 0){
                  //System.out.println('*');
                  waitLine.offer(new Task('*', 0));
           	    }
                else{
                    remainTask -= 1;
                    Task currentTask = readyPool.poll();
                    currentTask.numberLeft -= 1;
                    //System.out.println(currentTask.name);
                    if(currentTask.numberLeft == 0)waitLine.offer(new Task('*', 0));
                    else waitLine.offer(currentTask);
                    }
        	    }
            
            
            
        	else{
        		if(readyPool.size() == 0){
                    //System.out.println('*');
        			waitLine.offer(new Task('*', 0));
        		}
        		else{
        			remainTask -= 1;
        			Task currentTask = readyPool.poll();
                    //System.out.println(currentTask.name);
        			currentTask.numberLeft -= 1;
                    if(currentTask.numberLeft == 0)waitLine.offer(new Task('*', 0));
        			else waitLine.offer(currentTask);
        		}
        	}
        	

        }
        return ans;
    }
    private class Task{
    	char name;
    	int numberLeft;
    	public Task(char c, int n){
    		name = c;
    		numberLeft = n;
    	}
    }
    
    private class MyComparator implements Comparator<Task>{

		@Override
		public int compare(Task o1, Task o2) {
			// TODO Auto-generated method stub
			if(o1.numberLeft > o2.numberLeft)return -1;
			else if(o1.numberLeft < o2.numberLeft)return 1;
			else return 0;
		}
    	
    }
}
