package test;
//动态规划，每个字母每个字母递推，看哪个字母之前的所有字母都符合字典标准，
//如果有的话就把这个字母到现在查的字母之间的短词和字典比较,如果符合现在找的字母也符合
//dic=[a,bc,da] s = "bcdaa" ==> [0(no b),1(yes bc),0(yes bc but no d),1(from bc search da, yes),1] 

import java.util.List;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
    	boolean[] ans = new boolean[s.length() + 1];
    	//ans[0] = true;
    	for(int cur = 1; cur <= s.length() ;cur++){
    		if(wordDict.contains(s.substring(0, cur))){
    			ans[cur] = true;
    		}
    		else{
    			for(int begin = 0; begin <= cur; begin++){
    				if(ans[begin]){
    					if(wordDict.contains(s.substring(begin, cur+1))){
    						ans[cur] = true;
    						break;
    					}
    				}
    			}
    		}
    	}
        return ans[s.length()];
    }
}