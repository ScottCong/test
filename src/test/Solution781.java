package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class Solution781 {
    public int numRabbits(int[] answers) {
    	TreeSet<Integer> set = new TreeSet<>();
    	Arrays.sort(answers);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: answers){
        	set.add(i);
        	map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int ans = 0;
        for(int i: set){
        	int group = map.get(i) / (i + 1);
        	ans += (map.get(i)% (i + 1)) > 0? (group + 1) * (i + 1):group * (i + 1);
        }
        return ans;
        
    }
}
