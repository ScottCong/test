package test;

import java.util.*;

public class Solution678 {
    public boolean checkValidString(String s) {
        char[] par = s.toCharArray();
        Stack<Integer> stk = new Stack<>();
        LinkedList<Integer> stars = new LinkedList<>();
        int counter = 0;
        for(int i = 0; i < par.length; i++){
        	if(par[i] == '*'){
        		counter += 1;
        		stars.add(i);
        	}
        	else if(par[i] == '(')stk.push(i);
        	else{
        		if(stk.size() > 0){
        			stk.pop();
        		}
        		else{
        			if(counter > 0){
        				counter -= 1;
        				stars.remove();
        			}
        			else return false;
        		}
        	}
        }
        if(stk.size() == 0)return true;
        Stack<Integer> newStk = new Stack<>();
        while(stk.size() > 0){
        	newStk.push(stk.pop());
        }
        //System.out.println(newStk);
        int toMatch = newStk.pop();
        //System.out.println(stars);
        
        for(int index: stars){
        	if(index > toMatch){
        		if(newStk.size() == 0)return true;
        		toMatch = newStk.pop();
        	}
        }
        return false;
    }
}
