package test;

import java.util.ArrayList;
import java.util.List;

public class Solution129 {
	List<Integer> store = new ArrayList<Integer>();
	public int sumNumbers(TreeNode root) {
        int ans = 0;
        traverse(0, root);
        ans = AddAll(store);
        return ans;
    }
	public void traverse(int cur, TreeNode node){
		if(node.left == null && node.right == null){
			store.add((cur * 10) + node.val);
			return;
		}
		else{
			if(node.left != null){
				traverse((cur * 10) + node.val,node.left);
			}
			if(node.right != null){
				traverse((cur * 10) + node.val,node.right);
			}
		}
	}
	public int AddAll(List<Integer> lst){
		int ans = 0;
		for(int i: lst){
			ans += i;
		}
		return ans;
	}
}
