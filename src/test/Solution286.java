package test;

import java.util.*;

public class Solution286 {
	int[][] rooms;
    public void wallsAndGates(int[][] rooms) {
        //first find all the gate
    	if(rooms.length == 0 || rooms[0].length == 0)return;
    	this.rooms = rooms;
    	LinkedList<int[]> gates = new LinkedList<>();
    	for(int i = 0; i < rooms.length; i++){
    		for(int j = 0; j < rooms[0].length;j++){
    			if(rooms[i][j] == 0)gates.add(new int[]{i, j});
    		}
    	}
    	//then do bfs
    	for(int[] gate: gates){
    		int x = gate[0];
    		int y = gate[1];
        	SearchPath(new int[]{x + 1, y}, 1);
        	SearchPath(new int[]{x - 1, y}, 1);
        	SearchPath(new int[]{x, y + 1}, 1);
        	SearchPath(new int[]{x, y - 1}, 1);
    	}
    	
    }
    public void SearchPath(int[] position, int steps){
    	int x = position[0];
    	int y = position[1];
    	if(x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length)return;
    	if(rooms[x][y] == 0 || rooms[x][y] == -1)return;
    	if(steps >= rooms[x][y])return;
    	rooms[x][y] = steps;
    	SearchPath(new int[]{x + 1, y}, steps + 1);
    	SearchPath(new int[]{x - 1, y}, steps + 1);
    	SearchPath(new int[]{x, y + 1}, steps + 1);
    	SearchPath(new int[]{x, y - 1}, steps + 1);
    }
}
