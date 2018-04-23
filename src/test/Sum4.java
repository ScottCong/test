package test;

import java.util.*;
public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        if(nums.length <= 3)return ans;
        Arrays.sort(nums);
        int first = 0;
        for(first = 0; first < nums.length - 3; first++){
        	if(nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3] > target)break;
        	int newTar = target - nums[first];
            if(first > 0 && nums[first] == nums[first - 1])continue;
        	int second = first + 1;
        	for(second = first + 1; second < nums.length - 2; second++){
        		if(nums[second] + nums[second + 1] + nums[second + 2] > newTar)break;
        		int twoTar = newTar - nums[second];
        		int third = second + 1;
        		int fourth = nums.length - 1;
        		while(third < fourth){
        			if(nums[third] + nums[fourth] == twoTar){
        				ans.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
        				while(nums[third] == nums[third + 1])third++;
        				while(nums[fourth] == nums[fourth - 1])fourth--;
        				third++;
        				fourth--;
        			}
        			else{
        				if(nums[third] + nums[fourth] > twoTar)fourth--;
        				else third++;
        			}
        		}
        	}
        }
        return ans;
    }
}
