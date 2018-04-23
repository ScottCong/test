package test;
//蛤蛤过河
import java.util.HashMap;
import java.util.HashSet;

public class Solution403 {
    public boolean canCross(int[] stones) {
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        HashSet<Integer> init = new HashSet<>();
        init.add(1);
        map.put(stones[0], init);
        HashSet<Integer> set = new HashSet<>();
        for(int i: stones){
        	set.add(i);
        }
        for(int i = 0; i<stones.length - 1; i++){

        	int current = stones[i];
        	HashSet<Integer> currentSet = map.getOrDefault(current, new HashSet<Integer>());
        	//System.out.println(i);
        	if(currentSet.isEmpty())continue;
        	for(int num: currentSet){
        		if(num > 0 && set.contains(current + num)){
                	//System.out.println(current + num);
                	HashSet<Integer> newSet = map.getOrDefault(current + num, new HashSet<Integer>());
        			newSet.add(num + 1);
        			newSet.add(num);
        			if(num - 1 > 0)newSet.add(num - 1);
        			map.put(current + num, newSet);
        		}
        	}
        }
        if(map.getOrDefault(stones[stones.length - 1], new HashSet<Integer>()).isEmpty())return false;
        return true;
    }
}
