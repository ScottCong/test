package test;

import java.util.LinkedList;

public class Solution60 {
    public String getPermutation(int n, int k) {
    	LinkedList<String> numbers = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int[] PermutationNum = new int[n];
        int PerNum = 1;
        String ans;
        for(int i = 1; i <= n; i++){
        	numbers.add(String.valueOf(i));
        }
        for(int i = 1; i<=n; i++){
        	PerNum *= i;
        	PermutationNum[i - 1] = PerNum;
        	//System.out.println(PerNum);
        }
        k = k -1;
        while(n > 1){
        	//System.out.println(numbers);
        	int index = (k ) / PermutationNum[n - 2];
//        	System.out.println("k" + k);
//        	System.out.println("n" + n);
//        	System.out.println(index);
        	sb.append(numbers.get(index));
        	numbers.remove(index);
        	k = k % PermutationNum[n - 2];
        	n = n - 1;
        }
        sb.append(numbers.get(0));
        ans = sb.toString();
        return ans;
        
    }
}
