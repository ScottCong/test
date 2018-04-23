package test;

import java.util.LinkedList;

//burst balloons, complex dynamic programming
public class Solution312 {
    public int maxCoins(int[] nums) {
        LinkedList<Integer> lst = new LinkedList<>();
        for(int i: nums){
        	if(!(i==0))lst.add(i);
        }
        int[] newNums = new int[lst.size() + 2];
        for(int i =0; i< lst.size();i++){
        	newNums[i + 1] = lst.get(i);
        }
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;
        if(lst.size() == 0){
        	return 0;
        }
        int[][] maxCoin = new int[newNums.length][newNums.length];
        for(int i =0; i<newNums.length; i++){
        	maxCoin[i][i] = newNums[i];
        }
        for(int length = 1; length < newNums.length; length++){
        	for(int begin = 0; begin < newNums.length; begin++){
        		int left = begin;
        		int right = begin + length;
        		if(right > newNums.length - 1) break;
        		for(int i = left;i<=right;i++){
        			maxCoin[left][right] = Math.max(maxCoin[left][right], maxCoin[left][i]+maxCoin[i][right] +newNums[i]);
        		}
        		
        	}
        }
        return maxCoin[1][newNums.length - 2];
    }
}
