package test;

public class Solution657 {
    public boolean judgeCircle(String moves) {
        int ver = 0;
        int hor = 0;
        for(char c: moves.toCharArray()){
        	switch(c){
        		case 'U':
        			ver++;
        			break;
        		case 'D':
        			ver--;
        			break;
        		case 'L':
        			hor--;
        			break;
        		case 'R':
        			hor++;
        			break;
        		default:
        			System.out.print("?");
        		
        	}
        		
        }
        
        return (ver == 0 && hor == 0);
    }
}
