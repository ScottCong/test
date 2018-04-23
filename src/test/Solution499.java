package test;

import java.util.*;

public class Solution499 {
	public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
    	Route ans = null;
        Route[][] routes = new Route[maze.length][maze[0].length];
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                routes[i][j] = new Route(0, "");
            }
        }
        Map<String, int[]> direction = new HashMap<>();
        direction.put("u", new int[]{-1, 0});
        direction.put("d", new int[]{1, 0});
        direction.put("l", new int[]{0, -1});
        direction.put("r", new int[]{0, 1});
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> que = new LinkedList<>();
        visited[ball[0]][ball[1]] = true;
        que.offer(ball);
        while(que.size() > 0){
        	Queue<int[]> tmp = new LinkedList<>();
        	while(que.size() > 0){
        		int[] cur = que.poll();
        		Route curRoute = routes[cur[0]][cur[1]];
        		for(String s: direction.keySet()){
        			int[] mov = direction.get(s);
        			int length = curRoute.length;
        			int row = cur[0] + mov[0];
        			int col = cur[1] + mov[1];
        			boolean drop = false;
        			while(row >=0 && row < maze.length && col >=0 && col < maze[0].length && maze[row][col] == 0){
        				if(row == hole[0] && col == hole[1]){
        					Route newRoute = new Route(length++, curRoute.route + s);
        					if(ans == null){
        						ans = newRoute;
        					}
        					else if (newRoute.compareTo(ans) < 0)ans = newRoute;
        					drop = true;
        					break;
        				}
        				else{
        					row += mov[0];
        					col += mov[1];
        					length++;
        				}
        			}
        			if(drop)continue;
        			row -= mov[0];
        			col -= mov[1];
        			if(!visited[row][col]){
        				visited[row][col] = true;
        				Route newRoute = new Route(length, curRoute.route + s);
        				routes[row][col] = newRoute;
        				tmp.offer(new int[]{row, col});
        			}
        			else{
        				Route newRoute = new Route(length, curRoute.route + s);
        				if(newRoute.compareTo(routes[row][col]) < 0){
        					routes[row][col] = newRoute;
        					tmp.offer(new int[]{row, col});
        				}
        			}
        			
        		}
        	}
        	que = tmp;
        	
        }
        if(ans == null)return"impossible";
        return ans.route;
    }
}
class Route implements Comparable<Route>{
	int length;
	String route;
	public Route(int length, String route){
		this.length = length;
		this.route = route;
	}
	@Override
	public int compareTo(Route r) {
		// TODO Auto-generated method stub
		if(this.length > r.length)return 1;
		else if(this.length < r.length)return -1;
		else{
			if(this.route.compareTo(r.route) > 0)return 1;
			else return -1;
		}
	}
}

//class newRouteComparator implements Comparator<Route>{
//	@Override
//	public int compare(Route r1, Route r2) {
//		// TODO Auto-generated method stub
//		if(r1.length > r2.length)return 1;
//		else if(r1.length < r2.length)return -1;
//		else{
//			if(r1.route.compareTo(r2.route) > 0)return 1;
//			else if(r2.route.compareTo(r1.route) > 0)return -1;
//			else return 0;
//			
//		}
//	}	
