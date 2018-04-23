package test;
//swap two nodes in a BST, recover it

//交换两个点一定是先遍历到小点变大点的那个点，那个点的后继一定比他小，所以inorder traverse一定能
//先找到这个点的后继。 如果这两个点不相邻，那么第二个点一定是比他的前继点小，所以这个点是当前点。
//如果相邻，那么把第一个点和第一个点的后继电交换即可
public class Soution99 {
	TreeNode prevNode;
	TreeNode FirstWrong;
	TreeNode SecondWrong;
    public void recoverTree(TreeNode root) {
        prevNode = null;
        FirstWrong = null;
        SecondWrong = null;
        if(root == null)return;
        inOrder(root);
        	int tmp = FirstWrong.val;
        	FirstWrong.val = SecondWrong.val;
        	SecondWrong.val = tmp;
        	return;
    }
    public void inOrder(TreeNode node){
    	if(node == null)return;
    	inOrder(node.left);
    	if(prevNode == null)prevNode = node;
    	else if(node.val < prevNode.val){
    		if(FirstWrong == null){
    			FirstWrong = prevNode;
    			SecondWrong = node;
    		}
//    		else if(FirstWrong != null && SecondWrong == null){
//    			
//    		}
    		else{
    			SecondWrong = node;
    		}
    	}
    	prevNode = node;
    	inOrder(node.right);
    }
}
