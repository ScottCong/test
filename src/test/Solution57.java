package test;

import java.util.*;

public class Solution57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> ans = new LinkedList<>();
    	if(intervals.size() == 0){
    		ans.add(newInterval);
    		return ans;
    	}
    	if(newInterval.start > intervals.get(intervals.size() - 1).end){
    		for(Interval interval: intervals)ans.add(interval);
    		ans.add(newInterval);
    		return ans;
    	}
    	else if(newInterval.end < intervals.get(0).start){
    		ans.add(newInterval);
    		for(Interval interval: intervals)ans.add(interval);
    		return ans;
    	}
    	List<Interval> Interfered = new LinkedList<>();
    	List<Interval> Top = new LinkedList<>();
    	List<Interval> Bot = new LinkedList<>();
    	for(Interval interval: intervals){
    		if(interval.end < newInterval.start || interval.start > newInterval.end){
    			if(interval.end < newInterval.start)Top.add(interval);
    			else Bot.add(interval);
    		}
    		else{
    			Interfered.add(interval);
    		}
    	}
    	if(Interfered.size() == 0){
    		for(Interval interval: Top)ans.add(interval);
    		ans.add(newInterval);
    		for(Interval interval: Bot)ans.add(interval);
    		return ans;
    	}
    	else{
    		for(Interval interval: Top)ans.add(interval);
    		int start = Math.min(newInterval.start, Interfered.get(0).start);
    		int end = Math.max(newInterval.end, Interfered.get(Interfered.size() - 1).end);
    		ans.add(new Interval(start, end));
    		for(Interval interval: Bot)ans.add(interval);
    	}
    	return ans;
    }
//    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//        int newBegin = newInterval.start;
//        int newEnd = newInterval.end;
//        int start = 0, end;
//        int ansStart = newBegin;
//        int ansEnd = newEnd;
//        List<Interval> ans = new LinkedList<>();
//        if(intervals.size() == 0){
//            ans.add(new Interval(newInterval.start, newInterval.end));
//            return ans;
//        }
//        int index = 0;
//        Queue<Integer> que = new LinkedList<>();
//        //System.out.println(start);
//        for(Interval interval: intervals){
//        	que.offer(interval.start);
//        	que.offer(-interval.end);
//        }
//        if(newEnd < que.peek()){
//            ans.add(newInterval);
//            for(Interval interval:intervals){
//                ans.add(interval);
//            }
//            return ans;
//        }
//        while(que.size() > 0){
//        	int cur = que.peek();
//            //System.out.println(cur);
//        	if(cur >= 0){
//                que.poll();
//        		start = cur;
//        	}
//        	else if(cur < 0){
//        		end = - cur;
//        		if(end < newBegin){
//                    que.poll();
//        			ans.add(new Interval(start, end));
//        		}
//        		else if(end >= newBegin){
//        			if(start >= newBegin){
//        				ansStart = newBegin;
//        			}
//        			else ansStart = start;
//        			break;
//        		}
//        		
//        	}
//        	if(que.size() == 0)ans.add(new Interval(ansStart, ansEnd));
//        }
//        while(que.size() > 0){
//        	int cur = que.peek();
//            //System.out.println(cur);
//        	if(cur >= 0){
//        		start = cur;
//                que.poll();
//        		if(start > newEnd){
//        			ansEnd = newEnd;
//        			ans.add(new Interval(ansStart, ansEnd));
//        			break;
//        		}
//        	}
//        	if(cur < 0){
//        		end = -cur;
//                que.poll();
//        		if(end >= newEnd){
//        			ansEnd = end;
//        			ans.add(new Interval(ansStart,ansEnd));
//        			break;
//        		}
//        	}
//        	if(que.size() == 0){
//        		ansEnd = newEnd;
//        		ans.add(new Interval(ansStart, ansEnd));
//        	}
//        	
//        }
//        while(que.size() > 0){
//        	int cur = que.poll();
//            //System.out.println(cur);
//        	if(cur >= 0){
//        		start = cur;
//        	}
//        	else if(cur < 0){
//        		end = -cur;
//        		ans.add(new Interval(start, end));
//        	}
//        }
//        return ans;
//    }
}
