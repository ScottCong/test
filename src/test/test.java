package test;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;  
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import test.Solution398;
import test.TreeNode;
//class NewMyComparator implements Comparator<Integer[]>{
//	public int compare(Integer[] o1, Integer[] o2){
//		if(o1[1] > o2[1]){
//			return 1;
//		}
//		else if(o1[1] < o2[1]){
//			return -1;
//		}
//		else{
//			return 0;
//		}
//		
//	}
//}
//class MyComparator implements Comparator<Integer>{
//	//如果n1小于n2，我们就返回正值，如果n1大于n2我们就返回负值，//这样颠倒一下，就可以实现反向排序了
//
//
//	@Override
//	public int compare(Integer o1, Integer o2) {
//		// TODO Auto-generated method stub
//		if(o1 > o2){
//			return -1;
//		}
//		else if(o1 < o2){
//			return 1;
//		}
//		else{
//			return 0;
//		}
//	}
//}
public class test {
	public static void main(String args[]){
//		Integer[][] a = {{1,4}, {2,3}, {3,7}, {4,1}};
//		int len = a.length;
//		NewMyComparator Com = new NewMyComparator();
//		Arrays.sort(a,Com);
//		for(int i = 0; i < len; i++){
//		System.out.print(a[i][0]);
		
//		}
//		Stack<Integer> stk = new Stack();
//		TreeNode tn = null;
//		stk.push(0);
//		stk.push(null);
//		System.out.println(stk.pop());
//		System.out.println(stk.pop());

//		String s = "abcde";
//		System.out.println(s.subSequence(0, 1));
//		//subsequence中的index其实指的是string的中缝位置，0指的就是最前面的位置，1就是a后面的空隙
//		LinkedList a = new LinkedList();
//		LinkedList b = new LinkedList();
//		LinkedList c = new LinkedList();
//		a.add(b);
//		a.add(c);
//		b.add(1);
//		Object ex = a.get(0);
//		((LinkedList) ex).add(2);
//		System.out.println(a.get(0).toString());
//		//放在LinkedList中的元素用get获取后，返回的不是克隆，而是原数据，在其他地方做了reference后，修改reference元数据也会变
//		int a = 5;
//		int b = (int)(Math.random() * a);
//		System.out.println(b);
//		int[] tar = {1,2,3,3,3};
//		Solution398 sol = new Solution398(tar);
//		int target = sol.pick(3);
//		System.out.print(target);
//		String[][] test = {{"WWB"},{"WBW"},{"BWW"}};
//		Map<Integer, LinkedList> map = new HashMap<>();
//		LinkedList lst = new LinkedList<>();
//		lst.add(1);
//		map.put(1, lst);
//		System.out.println(map.get(1).size());
//		map.get(1).add(2);
//		System.out.println(map.get(1).size());
//		int[] arr = {1,2,3,4,1,2,3,4,5,6,7};
//		HashSet<Integer> set = new HashSet<>();
//		for(int i: arr){
//			set.add(i);
//		}
//		Object[] newarr = set.toArray();
//		for(Object i: newarr){
//			System.out.println(i);
//		}
//		char a = 'a';
//		int b = a + a;
//		System.out.print(b);
//		Singleton s = Singleton.getInstance();
//		s.counter++;
//		System.out.print(s.counter);
//		Singleton b = Singleton.getInstance();
//		b.counter++;
//		System.out.print(b.counter);
//		System.out.print(s.counter);
//		EOrderTyper type = EOrderTyper.VDDmoney;
//		System.out.print(type.getDescription());
//		  LinkedList<Integer> oldL = new LinkedList<Integer>();
//		  oldL.add(1);
//		  oldL.add(2);
//		  System.out.println(oldL);
//		  
//		  LinkedList<Integer> newL = new LinkedList<Integer>(oldL);
//		  newL.add(3);
//		  System.out.println("old list : " + oldL);
//		  System.out.println("new list : " + newL);
//		String a = "asd";
//		int b = a.compareTo("ssd");
//		System.out.println(b);
//		float f = (float) 3.4;
//		System.out.println(f);
//		int[] c = {1,2,3,4};
//        String s1 = "Programming";
//        String s2 = new String("Programming");
//        String s3 = "Program" + "ming";
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        System.out.println(s1 == s1.intern());
//        Map map = new HashMap<>();
//		LRUCache cache = new LRUCache(2);
//		cache.put(1, 1);
//		cache.put(2, 2);
//		cache.put(3, 3);
//        
//		char a = '6';
//		String b = "0";
//		
//Solution60 sol = new Solution60();
//System.out.println(sol.getPermutation(4, 2));
//		int[] a = {1,2,3};
//		int[] b = a;
//		a[0] = 5;
//		LinkedList<Integer> lst = new LinkedList<>();
//		lst.add(1);
//		lst.add(2);
//		System.out.println(lst);
//		Solution403 sol = new Solution403();
//		System.out.println(sol.canCross(t));
//		
//		
//        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
//        HashSet<Integer> init = new HashSet<>();
//        init.add(1);
//        map.put(0, init);
//        map.get(0).add(2);
//        map.get(0).add(3);
//        System.out.println(map.get(0).size());
//		String[] a = {"ab","cde"};
//		Solution472 sol = new Solution472();
//		sol.findAllConcatenatedWordsInADict(a);
//		String a = "a";
//		String b = "b" + a;
//		String c = "c" + a;
//		System.out.print(a+b+c);
//		int[] a= {0};
//		LinkedList<int[]> lst = new LinkedList<>();
//		lst.add(a);
//		a[0] = 1;
//		lst.add(a);
//		a[0] = 2;
//		lst.add(a);
//		for(int[] b: lst){
//			System.out.println(b[0]);
//		}
//		int a = 2147483647;
//		System.out.println(a + 1);
//		String a= "00";
//		long b =Long.valueOf(a);
//		System.out.print(b);
//		Solution321 sol = new Solution321();
//		int[] nums1 = {9,4,5,3,8};
//		int[] nums2 = {1,0,8};
//		sol.maxNumber(nums1, nums2, 4);
//		String a = "the sky is blue";
//		char[] c = a.toCharArray();
//		sol.reverseWords(c);
//		a = c.toString();
//		for(char cha:c)System.out.print(cha);
//		TreeNode node1 = null;
//		TreeNode node2 = null;
//		TreeNode node3 = null;
//		Queue<TreeNode> que = new LinkedList<>();
//		que.offer(node1);
//		que.offer(node2);
//		que.offer(node3);
//		System.out.println(que.size());
//		while(que.size() > 0){
//			TreeNode node = que.poll();
//			System.out.print(node == null);
//		}
//		HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
//		LinkedList<Integer> lst1 = new LinkedList<>();
//		map.put(1, lst1);
//		map.get(1);
//		map.get(0);
//		int a = '6' - '0';
//		System.out.println(a);
//		Solution320 sol = new Solution320();
//		sol.generateAbbreviations("aa");
//        String s1 = "Programming";
//        String s2 = new String("Programming");
//        String s3 = "Program" + "ming";
//        
//        System.out.println(s1.equals(s2));
//        System.out.println(s1 == s3);
//        System.out.println(s1 == s1.intern());
//		  System.out.println(TestClass.c);
//		  TestClass.c = 2;
//		  TestClass t = new TestClass();
//		  t.c = 3;
//		  System.out.println(TestClass.c);
//		  System.out.println(t.c);
//		Solution646 s = new Solution646();
//		int a = (new Double(Math.pow(2, 3))).intValue();
//		String str = "12";
//		System.out.println(str.charAt(0));
//		ArrayList<Integer> lst = new ArrayList<>();
//		lst.add(0);
//		lst.add(1);
//		lst.add(1,3);
//		System.out.println(lst);
//		MapSum ms = new MapSum();
//		ms.insert("a",3);
//		ms.sum("ap");
//		Integer a = new Integer(1);
//		Integer b = a;
//		
//		System.out.print(a);
//		System.out.print(b);
		
//		String s = "啊";
//		int[] ar= {1,2,3,4};
//		ArrayList<Integer> ar = new ArrayList<>();
//		ar.add(1);
//
//		ar.remove(0);
//		ar.add(0,5);
		
		Solution723_candycrush s  = new Solution723_candycrush();
		int[][] a = new int[][]{{2},{0},{0},{3},{0},{0},{1},{0},{3},{4},{5}};
		
		int[][] b = {{110,5,112,113,114},{210,211,5,213,214},{310,311,3,313,314},{410,411,412,5,414},{5,1,512,3,3},{610,4,1,613,614},{710,1,2,713,714},{810,1,2,1,1},{1,1,2,2,2},{4,1,4,4,1014}};
		//int[][] board = {a};
		s.resort(a);
		int[][] ver = s.countCrushVer(b);
		int[][] hor = s.countCrushHor(b);
		s.delete(b, hor, ver);
		for(int i = 0; i < b.length ; i++){
			for(int j = 0; j < b[0].length ; j++){
				System.out.print(b[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
		
		
		System.out.println();
	}
}
class test1{
	int a;
	int b;
	int c;
	public test1(int a, int b){
		this.a = a;
		this.b = b;
	}
	public void print(){
		System.out.println(a + " " +  b);
	}
}

class test2 extends test1{
	double a;
	double b;
	double c;
	public test2(int a, int b){
		super(a, b);
		c = 2.0;
	}
}