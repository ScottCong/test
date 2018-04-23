package test;

import java.util.Stack;

public class Solution670 {
    public int maximumSwap(int num) {
    	int firstToSwap = Integer.MAX_VALUE;
    	int secondToSwap = 0;
        String s = Integer.toString(num);
        char[] digits = s.toCharArray();
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        for(int i = 1; i < digits.length; i++){
        	if(digits[i] <= digits[i - 1]){
        		stk.push(i);
        	}
        	else{
        		break;
        	}
        }
        if(stk.size() == digits.length)return num;
        int last = stk.peek();
        for(int i = last + 1; i < digits.length; i++){
        	while(stk.size() > 0 && digits[stk.peek()] < digits[i]){
        		if(last >= stk.peek() && firstToSwap > stk.peek())firstToSwap = stk.peek();
        		stk.pop();
        	}
        	stk.push(i);
        }
        int largest = Integer.MIN_VALUE;
        for(int i = last + 1; i < digits.length; i++){
        	if(digits[i] >= largest){
        		largest = digits[i];
        		secondToSwap = i;
        	}
        }
//        Stack<Integer> tmp = new Stack<>();
//        while(stk.size() > 0){
//        	tmp.push(stk.pop());
//        }
//        int count = tmp.size();
//        for(int i = 0; i < count;i++){
//        	if(i != tmp.peek()){
//        		firstToSwap = i;
//        		secondToSwap = tmp.pop();
//        		break;
//        	}
//        	tmp.pop();
//        }
        System.out.println(firstToSwap);
        System.out.println(secondToSwap);
        Double ans = num + ( digits[secondToSwap] - digits[firstToSwap]) * (Math.pow(10, digits.length - 1 - firstToSwap ) - Math.pow(10, digits.length - 1 - secondToSwap));
        return ans.intValue();
    }
}
