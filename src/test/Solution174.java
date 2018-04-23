package test;
//dungeon problem,use dynamic programming from the end to the beginning
public class Solution174 {
    public int calculateMinimumHP(int[][] dungeon) {
      if(dungeon.length == 0 || dungeon[0].length == 0)return 0;
      int[][] health = new int[dungeon.length][dungeon[0].length];
      for(int hor = dungeon.length - 1; hor >= 0; hor++){
    	  for(int ver = dungeon[0].length - 1; ver >=0; ver++){
    		  if(ver == dungeon[0].length - 1 && hor == dungeon.length - 1){
    			  health[hor][ver] = Math.max(1, -dungeon[hor][ver] + 1);
    		  }
    		  else if(ver == dungeon[0].length - 1){
    			  health[hor][ver] = Math.max(1, health[hor + 1][ver] -dungeon[hor][ver] + 1);
    		  }
    		  else if(hor == dungeon.length - 1){
    			  health[hor][ver] = Math.max(1, health[hor][ver + 1] - dungeon[hor][ver] + 1);
    		  }
    		  else{
    			  health[hor][ver] = Math.max(1, Math.min(health[hor + 1][ver], health[hor][ver + 1]) - dungeon[hor][ver] + 1); 
    		  }
    	  }
      }
    return health[0][0];
    	
    }
}
    
//        if(dungeon.length == 0 || dungeon[0].length == 0)return 0;
//        state[][] health = new state[dungeon.length][dungeon[0].length];
//        for(int hor = 0; hor < dungeon.length; hor++){
//        	for(int ver = 0; ver< dungeon[0].length; ver++){
//        		if(hor == 0 || ver==0){
//        			state begin = new state(dungeon[0][0],dungeon[0][0]);
//        		}
//        		else if(hor == 0 && !(ver == 0)){
//        			int current = health[hor][ver - 1].current + dungeon[hor][ver];
//        			int lowest = current < health[hor][ver - 1].lowest ? current: health[hor][ver - 1].lowest;
//        			health[hor][ver] = new state(current,lowest);
//        		}
//        		else if(!(hor == 0) && ver == 0){
//        			int current = health[hor - 1][ver].current + dungeon[hor][ver];
//        			int lowest = current < health[hor - 1][ver].lowest ? current: health[hor - 1][ver].lowest;
//        			health[hor][ver] = new state(current,lowest);
//        		}
//        		else{
//        			//first to see if the lowest happens in this room
//        			state state1 = health[hor - 1][ver];
//        			state state2 = health[hor][ver - 1];
//        			int currentRoom = dungeon[hor][ver];
//        			state newState1 = new state(state1.current + currentRoom,Math.min(state1.lowest, state1.current + currentRoom));
//        			state newState2 = new state(state2.current + currentRoom,Math.min(state2.lowest, state2.current + currentRoom));
//        			state RightState = newState1.lowest > newState2.lowest? newState1:newState2;
//        			health[hor][ver] = RightState;
////        			if(Math.max(state1.current + currentRoom, state2.current + currentRoom) < Math.max(state1.lowest, state2.lowest)){
////        				int maxVal = Math.max(state1.current + currentRoom, state2.current + currentRoom);
////        				state newState = new state(maxVal,maxVal);
////        				health[hor][ver] = newState;
////        			}
////        			//if the lowest never happens in this room,choose the max current one
////        			else if(Math.max(state1.lowest, state2.lowest) <Math.min(state1.current + currentRoom, state2.current + currentRoom)){
////        				state rightState = state1.current > state2.current?state1:state2;
////        				state newState = new state(rightState.current + currentRoom, rightState.lowest);
////        				health[hor][ver] = newState;
////        			}
////        			else{
////        				state rightState = Math.min(state1.current + currentRoom, state1.lowest) > Math.min(state2.current + currentRoom, state2.lowest)?state1:state2;
////        				state newState = new state(rightState.current + currentRoom, Math.min(rightState.current + currentRoom, rightState.lowest));
////        				health[hor][ver] = newState;
////        			}
//        		}
//        	}
//        	
//        }
//        return -health[dungeon.length - 1][dungeon[0].length - 1].lowest;
//    }
//    class state{
//    	int current;
//    	int lowest;
//    	public state(int current,int lowest){
//    		this.current = current;
//    		this.lowest = lowest;
//    	}
//    }
//}
