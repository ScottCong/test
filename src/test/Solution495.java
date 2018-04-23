package test;

public class Solution495 {
//    public int findPoisonedDuration(int[] timeSeries, int duration) {
//        int len = timeSeries.length;
//        int time = timeSeries[len - 1];
//        boolean[] poisoned = new boolean[time + duration];
//        for(int i: timeSeries){
//        	for(int j = 0; j < duration; j++){
//        	poisoned[i + j] = true;
//        	}
//        }
//        int count = 0;
//        for(boolean b: poisoned){
//        	if(b)count++;
//        }
//        return count;
//    }
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int begin = timeSeries[0], total = 0;
        for (int t : timeSeries) {
            total+= t < begin + duration ? t - begin : duration;
            begin = t;
        }   
        return total + duration;
    }
}
