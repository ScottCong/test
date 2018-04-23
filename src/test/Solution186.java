package test;

public class Solution186 {
    public void reverseWords(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while(end > start){
        	char tmp = s[start];
        	s[start] = s[end];
        	s[end] = tmp;
        	start++;
        	end--;
        }
        start = 0;
        end = 0;
        while(end <= s.length){
        	if(end == s.length || s[end] == ' '){
        		int tmpStart = start;
        		int tmpEnd = end - 1;
        		while(tmpEnd > tmpStart){
                	char tmp = s[tmpStart];
                	s[tmpStart] = s[tmpEnd];
                	s[tmpEnd] = tmp;
                	tmpStart++;
                	tmpEnd--;
        		}
        		if(end == s.length)return;
        		end++;
        		start = end;
        	}
        	else{
        		end++;
        	}
        }
        return;
    }
}
