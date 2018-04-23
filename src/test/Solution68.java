package test;

import java.util.*;

public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> ans = new LinkedList<>();
        Queue<Integer> lengths = new LinkedList<>();
        Queue<Integer> indexs = new LinkedList<>();
        for(int i = 0; i < words.length; i++){
        	lengths.offer(words[i].length());
        	indexs.offer(i);
        }
        int curLen_space = 0;
        int curLen_nospace = 0;
        Queue<Integer> tmp = new LinkedList<>();
        while(lengths.size() > 0){
        	tmp = new LinkedList<>();
        	
        	while(curLen_space + lengths.peek() <= maxWidth){
        		curLen_space += lengths.peek() + 1;
        		curLen_nospace += lengths.peek();
        		tmp.offer(indexs.poll());
        		lengths.poll();
        		if(lengths.size() == 0)break;
        	}
            //System.out.println(tmp.size());
        	if(lengths.size() == 0)break;
            if(tmp.size() == 1){
                String s = words[tmp.peek()];
                for(int i = s.length() ; i < maxWidth; i++){
                    s += " ";
                }
                ans.add(s);
                curLen_space = 0;
                curLen_nospace = 0;
            }
            else{        	
                int space = (maxWidth - curLen_nospace) / (tmp.size() - 1);
                int left = (maxWidth - curLen_nospace) % (tmp.size() - 1);
                // System.out.println(space);
                // System.out.println(left);
                StringBuilder sb = new StringBuilder();
                while(tmp.size() > 1){
                    sb.append(words[tmp.poll()]);
                    int spaces = (left > 0)? space + 1: space;
                    for(int i = 0; i < spaces; i++){
                        sb.append(" ");
                    }
                    left -= 1;
                }
                sb.append(words[tmp.poll()]);
                ans.add(sb.toString());

                curLen_space = 0;
                curLen_nospace = 0;
            }

        }
        if(tmp.size() > 0){
        	String sb = words[tmp.poll()];
        	int len = sb.length();
        	while(tmp.size() > 0){
                sb += " ";
        		len += words[tmp.peek()].length() + 1;
        		sb += words[tmp.poll()];
        	}
        	for(int i = len; i < maxWidth; i++){
        		sb += " ";
        	}
        	ans.add(sb);
        }
        return ans;
    }
}
