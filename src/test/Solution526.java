package test;

import java.util.ArrayList;

public class Solution526 {
	int[] nums;
	int count = 0;
    public int countArrangement(int N) {
    	this.count = 0;
        this.nums = new int[N];
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i = 0; i < N; i++){
        	this.nums[i] = i + 1;
        	lst.add(i + 1);
        }	
        perfectMatch(lst, 0);
        return this.count;
    }
    public void perfectMatch(ArrayList<Integer> lst, int start){
    	if(lst.size() == 0){
    		this.count += 1;
    		return;
    	}
    	for(int i = 0; i < lst.size(); i++){
    		ArrayList<Integer> newLst = new ArrayList<>();
    		newLst.addAll(lst);
    		int tar = newLst.get(i);
    		int mod = (tar >= this.nums[start])? tar % nums[start] : nums[start] % tar;
    		if(mod == 0){
    			newLst.remove(i);
    			perfectMatch(newLst,start + 1);
    		}
    	}
    }
}
