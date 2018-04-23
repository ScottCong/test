package test;

import java.util.ArrayList;
import java.util.Arrays;

//super washing machine
//dp
public class Soultion517 {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        int[] sums = new int[machines.length];
        for(int i = 0; i < machines.length; i++){
        	sum += machines[i];
        	sums[i] = sum;
        }
        if(sum % machines.length != 0)return -1;
        int ave = sum / machines.length;
        int[] balance = new int[machines.length];
        balance[0] = machines[0];
        int rightFlow = 0;
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < machines.length; i++){
        	balance[i] = machines[i];
        	if(balance[i - 1] < ave){
        		int step = 0;
        		int leftSteps = 0;
        		for(int j = 0; j <= i; j++){
        			if(balance[j] != ave){
        				if(balance[i] >= ave - balance[j]){
        					step = Math.max(step, i - j +leftSteps + (ave - balance[j]) - 1);
        					leftSteps += ave - balance[j];
        					balance[i] -= (ave - balance[j]);
        					balance[j] = ave;
        					
        				}
        				else{
        					step = Math.max(step, i - j + leftSteps + (balance[j]) - 1);
        					balance[j] += balance[i];
        					balance[i] = 0;
        					break;
        				}
        			}
        		}
        		rightFlow = 0;
        		ans = Math.max(step, ans);
        	}
        	else{
        		rightFlow += balance[i - 1] - ave;
        		balance[i - 1] = ave;
        		balance[i] = balance[i] + balance[i - 1] - ave;
        		ans = Math.max(rightFlow, ans);
        	}
        }
        for(int i:balance)System.out.println(i + " ");
        return ans;
    }
}
