package test;

import java.util.Stack;

// TLE
//int ans;
//public int findIntegers(int num) {
//    ans = 1;
//    find(num, 0);
//    return num;
//    
//}
//public void find(int target, int present){
//	int inc = 1;
//	while(present + inc <= target){
//		if(inc > 1){
//			if(((inc & present) ==0) && ((inc >>1 & present) == 0) && ((inc<<1 & present) == 0)){
//				ans ++;
//				find(target, present + inc);
//			}
//		}
//		else{
//			if(((inc & present) ==0) && ((inc<<1 & present) == 0)){
//				ans ++;
//				find(target, present + inc);		
//			}
//		}
//		inc *=2;
//	}
//}
public class Solution600 {
    public int findIntegers(int num) {
    int ans = 2;
    Stack<Integer> stk = new Stack<Integer>();
    stk.push(1);
    while(stk.size() > 0){
    	Stack<Integer> curStk = new Stack<Integer>();
    	while(stk.size() > 0){
    		int current = stk.pop();
    		//System.out.println(current);
    		if((current & 3) == 0 ||(current & 3) == 2){
    			if((current << 1) <= num ){
    				curStk.push(current<<1);
    				ans++;
    				}
        		if((current <<1) + 1 <= num){
        			curStk.push((current << 1) + 1);
        			ans ++;
        		}
    		}
    		else if((current & 3) == 1){
    			if((current << 1) <= num ){
    				curStk.push(current<<1);
    				ans++;
    			}
    		}
    	}
    	stk = curStk;
    }
    return ans;
   }
}
