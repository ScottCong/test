package test;

public class Solution717 {
    public boolean isOneBitCharacter(int[] bits) {
        int index = 0;
        while(index < bits.length){
        	if(index == bits.length - 1)return true;
        	if(bits[index] == 1)index+= 2;
        	else index += 1;
        }
        return false;
    }
}
