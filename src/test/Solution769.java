package test;

import java.util.Arrays;
import java.util.HashMap;

//greedy
public class Solution769 {
    public int maxChunksToSorted(int[] arr) {
        
        HashMap<Integer, Integer> indexToNumber = new HashMap<>();
        HashMap<Integer, Integer> numberToIndex = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
        	indexToNumber.put(i, arr[i]);
        	numberToIndex.put(arr[i], i);
        }
        
        int pointer1 = 0;
        int pointer2 = 0;
        int chunks = 0;
        while(pointer1 < arr.length){
        	pointer2 = numberToIndex.get(pointer1);
        	for(int i = pointer1; i <= pointer2; i++){
        		pointer2 = Math.max(pointer2, indexToNumber.get(i));
        	}
        	pointer2++;
        	pointer1 = pointer2;
        	chunks++;
        }
        return chunks;
        
    }
}
