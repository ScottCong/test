package test;

import java.util.Stack;

public class Solution331 {
	String[] nodes;
	Stack<String> strings = new Stack<>();
    public boolean isValidSerialization(String preorder) {
        nodes = preorder.split(",");
        for(int i = nodes.length - 1; i >= 0; i--){
        	strings.push(nodes[i]);
        }
        boolean ans = assign();
        if(ans && strings.size() == 0)return true;
        return false;
    }
    public boolean assign(){
    	if(strings.size() == 0)return false;
    	String cur = strings.pop();
    	if(cur.equals("#"))return true;
    	boolean left = assign();
    	boolean right = assign();
    	return left&&right;
    }
}
