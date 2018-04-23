package test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Solution808 {
    public double soupServings(int N) {

        double ans = serve(N,N);
        return ans;
    }
    public double serve(int A, int B){
    	//both are not empty 
    	double prob = 0;
    	//entry one
    	int A1 = A - 100;
    	int B1 = B;
    	if(A1 <= 0){
    		prob += 0.25;
    	}
    	else if(B1 > 0){
    		prob += 0.25 * serve(A1,B1);
    	}
    	//entry two
    	double prob2 = 0;
    	int A2 = A - 75;
    	int B2 = B - 25;
    	if(A2 <= 0){
    		if(B2 <= 0){
    			prob2 += 0.25 * 0.5;
    		}
    		else prob2 += 0.25;
    	}
    	else if(B2 > 0) prob2 = 0.25 * serve(A2, B2);
    	prob += prob2;
    	
    	//entry three
    	double prob3 = 0;
    	int A3 = A - 50;
    	int B3 = B - 50;
    	if(A3 <= 0){
    		if(B3 <= 0){
    			prob3 += 0.25 * 0.5;
    		}
    		else prob3 += 0.25;
    	}
    	else if(B3 > 0) prob3 = 0.25 * serve(A3, B3);
    	prob += prob3;
    	
    	//entry four
    	double prob4 = 0;
    	int A4 = A - 25;
    	int B4 = B - 75;
    	if(A4 <= 0){
    		if(B4 <= 0){
    			prob4 += 0.25 * 0.5;
    		}
    		else prob4 += 0.25;
    	}
    	else if(B4 > 0) prob4 = 0.25 * serve(A4, B4);
    	prob += prob4; 	
    	return prob;
    }
}
