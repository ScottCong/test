package test;

import java.util.*;

public class Solution672_bulb_switcher {
	HashSet<Integer> set = new HashSet<>();
    public int flipLights(int n, int m) {
        if(m == 0)return 1;
        if(n >=3){
        	HashMap<Integer, Integer> map = new HashMap<>();
        	for(int i = 1; i <= 4; i++){
        		map.put(i, 0);
        	}
        	helper(map, 0, m);
            //for(int i: set)System.out.println(i);
        	return set.size();
        }else if(n == 1)return 2;
        else{
        	if(m == 1)return 3;
        	else return 4;
        }
    }
    public void helper(HashMap<Integer,Integer> map, int times, int m){
    	if(times > 8 || times >= m)return;
    	for(int i = 1; i<=4; i++){
    		flip(map, i);
            if(times == m - 1 || times > 2){
            int res = calculate(map);
    		set.add(res);
            }
    		helper(map, times + 1, m);
    		flip(map, i);
    	}
    	return;
    }
    public void flip(HashMap<Integer, Integer> map, int opt){
    	if(map.get(opt) == 1)map.put(opt, 0);
    	else map.put(opt, 1);
    }
    public int calculate(HashMap<Integer, Integer> map){
    	int ans = 0;
    	if(map.get(1) == 1){
    		flip(map,2);
    		flip(map,3);
    		int fac = 1;
    		for(int i = 2; i <= 4; i++){
    			ans += fac * (map.get(i));
    			fac *= 2;
    		}
    		flip(map,2);
    		flip(map,3);
    	}
    	else{
    		int fac = 1;
    		for(int i = 2; i <= 4; i++){
    			ans += fac * (map.get(i));
    			fac *= 2;
    		}
    	}
        //System.out.println(ans);
    	return ans;
    }
}
