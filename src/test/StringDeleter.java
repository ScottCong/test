package test;

import java.util.Stack;



public class StringDeleter {
	
	public static void main(String[] args){
		StringDeleter sd = new StringDeleter();
		String s = "bacbacbbcab";
		s = sd.ClearString(s);
		System.out.print(s);
	}
	
	
	public String ClearString(String s){
		Stack<Character> stk = new Stack<>();
		boolean marked = false;
		for(char c: s.toCharArray()){
			if(stk.size() == 0){
				stk.push(new Character(c));
			}
			else{
				if(stk.peek().equals(c)){
					marked = true;
				}
				else{
					if(!marked)stk.push(c);
					else{
						stk.pop();
						if(stk.size() == 0){
							stk.push(c);
							marked = false;
						}
						else if(stk.peek().equals(c)){
							marked = true;
						}
						else{
							stk.push(c);
							marked = false;
						}
					}
				}
				
			}
		}
		if(marked)stk.pop();
		Stack<Character> newStk = new Stack<>();
		while(stk.size() > 0)newStk.push(stk.pop());
		StringBuilder sb = new StringBuilder();
		while(newStk.size() > 0)sb.append(newStk.pop());
		String ans = sb.toString();
		return ans;
	}
}
