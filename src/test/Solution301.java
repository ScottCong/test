package test;

import java.util.*;
//remove invalid parentheses
//用backtracking， 括号问题中前面的括号想要有效，必须保证（ 数量大于等于 ），一旦出现小于，前面的括号必须去掉一定量的）才能实现
//和后面如何改无关
//所以此题核心就是算出要去掉多少（ 和 ）。去掉） 是累加， 去掉（ 只可能在最后去掉。
public class Solution301 {
    public List<String> removeInvalidParentheses(String s) {
        int ltm = 0, rtm = 0;
        for(int i = 0; i < s.length(); i++){
        	if(s.charAt(i) == '(')ltm++;
        	else if(s.charAt(i) == ')'){
        		if(ltm > 0)ltm--;
        		else rtm++;
        	}
        }
        HashSet<String> set = new HashSet<>();
        remove(set, s, ltm, rtm, 0, "", 0, 0);
    	List<String> ans = new ArrayList<>(set);
    	return ans;
    }
    public void remove(HashSet<String> set, String s,int ltm,int rtm, int index, String subString, int lcount, int rcount){
    	if(rcount > lcount)return;
    	else if(ltm ==0 && rtm == 0 && index == s.length() && lcount == rcount){
    		set.add(subString);
    		return;
    	}
        else if(ltm < 0 || rtm <0 || index >= s.length())return;
    	if(s.charAt(index) == '('){
    		remove(set, s, ltm - 1, rtm, index + 1, subString, lcount, rcount);
    		remove(set, s, ltm, rtm, index + 1, subString + "(" , lcount + 1, rcount);
    	}
    	else if(s.charAt(index) == ')'){
    		remove(set, s, ltm, rtm - 1, index + 1, subString, lcount, rcount);
    		remove(set, s, ltm, rtm, index + 1, subString + ")", lcount, rcount + 1);
    	}
    	else remove(set, s, ltm, rtm, index + 1, subString + String.valueOf(s.charAt(index)), lcount, rcount);
    	
    }
}
