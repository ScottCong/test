package test;

import java.util.HashMap;
import java.util.*;

public class Solution514 {
    public int findRotateSteps(String ring, String key) {
        HashMap<Character, List<Integer>> charMap = new HashMap<>();
        HashMap<Integer, Integer> stepMap = new HashMap<>();
        for(int i = 0; i < ring.length(); i++){
        	if(charMap.get(ring.charAt(i)) == null)charMap.put(ring.charAt(i), new LinkedList<Integer>());
        	charMap.get(ring.charAt(i)).add(i);
        }
        stepMap.put(0, 0);
        for(char c: key.toCharArray()){
        	HashMap<Integer, Integer> tmpMap = new HashMap<>();
        	List<Integer> charIndexes = charMap.get(c);
        	Set<Integer> prevPositions = stepMap.keySet();
        	for(Integer curIndex: charIndexes){
        		int MinDis = Integer.MAX_VALUE;
        		for(Integer prevIndex: prevPositions){
        			MinDis = Math.min(MinDis, findMiniumsteps(ring, curIndex, prevIndex) + 1 + stepMap.get(prevIndex));
        		}
        		tmpMap.put(curIndex, MinDis);
        	}
        	stepMap = tmpMap;
        }
        int ans = Integer.MAX_VALUE;
        for(int index: stepMap.keySet()){
        	ans = Math.min(ans, stepMap.get(index));
        }
        return ans;
    }
    public int findMiniumsteps(String ring, int index1, int index2){
    	int len = ring.length();
    	int dis1 = Math.abs(index1 - index2);
    	int dis2 = Math.min(index1,index2) - Math.max(index1,index2) + len;
    	return Math.min(dis1, dis2);
    }
}
