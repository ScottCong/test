package test;
//数一个树有多少子树是纯由一个数构成的
public class Solution250 {
    public int countUnivalSubtrees(TreeNode root) {
        IsUnival ans = FindSubUnival(root);
        return ans.count;
    }
    public IsUnival FindSubUnival(TreeNode node){
    	if(node == null){
    		return new IsUnival(true, true, 0, 0);
    	}
    	IsUnival LeftState = FindSubUnival(node.left);
    	IsUnival RightState = FindSubUnival(node.right);
    	if(LeftState.Isnull && RightState.Isnull)return new IsUnival(true, false, node.val, 1);
    	else if(LeftState.Isnull){
    		if(RightState.b && RightState.num == node.val)return new IsUnival(true, false, node.val, RightState.count + 1);
    		else return new IsUnival(false, false, node.val, RightState.count);
    	}
    	else if(RightState.Isnull){
    		if(LeftState.b && LeftState.num == node.val)return new IsUnival(true, false, node.val, LeftState.count + 1);
    		else return new IsUnival(false,false, node.val, LeftState.count);
    	}
    	else{
    		if(LeftState.b && RightState.b && (LeftState.num == node.val) && (RightState.num == node.val)){
    			return new IsUnival(true,false,node.val, LeftState.count + RightState.count + 1);
    			
    		}
    		else return new IsUnival(false, false, node.val, LeftState.count + RightState.count);
    	}
    }
}
class IsUnival{
	boolean b;
	boolean Isnull;
	int num;
	int count;
	public IsUnival(boolean b, boolean Isnull,int num, int count){
		this.b = b;
		this.num = num;
		this.count = count;
		this.Isnull = Isnull;
	}
}