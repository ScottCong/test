package test;

import java.util.*;

public class Solution658 {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> ans = new LinkedList<>();
        if(arr.get(0) >= x){
        	for(int i = 0; i < k; i++){
        		ans.add(arr.get(i));
        	}
        	return ans;
        }
        if(arr.get(arr.size() - 1) <= x){
        	for(int i = arr.size() - k; i <= arr.size() - 1; i++){
        		ans.add(arr.get(i));
        	}
        	return ans;
        }
        int mid = binarySearch(arr, x);
        if(mid > 0 && mid < arr.size() - 1 && x > arr.get(mid) && x - arr.get(mid) > x - arr.get(mid - 1)){
        	mid = mid - 1;
        }
        else if(mid > 0 && mid < arr.size() - 1 && x < arr.get(mid) && x - arr.get(mid) < x - arr.get(mid - 1)){
        	mid = mid + 1;
        }
        int[] range = {mid, mid};
        //System.out.println(mid);
        for(int i = 0 ; i < k - 1; i++){
            // System.out.println(range[0]);
            // System.out.println(range[1]);
        	if(range[0] == 0)range[1]++;
        	else if(range[1] == arr.size() - 1)range[0]--;
        	else{
        		if(Math.abs(x - arr.get(range[0] - 1)) > Math.abs(x - arr.get(range[1] + 1))){
        			range[1]++;
        		}
        		else range[0]--;
        	}
        }
        return arr.subList(range[0], range[1] + 1);
    }
    public int binarySearch(List<Integer> arr, int target){
    	int start = 0;
    	int end = arr.size() - 1;
    	while(start < end){
    		int mid = (start + end) / 2;
    		if(arr.get(mid) == target)return mid;
    		if(arr.get(mid) > target){
    			end = mid - 1;
    		}
    		else if(arr.get(mid) < target){
    			start = mid + 1;
    		}
    	}
    	return start;
    }
}
