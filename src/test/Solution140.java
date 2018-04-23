package test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dic = new HashSet<>();
        List<String> ans = new LinkedList<>();
        LinkedList<HashSet<Integer>> track = new LinkedList<>();
        boolean[] isSubString = new boolean[s.length() + 1];
        isSubString[0] = true;
        for(String str: wordDict){
        	dic.add(str);
        }
        for(int i = 0; i < s.length() + 1; i++){
        	track.add(new HashSet<Integer>());
        }
        if(s.length() == 0)return ans;
        for(int i = 1; i < s.length() + 1; i++){
        	for(int j = 0; j < i; j ++){
        		if(dic.contains(s.substring(j, i)) && isSubString[j]){
        			isSubString[i] = true;
        			track.get(i).add(j);
        		}
        	}
        }
        if(!isSubString[s.length()])return ans;
        ans = combin(track, s.length(), s);
        return ans;
    }
    public List<String> combin(LinkedList<HashSet<Integer>> track,Integer index, String s){
    	LinkedList<String> ans = new LinkedList<>();
    	if(index == 0){
    		ans.add("");
    		return ans;
    	}
    	for(int i: track.get(index)){
    		for(String str: combin(track, i, s)){
    			if(str == "")ans.add(s.substring(i,index));
    			else ans.add(str + " " + s.substring(i, index));
    		}
    	}
    	return ans;
    }
}
