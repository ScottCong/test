package test;
//gas station
public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //gas cost has same length
    	//first: if car cannot go from A to B, then any station between A and B cannot go to B
    	//Second: if sum of balance is positive, there must be an answer
    	//this code can give the answer when the test case has only answer
    	int[] balance = new int[gas.length];
    	for(int i = 0; i < gas.length; i++){
    		balance[i] = gas[i] - cost[i];
    	}
    	int sum = 0;
    	for(int i = 0; i < gas.length; i++){
    		sum += balance[i];
    	}
    	if(sum < 0){
    		return -1;
    	}
    	int ans = 0;
    	int gasLeft = 0;
    	for(int i = 0; i < balance.length; i++){
    		gasLeft += balance[i];
    		if(gasLeft < 0){
    			ans = i + 1;
    			gasLeft = 0;
    		}
    	}
    	return ans;
    }
}