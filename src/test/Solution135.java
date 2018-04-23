package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//Candy
public class Solution135 {
    public int candy(int[] ratings) {
        if(ratings.length == 1){
            return 1;
        }
        if(ratings.length == 0){
            return 0;
        }
        int[] candys = new int[ratings.length];
        Map<Integer,LinkedList<Integer>> rate = new HashMap<>(); 
        for(int i = 0; i < ratings.length; i++){
        	rate.put(ratings[i], new LinkedList<>());
        	int[] a = {1,2,3,4,5};
        }
        for(int i = 0; i < ratings.length; i++){
        	rate.get(ratings[i]).add(i);
        }
        int[] oldratings = new int[ratings.length];
        for(int i = 0; i < ratings.length; i++){
            oldratings[i] = ratings[i];
        }
        Arrays.sort(ratings);
        int prev = Integer.MIN_VALUE;
        for(int target: ratings){
            //System.out.println(target);
        	if(prev == target){
        		continue;
        	}
        	prev = target;
        	LinkedList<Integer> current = rate.get(target);
        	for(int index: current){
        	    //System.out.println(index);
        		if(index ==0){
        			if(oldratings[1] < oldratings[0]){
        				candys[0] = candys[1] + 1;
        			}
        			else{
        				candys[0] = 1;
        			}
        		}
        		
        		else if(index == ratings.length - 1){
        			if(oldratings[ratings.length - 1] > oldratings[ratings.length - 2]){
        				candys[ratings.length - 1] = candys[ratings.length - 2] + 1;
        			}
        			else{
        				candys[ratings.length - 1] = 1;
        			}
        		}
        		
        		else{
        			if(oldratings[index] <= oldratings[index - 1] && oldratings[index] <= oldratings[index + 1]){
        				candys[index] = 1;
        			}
        			else if(oldratings[index] > oldratings[index - 1] && oldratings[index] > oldratings[index + 1]){
        				candys[index] = Math.max(candys[index - 1], candys[index + 1]) + 1;
        			}
        			else{
        				if(oldratings[index - 1] >  oldratings[index + 1]){
        					candys[index] = candys[index + 1] + 1;
        				}
        				else{
        					candys[index] = candys[index - 1] + 1;
        				}
        				// if(index == 11){
        				//     System.out.println(oldratings[index - 1]);
        				//     System.out.println(oldratings[index + 1]);
        				//     System.out.println(candys[index + 1]);
        				//     System.out.println(candys[index - 1]);
        				// }
        			}
        		}
        	}

        	}
    	int sum = 0;
    	for(int a : candys){
    	    //System.out.println(a);
    		sum += a;
        }
    	return sum;
    }
}