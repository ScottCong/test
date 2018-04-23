package test;
//decoding from number to letter("12" = ab / l)
public class Solution91 {
    public int numDecodings(String s) {
        if(s.length() == 0)return 0;
        if(s.length() == 1)return 1;
        int[] store = new int[s.length()];
        int[] unattached = new int[s.length()];
        int[] attached = new int[s.length()];
        store[0] = 1;
        store[1] = (s.charAt(0) > '2' || (s.charAt(0) <= '2' && s.charAt(1) >'6'))? 1 : 2;
        if(s.charAt(0) == '0')return 0;
        attached[0] = 1;
        attached[1] = store[1] - 1;
        unattached[0]= 0;
        unattached[1] = store[1];
        for(int start = 2; start < s.length(); start++){
        	if(s.charAt(start) == '0' && (s.charAt(start - 1) == '0' || s.charAt(start - 1) >'2'))return 0;
        	if(s.charAt(start - 1) == '0' || s.charAt(start - 1) > '2' ||(s.charAt(start - 1) <= '2' && s.charAt(start) > '6'))attached[start] = 0;
        	else attached[start] = store[start - 2];
        	unattached[start] = store[start - 1];
        	store[start] = attached[start] + unattached[start];
        }
        return store[s.length() - 1];
        
        
    }
}
