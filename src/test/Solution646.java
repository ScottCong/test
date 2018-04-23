package test;

import java.util.*;

public class Solution646 {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int findLongestChain(int[][] pairs) {
    	if(pairs.length == 0)return 0;
    	if(pairs.length == 1)return 1;
    	Arrays.sort(pairs, new SelfComp());
        for(int[] i: pairs){
        	int ans = 1;
        	if(map.size() == 0){
        		map.put(i[1], 1);
        	}
        	else{
        		for(int j: map.keySet()){
        			System.out.println(map.get(j));
        			if(i[0] > j){
        				ans = Math.max(ans, map.get(j) + 1);
        			}
        		}
        		ans = Math.max(ans, map.getOrDefault(i[1], 0));
        		map.put(i[1], ans);
        	}
        }
        int ans = 0;
        for(int i: map.keySet()){
        	ans = Math.max(ans, map.get(i));
        }
        return ans;
    }

}
class SelfComp implements Comparator<int[]>{
	@Override
	public int compare(int[] o1, int[] o2) {
		// TODO Auto-generated method stub
		if(o1[0] > o2[0])return 1;
		else if(o1[0] < o2[0])return -1;
		else return 0;
	}
	
}