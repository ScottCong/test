package test;

import java.util.*;

//shortest distance from all building
public class Solution317 {
	int[][] grid;
    public int shortestDistance(int[][] grid) {
    	if(grid.length == 0 || grid[0].length == 0)return -1;
    	this.grid = grid;
        List<int[]> buildings = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
        	for(int j = 0; j < grid[0].length; j++){
        		if(grid[i][j] == 1)buildings.add(new int[]{i, j});
        	}
        }
        int[][] ans = new int[grid.length][grid[0].length];
        for(int[] building: buildings){
        	int x = building[0];
        	int y = building[1];
        	int[][] tmp = new int[grid.length][grid[0].length];
        	for(int i = 0; i < grid.length; i++)Arrays.fill(tmp[i], Integer.MAX_VALUE);
        	calculatePath(tmp, new int[]{x + 1, y}, 1);
        	calculatePath(tmp, new int[]{x - 1, y}, 1);
        	calculatePath(tmp, new int[]{x, y + 1}, 1);
        	calculatePath(tmp, new int[]{x, y - 1}, 1);
        	for(int i = 0; i < grid.length; i++){
        		for(int j = 0; j < grid[0].length; j++){
                    if(ans[i][j] == Integer.MAX_VALUE)continue;
        			if(grid[i][j] == 0){
        				if(tmp[i][j] == Integer.MAX_VALUE)ans[i][j] = Integer.MAX_VALUE;
        				else ans[i][j] += tmp[i][j];
        			}
        		}
        	}
        }
        int smallest = Integer.MAX_VALUE;
    	for(int i = 0; i < grid.length; i++){
    		for(int j = 0; j < grid[0].length; j++){
    			if(grid[i][j] == 0)smallest = Math.min(smallest, ans[i][j]);
                
    		}
    	}
        if(smallest == Integer.MAX_VALUE || buildings.size() == 0)return -1;
    	return smallest;
        
        
    }
    public void calculatePath(int[][] tmp, int[] position, int step){
    	int x = position[0];
    	int y = position[1];
    	if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)return;
    	if(grid[x][y] == 1 || grid[x][y] == 2 || tmp[x][y] <= step)return;
    	tmp[x][y] = step;
    	calculatePath(tmp, new int[]{x + 1, y}, step + 1);
    	calculatePath(tmp, new int[]{x - 1, y}, step + 1);
    	calculatePath(tmp, new int[]{x, y + 1}, step + 1);
    	calculatePath(tmp, new int[]{x, y - 1}, step + 1);
    }
}

