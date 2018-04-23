package test;

import java.util.*;
//new 4Sum, use hashmap record all the combination of first two Arrays and check if 
//any combination of last two Arrays can compensate that
public class Solution454 {
	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int a = 0; a < A.length; a++){
			for(int b = 0; b < B.length; b++){
				map.put(A[a] + B[b], map.getOrDefault(A[a] + B[b], 0) + 1);
				
			}
		}
		int count = 0;
		for(int c = 0; c < C.length; c++){
			for(int d = 0; d < D.length; d++){
				count += map.getOrDefault(-(C[c] + D[d]), 0);
			}
		}
		return count;
	}
//    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
//        int count = 0;
//        Arrays.sort(A);
//        Arrays.sort(B);
//        Arrays.sort(C);
//        Arrays.sort(D);
//        for(int indexA = 0; indexA < A.length; indexA++){
//        	//if(A[indexA] + B[0] + C[0] + D[0] > 0)break;
//        	//if(indexA >0 && A[indexA] == A[indexA - 1])continue;
//        	for(int indexB = 0; indexB < B.length; indexB++){
//        		//if(A[indexA] + B[indexB] + C[0] + D[0] > 0)break;
//        		//if(indexB > indexA + 1 && B[indexB] == B[indexB - 1])continue;
//        		int low = 0;
//        		int high = D.length - 1;
//        		int target = 0 - A[indexA] - B[indexB];
//        		while(low <= C.length - 1 && high >= 0){
//        			if(C[low] + D[high] == target){
//        				int first = 1;
//                        int second = 1;
//        				while(low < C.length - 1 && C[low] == C[low + 1]){
//        					first++;
//        					low++;
//        				}
//        				while(high >= 1 && D[high] == D[high - 1]){
//        					second++;
//        					high--;
//        				}
//                        count += first * second;
//        				low++;
//        				high--;
//        			}
//        			else{
//        				if(C[low] + D[high] > target)high--;
//        				else low++;
//        			}
//        		}
//                
//        	}
//        }
//        return count;
//    }
}
