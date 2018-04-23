package test;

public class Solution365 {
    public boolean canMeasureWater(int x, int y, int z) {
    	if(x + y < z)return false;
        return z % calculateGCD(x, y) == 0;
    }
    public int calculateGCD(int a, int b){
    	if(a == 0 || b == 0)return 0;
    	if(a == 1 || b == 1)return 1;
    	while(b != 0){
    		int tmp = b;
    		b = a % b;
    		a = tmp;
    	}
    	return a;
    }
}
