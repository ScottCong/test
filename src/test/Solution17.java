package test;

import java.util.*;

public class Solution17 {
    public List<String> letterCombinations(String digits) {
        String[] StringMap = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv","wxyz"};
        LinkedList<String> que = new LinkedList<>();
        LinkedList<String> ans = new LinkedList<>(); 
        if(digits == null || digits.length() == 0)return ans;
        int num = digits.charAt(0) - '0';
        for(char c: StringMap[num].toCharArray()){
        	que.add(String.valueOf(c));
        }
        for(int i = 1; i < digits.length(); i++){
        	LinkedList<String> tmp = new LinkedList<>();
        	String s = StringMap[digits.charAt(i) - '0'];
        	for(char c: s.toCharArray()){
        		for(String str: que){
        			tmp.add(str + String.valueOf(c));
        		}
        	}
        	que = tmp;
        }
        return que;
    }
}
