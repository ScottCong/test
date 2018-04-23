package test;

public class Solution686 {
    public int repeatedStringMatch(String A, String B) {
        int times = (B.length() / A.length());
        String target = "";
        for(int i = 0; i < times; i++){
        	target += A;
        }
        for(int i = 0; i <= (B.length() - A.length()); i++){
        	if(target.substring(i, i + B.length()).equals(B)){
        		return times;
        		
        	}
        }
        target += A;
        for(int i = 0; i <= (B.length() - A.length()); i++){
        	if(target.substring(i, i + B.length()).equals(B)){
        		return times;
        		
        	}
        }
        return -1;
    }
}
