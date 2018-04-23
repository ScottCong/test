package test;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8Test {

	public static void main(String[] args){
		HashMap<Integer,Integer> map = new HashMap<>();
		Integer[] arr = new Integer[]{1,2,3,4,5,6,1,2,3,7,8,9};
		List<Integer> lst = Arrays.asList(arr);
		List<Integer> lst2 = new ArrayList<>();
		lst = lst.stream().map(n -> {
			map.put(n, map.getOrDefault(n, 0) + 1);
			return n;
		}).filter(n -> map.get(n) == 1).collect(Collectors.toList());
		
		lst = lst.stream().map(n -> {
			return n;
		}).filter((n -> {
			return n > 5?true:false;
		})).collect(Collectors.toList());
		System.out.print(lst);
	}
	
}
