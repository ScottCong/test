package test;

public class Solution418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String NewSentence = String.join(" ", sentence) + " ";
        int count = 0;
        int senLen = NewSentence.length();
        for(int row = 0; row < rows; row++){
        	count += cols;
        	if(NewSentence.charAt(count % senLen) == ' '){
        		count ++;
        	}
        	else if(count > 0 && NewSentence.charAt((count - 1) % senLen) == ' ' )continue;
        	else{
        		while(count > 0 && NewSentence.charAt((count - 1) % senLen) != ' '){
        			count--;
        		}
        	}
        }
        return count / senLen;
    }
}
