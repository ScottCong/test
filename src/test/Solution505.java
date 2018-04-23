package test;

import java.util.*;

public class Solution505 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
    	if(maze.length == 0 || maze[0].length == 0 )return -1;
        int[][] distance = new int[maze.length][maze[0].length];
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> que = new LinkedList<>();
        que.offer(start);
        visited[start[0]][start[1]] = true;
        while(que.size() > 0){
        	Queue<int[]> tmp = new LinkedList<>();
            while(que.size() > 0){
            int[] cur = que.poll();
        	for(int[] direction: dir){
        		int length = distance[cur[0]][cur[1]];
        		int row = cur[0] + direction[0];
        		int col = cur[1] + direction[1];
        		while(row >= 0 && row < maze.length && col >= 0 && col< maze[0].length && maze[row][col] == 0){
    				length++;
    				row += direction[0];
    				col += direction[1];
        		}
        		if(!visited[row - direction[0]][col - direction[1]]){
        			visited[row - direction[0]][col - direction[1]] = true;
        			distance[row - direction[0]][col - direction[1]] = length;
        			int[] newPoint = new int[]{row - direction[0], col - direction[1]};
        			tmp.add(newPoint);
        		}
                else if(length < distance[row - direction[0]][col - direction[1]]){
                    distance[row - direction[0]][col - direction[1]] = length;
                    int[] newPoint = new int[]{row - direction[0], col - direction[1]};
                    tmp.add(newPoint);
                }
        	}
        	que = tmp;
        }
        }
        if(visited[destination[0]][destination[1]])return distance[destination[0]][destination[1]];
        return -1;
    }
}
