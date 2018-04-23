package test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0 || points[0].length == 0){
        	return 0;
        }
        Comp com = new Comp();
        Arrays.sort(points, com);
        int index = 0;
        int ans = 0;
        while(index < points.length){
        	int[] current = points[index];
        	int end = current[1];
        	while(index < points.length && end >= points[index][0]){
        		index += 1;
        	}
        	ans += 1;
        }
        return ans;
    }
}
class Comp implements Comparator<int[]>{
	@Override
	public int compare(int[] o1, int[] o2) {
		// TODO Auto-generated method stub
		if(o1[1] > o2[1]){
			return 1;
		}
		if(o1[1] < o2[1]){
			return -1;
		}
		else{
		return 0;
		}
	}
	
}