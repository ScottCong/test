package test;

public class Solution796 {
    public boolean rotateString(String A, String B) {
        if(A.length() != B.length())return false;
    	if(A.length() == 0)return true;
        String mut = A + A;
        System.out.println(mut);
        return isSubset(mut, B);
    }
    
    public boolean isSubset(String longOne, String shortOne){
    	int pointerLong = 0;
    	for(int i = 0; i < longOne.length() - shortOne.length() + 1; i++){
    		if(longOne.charAt(i) == shortOne.charAt(0)){
    			pointerLong = i;
    			for(int j = 0; j <= shortOne.length(); j++){
    				if(j == shortOne.length())return true;
    				// System.out.print(j);
    				// System.out.print(longOne.charAt(pointerLong));
    				// System.out.println(shortOne.charAt(j));
    				if(longOne.charAt(pointerLong) != shortOne.charAt(j))break;
                    pointerLong++;
    			}
    		}
    	}
    	return false;
    }
}
