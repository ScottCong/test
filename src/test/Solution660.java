package test;

import java.util.*;

public class Solution660 {
    public int newInteger(int n) {
    	StringBuilder sb = new StringBuilder();
       while(n > 9){
    	   sb.append(String.valueOf(n % 9));
    	   n /= 9;
       }
       sb.reverse();
       String ans = sb.toString();
       if(n != 0)ans = String.valueOf(n) + ans;
       return Integer.valueOf(ans);
    }
}
