package test;

public class Solution504 {
    public String convertToBase7(int num) {
    	boolean isMin = false;
    	StringBuilder sb = new StringBuilder();
    	if(num < 0){
    		num = -num;
    		isMin = true;
    	}
        while(num != 0){
        	int next = num % 7;
        	num = num / 7;
        	sb.append(Integer.toString(next));
        }
        String ans = sb.reverse().toString();
        if(isMin){
        	ans = "-" + ans;
        }
        return ans;
    }
}