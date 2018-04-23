package test;

public class Solution568 {
    public int maxVacationDays(int[][] flights, int[][] days) {
    	int weeks = days[0].length;
    	int citys = flights.length;
        int[][] maxDays = new int[weeks + 1][flights.length];
        for(int i = 0; i < citys; i++){
            for(int j = 0; j <= weeks; j++){
        	maxDays[j][i] = Integer.MIN_VALUE;
            }
        }
        for(int j = 0; j <=weeks; j++){
            maxDays[j][0] = 0;
        }
        for(int week = 1; week <= weeks; week++){
        	for(int city1 = 0; city1 < citys; city1++){
        		for(int city2 = 0; city2 < citys; city2++){
        			if(flights[city2][city1] == 1 || city1 == city2){
        				maxDays[week][city1] = Math.max(maxDays[week][city1], maxDays[week - 1][city2] + days[city1][week - 1]);
        			}
        		}
        		//System.out.println(maxDays[week][city1]);
        	}
        }
        int ans = 0;
        for(int i = 0; i < citys; i++){
        	ans = Math.max(maxDays[weeks][i],ans);
        }
        return ans;
    }
}
