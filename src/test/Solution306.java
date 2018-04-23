package test;

public class Solution306 {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for(int i = 1; i <= (len - 1) / 2; i++){
        	if(num.charAt(0) == '0' && i > 1)return false;
        	long val1 = Long.valueOf(num.substring(0, i));
        	for(int j = i + 1; len-j>=j-i && len-j>=i; j++){
        		if(num.charAt(i) == '0' && j -i >= 2)break;
        		long val2 = Long.valueOf(num.substring(i, j));
                // System.out.println(val1);
                // System.out.println(val2);
        		if(isValid(val1,val2,num.substring(j)))return true;
        	}
        }
        return false;
    }
    public boolean isValid(long val1, long val2, String num){
    	long sum = val1 + val2;
        String s = String.valueOf(sum);
    	if(num.equals(""))return true;
    	if(num.startsWith(s))return isValid(val2,sum,num.substring(s.length()));
    	else return false;
    }
}
