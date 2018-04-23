package test;

import java.util.*;

class TwoSum {
	ArrayList<Integer> lst;
    /** Initialize your data structure here. */
    public TwoSum() {
        lst = new ArrayList<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        lst.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
    	if(lst.size() < 2)return false;
        Collections.sort(lst);
        int begin = 0;
        int end = lst.size() - 1;
        while(begin < end){
        	int val = lst.get(begin) + lst.get(end);
        	if(val == value)return true;
        	else if(val > value)end--;
        	else begin++;
        }
        return false;
    }
}