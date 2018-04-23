package test;

import java.util.HashSet;

public class Solution277 {
    public int findCelebrity(int n) {
    	HashSet<Integer> Celebrity = new HashSet<>();
        for(int i = 0; i < n; i++){
        	Celebrity.add(i);
        }
        for(int asked = 0; asked < n; asked++){
        	for(int target = 0; target < n; target++){
        		
        		if(asked == target)continue;
        		if(knows(asked, target)){
        			Celebrity.remove(asked);
        		}
        		else{
        			Celebrity.remove(target);
        		}
        		
        	}
        	if(Celebrity.size() == 0)return -1;
        }
        
        if(Celebrity.size() == 0)return -1;
        else{
        	if(Celebrity.size() > 1)System.out.println("??");
        	for(int ans : Celebrity)return ans;
        }
        return -1;
    }
    public boolean knows(int a,int b){
    	return true;
    }
}
