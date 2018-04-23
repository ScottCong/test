package test;

import java.util.LinkedList;

public class Solution321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    	if(nums1.length + nums2.length < k)return new int[k];
    	LinkedList<String> candidate = new LinkedList<>();
    	for(int i = 0; i <=k; i++){
    		String num1 = maxNumberWithKDigit(nums1, i);
    		String num2 = maxNumberWithKDigit(nums2, k - i);
    		if(num1.length() + num2.length() != k)continue;
    		candidate.add(createMaxNumber(num1,num2));
    	}
    	String max = "";
    	for(String num: candidate){
    		if(max.compareTo(num) < 0)max = num;
    	}
    	String s = String.valueOf(max);
    	char[] strs = s.toCharArray();
    	int[] ans = new int[strs.length];
    	for(int i = 0; i< strs.length; i++){
    		ans[i] = Integer.valueOf(strs[i]) - 48;
    	}
    	return ans;
    }
    public String maxNumberWithKDigit(int[] nums, int k){
    	LinkedList<Integer> lst = new LinkedList<>();
    	if(k == 0)return "";
    	if(nums.length < k)return "";
    	int pointer = 0;
    	while(k > 0){
    		int max = 0;
    		for(int i = pointer; i < nums.length - k + 1; i++){
    			if(nums[i] > max){
    				pointer = i;
    				max = nums[i];
    			}
    		}
            pointer++;
            //System.out.println(max);
    		lst.add(max);
            k--;
    	}
    	String ans = "";
    	for(int i =0; i < lst.size(); i++){
            //System.out.println(ans);
    		ans = ans + String.valueOf(lst.get(i));
    	}
    	return ans;
    }
    public String createMaxNumber(String num1, String num2){
    	String s1 = String.valueOf(num1);
    	String s2 = String.valueOf(num2);
    	int index1 = 0;
    	int index2 = 0;
    	StringBuilder sb = new StringBuilder();
    	while(index1 < s1.length() && index2 < s2.length()){
    		if(s1.charAt(index1) > s2.charAt(index2)){
    			sb.append(s1.charAt(index1));
    			index1++;
    		}
    		else if(s1.charAt(index1) < s2.charAt(index2)){
    			sb.append(s2.charAt(index2));
    			index2 ++;
    		}
    		else{
    			if(s1.substring(index1 + 1).compareTo(s2.substring(index2 + 1)) >= 0){
	    			sb.append(s1.charAt(index1));
	    			index1++;
    			}
    			else{
        			sb.append(s2.charAt(index2));
        			index2 ++;
    			}
    			
    		}
    	}
    	if(index1 <= s1.length() - 1){
    		while(index1 <= s1.length() - 1){
    			sb.append(s1.charAt(index1));
    			index1++;
    		}
    	}
    	else if(index2 <= s2.length() - 1){
    		while(index2 <= s2.length() - 1){
    			sb.append(s2.charAt(index2));
    			index2++;
    		}
    	}
    	String max = sb.toString();
    	return max;
    }

}
