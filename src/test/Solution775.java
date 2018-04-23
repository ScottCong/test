package test;

//Global and Local Inversions
//compare two kinds of inversions
//check i+2 instead calculate all the inversions
public class Solution775 {
    public boolean isIdealPermutation(int[] A) {
    	if(A.length <= 1)return true;
        int max = A[0];
        for(int i = 2; i < A.length; i++){
        	if(A[i] < max)return false;
        	max = Math.max(A[i - 1], max);
        }
        return true;
    }
}
