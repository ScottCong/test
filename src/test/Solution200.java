package test;

public class Solution200 {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for(int i = 0; i < grid.length; i ++){
        	for(int j = 0; j < grid[0].length; j++){
        		if(visited[i][j] || grid[i][j] == '0')continue;
        		else{
        			dfs(visited, grid, i, j);
        			ans++;
        		}
        	}
        }
        return ans;
    }
    public void dfs(boolean[][] visited, char[][] grid, int i, int j){
    	if(i < 0 || i >= grid.length|| j < 0 || j >= grid[0].length || visited[i][j] || grid[i][j] == '0')return;
    	if(grid[i][j] == '1'){
    		visited[i][j] = true;
    		dfs(visited, grid, i - 1, j);
    		dfs(visited, grid, i + 1, j);
    		dfs(visited, grid, i, j - 1);
    		dfs(visited, grid, i, j + 1);
    	}
    	return;
    	
    }
}
