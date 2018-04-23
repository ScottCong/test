package test;
//how many flowers can be planted in a flowerbed
//no adjacent flower can be planted
//solution:simulate the plant process,greedly 

public class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i < flowerbed.length; i++){
        	int prev = (i <= 0) ? 0:flowerbed[i - 1];
        	int aft = (i >= flowerbed.length - 1) ? 0 : flowerbed[i + 1];
        	if(prev == 0 && aft == 0 && flowerbed[i] == 0){
        	flowerbed[i] = 1;
        	count++;
        	}
        }
        // System.out.println(Arrays.toString(flowerbed));
        // System.out.println(count);
        if (count >= n)return true;
        return false;
     }
}