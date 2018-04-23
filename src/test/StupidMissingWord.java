package test;

import java.util.LinkedList;
import java.util.List;

public class StupidMissingWord {

	static public List<String> missingWord(String s, String t){
		//s = I am using HackerRank to improve programming
		//t = am HackerRank to improve
		String[] arrS = s.split(" ");
		String[] arrT = t.split(" ");
		int indS = 0;
		int indT = 0;
		List<String> ans = new LinkedList<>();
		while(indT < arrT.length){
			if(arrS[indS].equals(arrT[indT])){
				indS++;
				indT++;
				continue;
			}
			else{
				ans.add(arrS[indS]);
				System.out.println(arrS[indS]);
				indS++;
			}
		}
		for(int i = indS; i < arrS.length;i++){
			ans.add(arrS[indS]);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "I am using HackerRank to improve programming";
		String t = "am HackerRank to improve";
		System.out.print(missingWord(s,t));
	}

}
