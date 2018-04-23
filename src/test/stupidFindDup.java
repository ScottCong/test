package test;

import java.util.Arrays;
import java.util.HashSet;

public class stupidFindDup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "6;0,1,2,3,4,0";
		String[] arr = s.split(";");
		String[] anotherArr = arr[1].split(",");
		System.out.println(Arrays.asList(anotherArr));
		HashSet<Integer> set = new HashSet<>();
		for(String str: anotherArr){
			if(!set.add(Integer.parseInt(str))){
				System.out.println(str);
			}
		}
		
	}

}
