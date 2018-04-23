package test;

public class Solution64 {
    public int minPathSum(int[][] grid) {
    	if(grid.length == 0 || grid[0].length == 0){
    		return 0;
    	}
        int[][] path = new int[grid.length][grid[0].length];
        for(int hor = 0; hor < grid.length;hor++){
        	for(int ver = 0; ver < grid[0].length; ver++){
        		if(hor == 0 && ver == 0)path[0][0] = grid[0][0];
        		else if(ver == 0){
        			path[hor][ver] =path[hor - 1][ver] + grid[hor][ver];
        		}
        		else if(hor == 0){
        			path[hor][ver] = path[hor][ver - 1] + grid[hor][ver];
        		}
        		else if(!(ver == 0) && !(hor == 0)){
        			path[hor][ver] = Math.min(path[hor - 1][ver], path[hor][ver - 1]) + grid[hor][ver];
        		}
        		else{
        			System.out.println("Error");
        		}
        	}
        }
        return path[path.length - 1][path[0].length - 1];
    }
}
