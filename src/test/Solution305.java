package test;

import java.util.*;

//union find example
//use new data structure
//https://www.cs.princeton.edu/~rs/AlgsDS07/01UnionFind.pdf
public class Solution305 {
	int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
    	List<Integer> ans = new LinkedList<>();
        unionFind2D islands = new unionFind2D(m, n);
        for(int[] position: positions){
        	islands.add(position[0], position[1]);
        	for(int[] dir: dirs){
        		int i = position[0] + dir[0];
        		int j = position[1] + dir[1];
        		if(islands.getID(i, j) > 0){
            		int index1 = islands.index(position[0], position[1]);
            		int index2 = islands.index(i, j);
            		if(!islands.find(index1, index2)){
            			islands.union(index1, index2);
            		}
        		}
        	}
        	ans.add(islands.getCount());
        }
        return ans;
    }
}
class unionFind2D{
	int count, m, n;
	int[] ID;
	public unionFind2D(int m, int n){
		count = 0;
		ID = new int[m * n + 1];
		this.m = m;
		this.n = n;
	}
	public int getCount(){
		return this.count;
	}
	public int index(int p, int q){
		return p * n + q + 1;
	}
	public int getID(int p, int q){
		if(p >= 0 && p < m && q >= 0 && q < n){
			return this.ID[index(p, q)];
		}
		else return 0;
	}
	public int add(int p, int q){
		int index = this.index(p, q);
		ID[index] = index;
		count++;
		return index;
	}
	public int root(int i){
		int index = i;
		while(index != ID[index]){
			index = ID[index];
		}
		return index;
	}
	public boolean find(int i, int j){
		return(root(i) == root(j));
	}
	public void union(int i, int j){
		int rootI = root(i);
		int rootJ = root(j);
		ID[rootI] = rootJ;
		count--;
	}
}