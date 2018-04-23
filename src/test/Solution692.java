package test;

import java.util.*;

public class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {
        Mycomparator com = new Mycomparator();
        PriorityQueue<Word> pq = new PriorityQueue<>(com);
        HashMap<String, Word> map = new HashMap<>();
        for(String word: words){
        	if(!map.keySet().contains(word)){
        		Word w = new Word(word);
        		map.put(word, w);
        	}
        	else{
        		map.get(word).freq += 1;
        	}
        }
        LinkedList<String> ans = new LinkedList<>();
        for(String word: map.keySet()){
        	pq.offer(map.get(word));
        	if(pq.size() == k + 1)pq.poll();
        }
        while(pq.size() > 0){
        	ans.add(pq.poll().str);
        }
        return ans;
    }
}
class Word{
	int freq;
	String str;
	public Word(String str){
		freq = 1;
		this.str = str;
	}
}
class Mycomparator implements Comparator<Word>{

	@Override
	public int compare(Word w1, Word w2) {
		// TODO Auto-generated method stub
		if(w1.freq > w2.freq){
			return 1;
		}
		else if(w1.freq < w2.freq){
			return -1;
		}
		else{
			if(w1.str.compareTo(w2.str) > 0)return 1;
			else if(w1.str.compareTo(w2.str) < 0)return -1;
			return 0;
		}
	}
	
}
