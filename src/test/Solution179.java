package test;

import java.util.Arrays;
//给定一组数字，求把它们都转换成string然后组合成数字最大可能是多少
//关键：把两个数组合在一起，永远是组合结果大小来定比较器排序
public class Solution179 {
    public String largestNumber(int[] nums) {
        String[] StringNums = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
        	StringNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(StringNums, (s1, s2) ->{
        	return compareInts(s1,s2);
        });
        if(StringNums[StringNums.length - 1].charAt(0) == '0')return "0";
        String ans = "";
        for(String s: StringNums){
            ans = s + ans;
        }
        return ans;
        
    }
    public int compareInts(String num1, String num2){
    	String str1 = num1 + num2;
    	String str2 = num2 + num1;
    	return str1.compareTo(str2);
    }
}
