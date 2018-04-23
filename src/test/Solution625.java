package test;

import java.util.LinkedList;

public class Solution625 {
    public int smallestFactorization(int a) {
        if(a < 10)return a + 10;
        LinkedList<Integer> lst = new LinkedList<>();
        while(a >= 10){
        	for(int i = 9; i <= 1; i--){
        		if(a % i == 0){
        			lst.add(i);
        			a = a / i;
        			break;
        		}
        		if(i == 1 && a >= 10)return 0;
        	}
        }
        int ans = 0;
        for(int i = lst.size() - 1; i >= 0; i++){
        	ans = ans * 10 + lst.get(i);
        }
        return ans;
    }
}
