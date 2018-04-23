package test;
//Given a list of words (without duplicates), please write a program 
//that returns all concatenated words in the given list of words.
//
//A concatenated word is defined as a string that is comprised entirely of at least two shorter words 
//in the given array.
//
//Example:
//Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
//
//Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
//
//Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
// "dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
//"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".



// use wordbreak
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> dictionary = new HashSet<>();
        LinkedList<String> ans = new LinkedList<>();
        newComparator com = new newComparator();
        Arrays.sort(words,com);
        if(words.length <= 1)return ans;
        dictionary.add(words[0]);
        for(int i = 1; i < words.length; i ++){
     	   if(wordBreak(words[i],dictionary)){
     		   ans.add(words[i]);
     	   }
     	   else dictionary.add(words[i]);
        }
        return ans;
     }
     public boolean wordBreak(String s, HashSet<String> dictionary){
     	boolean[] LookUp = new boolean[s.length()];
     	for(int i = 0; i < s.length(); i++){
     		if(dictionary.contains(s.substring(0, i + 1))){
     			LookUp[i] = true;
     		}
     		else{
     			for(int j = 0; j <= i; j++){
     				if(LookUp[j] && dictionary.contains(s.substring(j + 1, i+1))){
     				    LookUp[i] = true;
     				    break;
     				}
     			}
     		}
     	}
     	return LookUp[s.length() - 1];
     }
 
 }
    

class newComparator implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		// TODO Auto-generated method stub
		if(s1.length() > s2.length())return 1;
		else if(s1.length() < s2.length())return -1;
		else return 0;
	}
	
}
