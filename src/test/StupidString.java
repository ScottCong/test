package test;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StupidString {

	public static void main(String[] args){
		Date date = new Date();
		Long time = System.currentTimeMillis();
		time -= 1000 * 60 * 60;
		date.setTime(time);
		System.out.println(date);
		
		//FIN-4389-XQVH

		
//		int ans = 0;
//		String s = "{\"menu\":{\"header\":\"menu\",\"items\":[{\"id\":27},{\"id\":5,\"label\":\"Label5\"},null,{\"id\":93},{\"id\":85},{\"id\":54},null,{\"id\":46,\"label\":\"Label46\"},{\"id\":27},{\"id\":5,\"label\":\"Label5\"}]}}";
//		String pat = "\"id\":[0-9]+,\"label\":\"Label.*?\"";
//		Pattern pattern = Pattern.compile(pat);
//		Matcher matcher = pattern.matcher(s);
//
//		LinkedList<String> lst = new LinkedList<>();
//		while(matcher.find()){
//			int str = matcher.start();
//			int end = matcher.end();
//			s.substring(str, end);
//			lst.add(matcher.group());
//			}
//		System.out.println(lst);
//		for(String str: lst){
//			
//			ans += extractInt(str);
//		}
//		System.out.println(ans);
//		System.out.println("end");
//		String[] hck = {"julia@hackerrank.com","julia_@hackerrank.com","julia_0@hackerrank.com","julia0_@hackerrank.com","julia@google.com"};
//		pat = "[a-z]{1,6}_?[0-9]{0,4}@hackerrank.com";
//		Pattern ptn = Pattern.compile(pat);
//		for(String str:hck){
//			matcher = ptn.matcher(str);
//			System.out.println(matcher.find());
//		}
		
	}
	public static int extractInt(String s){
		int ans = 0;
		for(char c:s.toCharArray()){
			
			if(c == ',')break;
			if(c >= '0' && c <='9'){
				ans *= 10;
				ans += c - '0';
			}
		}
		return ans;
	}
		
	
	
	//System.out.println(matcher.group());
//	System.out.println(matcher.find());
//	System.out.println(matcher.start());
//	System.out.println(matcher.end());
//	System.out.println(matcher.find());
//	System.out.println(matcher.start());
//	System.out.println(matcher.end());
//		s = s.substring(s.indexOf("[") + 1,s.indexOf("]"));
//		String[] lst = s.split("},");
//		System.out.println(s);
//		System.out.println(Arrays.asList(lst));
//		LinkedList<String[]> split = new LinkedList<>();
//		for(String str: lst){
//			if(str.charAt(0) == '{'){
//				String[] cur = str.split(", ");
//				System.out.println(Arrays.asList(cur));
//				if(cur.length >= 2)split.add(cur);
//			}
//		}
//		System.out.println(Arrays.asList(split));
//	}
}

class a{}
