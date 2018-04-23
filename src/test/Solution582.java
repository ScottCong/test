package test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//kill process
public class Solution582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        LinkedList<Integer> ans = new LinkedList<>();
        for(int i = 0; i < pid.size(); i++){
        	int current = pid.get(i);
        	int parent = ppid.get(i);
        	LinkedList<Integer> list = map.getOrDefault(parent, new LinkedList<Integer>());
        	list.add(current);
        	map.put(parent, list);
        }
        Queue<Integer> que = new LinkedList<>();
        que.offer(kill);
        while(que.size() > 0){
        	int Tokill = que.poll();
        	ans.add(Tokill);
        	List<Integer> ToKillList = map.get(Tokill);
        	if(ToKillList == null)continue;
        	for(int num: ToKillList){
        		que.offer(num);
        	}
        }
        return ans;
    }
}
