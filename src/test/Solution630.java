package test;

import java.util.Arrays;
import java.util.PriorityQueue;

//course schedule
//greedy
//from the earliest end time course, we should get as many courses as possible
//1.if the total time is enough, select this course
//2.if the total time is not enough, see if the new course takes less time than the already selected course
// if the new course takes less time, select new course instead of the largest time course
// if not continue check other courses
public class Solution630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(num1,num2)->{
        	if(num1[1] != num2[1])return (num1[1] - num2[1]);
        	else return (num1[0] - num2[0]);
        });
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((i, j) -> (j - i));
        int cap;
        int totalTime = 0;
        for(int[] course:courses){
            //System.out.println(course[1]);
        	cap = course[1];
        	if(pq.size() == 0 && course[0] <= cap){
        		pq.offer(course[0]);
        		totalTime += course[0];
        	}
        	else{
        		if(totalTime + course[0] <= cap){
        			pq.offer(course[0]);
        			totalTime += course[0];
        		}
        		else{
        			if(course[0] >= pq.peek())continue;
        			else{
        				int rmv = pq.remove();
        				totalTime -= rmv;
                        totalTime += course[0];
        				pq.offer(course[0]);
        			}
        		}
        	}
        	
        }
        return pq.size();
    }
}
