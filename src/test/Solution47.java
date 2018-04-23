package test;

import java.util.*;

//permutation 用交换法比较好理解，当出现重复元素时，相同的值不要交换，交换了一个值后，和这个值相同的的值不要交换
public class Solution47 {
	List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
    	Arrays.sort(nums);
        LinkedList<Integer> prototype = new LinkedList<>();  
        for(int num: nums){
        	prototype.add(num);
        }
        ans.add(prototype);
        helper(prototype, 0);
        System.out.println(ans.size());
        return this.ans;
    }
    public void helper(LinkedList<Integer>num, int index){
        if(index == num.size()){
        	ans.add(num);
        	return;
        }
        helper(num, index + 1);
    	for(int i = index + 1; i < num.size(); i++){
    		if(num.get(i) == num.get(i - 1)){
    			continue;
    		}
    		LinkedList<Integer> newLst = new LinkedList<>();
    		newLst.addAll(num);
    		newLst.set(index, num.get(i));
    		newLst.set(i, num.get(index));
    		helper(newLst, index + 1);
    	}
    }
}
