package test;

import java.util.HashMap;
import java.util.HashSet;

public class Solution351 {
	int[][] matrix;
	HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    public int numberOfPatterns(int m, int n) {
        matrix = new int[3][3];
        int x = 0;
        for(int i = 0; i < 3; i++){
        	for(int j = 0; j < 3; j++){
        		matrix[i][j] = x + 1;
        		x++;
        	}
        }
        
        for(int i = 0; i < 3; i++){
        	for(int j = 0; j < 3; j++){
        		HashSet<Integer> set = new HashSet<>();
        		for(int k = Math.max(0, i - 1); k <= Math.min(2, i + 1); k++){
        			for(int l = Math.max(0, j - 1); l <= Math.min(2,j + 1); l++){
        				if(k == i && l == j)continue;
        				set.add(matrix[k][l]);
        			}
        		}
        		map.put(matrix[i][j], set);
        	}
        }
        for(int i: map.keySet())
        {System.out.println(i);
        System.out.println(map.get(i).toString());}
        
        return 1;
    }
    public HashSet<Integer> avaliableNums(){
    	return null;
    }
}
