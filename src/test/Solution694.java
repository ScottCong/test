package test;

import java.util.*;

public class Solution694 {
	public void DFS(int r, int c, int r0, int c0, int[][] grid, HashSet<Integer> shape){
		if(grid[r][c] == 1 && r >=0 && r < grid.length && c >=0 && c < grid[0].length){
			grid[r][c] = 0;
			shape.add((r - r0) * grid[0].length * 2 + c - c0);
			DFS(r - 1, c, r0, c0, grid, shape);
			DFS(r + 1, c, r0, c0, grid, shape);
			DFS(r, c - 1, r0, c0, grid, shape);
			DFS(r, c + 1, r0, c0, grid, shape);
		}
	}
    public int numDistinctIslands(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
        	return 0;
        }
        HashSet<HashSet<Integer>> shapes = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
        	for(int j = 0; j < grid[0].length; j++){
        		if(grid[i][j] == 1){
        			HashSet<Integer> shape = new HashSet<>();
        			DFS(i, j ,i, j, grid, shape);
        			if(shape.size() > 0){
        				shapes.add(shape);
        			}
        		}
        	}
        }
        return shapes.size();
    }
}
