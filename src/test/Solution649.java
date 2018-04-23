package test;

import java.util.*;

public class Solution649 {
    public String predictPartyVictory(String senate) {
        Queue<Integer> R = new LinkedList<>();
        Queue<Integer> D = new LinkedList<>();
        int radiant = 0;
        int dire = 0;
        for(int i = 0 ; i < senate.length();i++){
        	char c = senate.charAt(i); 
        	if(c == 'R'){
        		R.offer(i);
        		radiant += 1;
        	}
        	else if(c == 'D'){
        		D.offer(i);
        		dire += 1;
        	}
        }
        while(radiant > 0 && dire > 0){
        	Queue<Integer> RN = new LinkedList<>();
        	Queue<Integer> DN = new LinkedList<>();
        	while(R.size() > 0 && D.size() > 0){
        		if(R.peek() < D.peek()){
        			int next = R.poll();
        			RN.offer(next);
        			D.poll();
        			dire--;
        			if(dire == 0)return "Radiant";
        		}
        		else{
        			int next = D.poll();
        			DN.offer(next);
        			R.poll();
        			radiant--;
        			if(radiant == 0)return "Dire";
        		}
        	}
        	if(R.size() == 0){
        		while(D.size() > 0){
        			DN.offer(D.poll());
        			RN.poll();
        			radiant--;
        			if(radiant == 0)return "Dire";
        		}
        	}
        	else{
        		while(R.size() > 0){
        			RN.offer(R.poll());
        			DN.poll();
        			dire--;
        			if(dire == 0)return "Radiant";
        		}
        	}
        	R = RN;
        	D = DN;
        }
        if(R.size() == 0)return "Dire";
        else return "Radiant";	
    }
}
