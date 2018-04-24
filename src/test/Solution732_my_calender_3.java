package test;

import java.util.TreeMap;

//["MyCalendarThree","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book"]
//[[],[47,50],[1,10],[27,36],[40,47],[20,27],[15,23],[10,18],[27,36],[17,25],[8,17],[24,33],[23,28],[21,27],[47,50],[14,21],[26,32],[16,21],[2,7],[24,33],[6,13],[44,50],[33,39],[30,36],[6,15],[21,27],[49,50],[38,45],[4,12],[46,50],[13,21]]

//give up, the boundary makes no sense
//update, I'm stupid, segment tree should look like this https://blog.csdn.net/yyl424525/article/details/77859911
public class Solution732_my_calender_3 {
    TreeMap<Integer, Integer> delta;

    public Solution732_my_calender_3() {
        delta = new TreeMap();
    }

    public int book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int active = 0, ans = 0;
        for (int d: delta.values()) {
            active += d;
            if (active > ans) ans = active;
        }
        // active = 0;
        // for(int i: delta.keySet()){
        //     active += delta.get(i);
        //     if(active == 10){
        //         System.out.println(i);
        //     }
        // }
        return ans;
    }
	
	
	
	
	
	
	
	
	
}
//
//	
//	SegmentTreeNode root;
//	int max;
//    public Solution732_my_calender_3() {
//        this.root = null;
//        this.max = 0;
//    }
//    
//    public int book(int start, int end) {
//    	if(start == 46 && end == 50){
//    		printTree(root);
//    	}
//        if(root == null){
//        	this.root = new SegmentTreeNode(start, end);
//        	return 1;
//        }
//        
//        else insertNode(this.root, new SegmentTreeNode(start, end));
//        return this.max;
//    }
//    
//    public void insertNode(SegmentTreeNode curNode, SegmentTreeNode node){
//    	
//    	SegmentTreeNode tempNode = curNode;
//    	if(node.start == node.end)return;
//    	if(curNode.start == node.start && curNode.end == node.end){
//    		curNode.overlap++;
//    		max = Math.max(max, curNode.overlap);
//    		return;
//    	}
//    	if(node.start < curNode.start){
//    		if(node.end <= curNode.start){
//    			if(curNode.left == null){
//    				curNode.left = node;
//    				max = Math.max(max, curNode.overlap);
//    				return;
//    			}
//    			else {
//    				insertNode(curNode.left, node);
//    				return;
//    			}
//    		}
//    		
//    		else if(node.end > curNode.start && node.end <= curNode.end){
//    			
//    			SegmentTreeNode segNode1 = new SegmentTreeNode(node.end, curNode.end);
//    			SegmentTreeNode segNode2 = new SegmentTreeNode(node.start, curNode.start);
//    			if(!(segNode1.Validate() && segNode2.Validate()))System.out.print("1");
//    			curNode.end = node.end;
//    			curNode.overlap++;
//    			insertNode(curNode, segNode1);
//    			insertNode(curNode, segNode2);
//    			max = Math.max(max, curNode.overlap);
//    			return;
//    		}
//    		
//    		else if(node.end > curNode.end){
//    			SegmentTreeNode segNode1 = new SegmentTreeNode(curNode.end, node.end);
//    			SegmentTreeNode segNode2 = new SegmentTreeNode(node.start, curNode.start);
//    			if(!(segNode1.Validate() && segNode2.Validate()))System.out.print("2");
//    			curNode.overlap++;
//    			insertNode(curNode, segNode1);
//    			insertNode(curNode, segNode2);
//    			max = Math.max(max, curNode.overlap);
//    			return;
//    		}
//    		
//    	}
//    	
//    	else if(node.start >= curNode.start && node.start < curNode.end){
//    		if(node.end <= curNode.end){
//    			SegmentTreeNode segNode1 = new SegmentTreeNode(curNode.start, node.start);
//    			SegmentTreeNode segNode2 = new SegmentTreeNode(node.end, curNode.start);
//    			if(!(segNode1.Validate() && segNode2.Validate()))System.out.print("3");
//    			curNode.overlap++;
//    			curNode.start = node.start;
//    			curNode.end = node.end;
//    			insertNode(curNode, segNode1);
//    			insertNode(curNode, segNode2);
//    			max = Math.max(max, curNode.overlap);
//    			return;
//    		}
//    		else if(node.end > curNode.end){
//    			SegmentTreeNode segNode1 = new SegmentTreeNode(curNode.start, node.start);
//    			SegmentTreeNode segNode2 = new SegmentTreeNode(curNode.end, node.end);
//    			if(!(segNode1.Validate() && segNode2.Validate()))System.out.print("4");
//    			curNode.overlap++;
//    			curNode.start = node.start;
//    			insertNode(curNode, segNode1);
//    			insertNode(curNode, segNode2);
//    			max = Math.max(max, curNode.overlap);
//    			return;
//    		}
//    	}
//    	
//    	else if(node.start >= curNode.end){
//    		if(curNode.right == null){
//    			curNode.right = node;
//    			max = Math.max(max, curNode.overlap);
//    			return;
//    		}
//    		else{
//    			insertNode(curNode.right, node);
//    			max = Math.max(max, curNode.overlap);
//    			return;
//    		}
//    	}
//
//    	System.out.print("????");
//		return;
//    }
//    
//    public void printTree(SegmentTreeNode node){
//    	if(node == null)return;
//    	printTree(node.left);
//    	System.out.println(node.start);
//    	System.out.println(node.end);
//    	printTree(node.right);
//    }
//}

//class SegmentTreeNode{
//	
//	int overlap;
//	SegmentTreeNode left;
//	SegmentTreeNode right;
//	int start;
//	int end;
//	public SegmentTreeNode(int start, int end){
//		overlap = 1;
//		this.start = start;
//		this.end = end;
//	}
//	public boolean Validate(){
//		if(start > end)return false;
//		return true;
//	}
//}