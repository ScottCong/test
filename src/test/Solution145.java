package test;

import java.util.*;
//可以用stack来合成postorder traverse的数列
//最后结果需要翻转
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        LinkedList<Integer> lst = new LinkedList<>();
        if(root == null)return lst;
        stk.push(root);
        while(stk.size() > 0){
        	TreeNode cur = stk.pop();
        	lst.add(cur.val);
        	if(cur.left != null)stk.push(cur.left);
        	if(cur.right != null)stk.push(cur.right);
        }
        LinkedList<Integer> ans = new LinkedList<>();
        for(int i = lst.size() - 1; i >= 0; i--){
        	ans.add(lst.get(i));
        }
        return ans;
    }
}
