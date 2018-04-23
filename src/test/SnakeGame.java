package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//玩蛇游戏
public class SnakeGame {
	int score;
	int[] head = {0, 0}; 
	int[] food = new int[2];
	String[][] tailMap;
	int[] tail = {0,0};
	
	Queue<int[]> foods = new LinkedList<int[]>();
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        for(int[] f: food){
        	this.foods.offer(f);
        }
        this.food = foods.poll();
        this.tailMap = new String[height][width];
        this.score = 0;
        for(int i = 0; i < tailMap.length; i++){
            for(int j = 0; j < tailMap[0].length; j++){
                    tailMap[i][j] = "N";
                }
            }
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
    	if(score == -1)return -1;
    	tailMap[head[0]][head[1]] = direction;
        switch(direction){
        case "U":
        	head[0] -= 1;
        	break;
        case "D":
        	head[0] += 1;
        	break;
        case "L":
        	head[1] -= 1;
        	break;
        case "R":
        	head[1] += 1;
        	break;
        default:
        	System.out.print("wrong");
        }
        if(head[0] < 0 || head[1] < 0 || head[0] >= this.tailMap.length || head[1] >= this.tailMap[0].length){
        	return -1;
        	// hit the wall
        }
        if(head[0] == food[0] && head[1] == food[1]){
        	//get the food
        	score += 1;
        	//this.snake[head[0]][head[1]] = 1;
        	if(this.foods.size() <= 0){
        		food[0] = -1;
        		food[1] = -1;
        	}
        	else food = foods.poll();
        	return score;
        }
        else{
            String dir = tailMap[tail[0]][tail[1]];
        	tailMap[tail[0]][tail[1]] = "N";
        	if(tailMap[head[0]][head[1]] != "N"){
        		score = -1;
        		return score;
        	}
            switch(dir){
            case "U":
            	tail[0] -= 1;
            	break;
            case "D":
            	tail[0] += 1;
            	break;
            case "L":
            	tail[1] -= 1;
            	break;
            case "R":
            	tail[1] += 1;
            	break;
            default:
                System.out.println("....");
            }
            return score;
        }
    }
}
//class Position{
//    int x;
//    int y;
//    public Position(int x,int y){
//        this.x = x;
//        this.y = y;
//    }
//    public boolean isEqual(Position p){
//        return this.x==p.x && this.y == p.y ;
//    }
//}
//int len;
//int rows ,cols;
//
//int[][] food;
//LinkedList<Position> snake;
//
///** Initialize your data structure here.
//    @param width - screen width
//    @param height - screen height 
//    @param food - A list of food positions
//    E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
//public SnakeGame(int width, int height, int[][] food) {
//    this.rows = height;
//    this.cols = width;
//    this.food = food;
//
//    snake = new LinkedList<Position>();
//    snake.add(new Position(0,0));
//    len = 0;
//}
//
///** Moves the snake.
//    @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
//    @return The game's score after the move. Return -1 if game over. 
//    Game over when snake crosses the screen boundary or bites its body. */
//public int move(String direction) {
//	//if(len>=food.length) return len;
//
//    Position cur = new Position(snake.get(0).x,snake.get(0).y);
//    
//    switch(direction){
//    case "U": 
//        cur.x--;  break;
//    case "L": 
//        cur.y--; break;
//    case "R": 
//        cur.y++;   break;
//    case "D": 
//        cur.x++;   break;
//    }
//    
//    if(cur.x<0 || cur.x>= rows || cur.y<0 || cur.y>=cols) return -1;
//    
//
//    for(int i=1;i<snake.size()-1;i++){
//        Position next = snake.get(i);
//        if(next.isEqual(cur)) return -1;	       
//    }
//    snake.addFirst(cur);     
//    if(len<food.length){
//        Position p = new Position(food[len][0],food[len][1]);	        
//        if(cur.isEqual(p)){	            
//            len++;
//        }
//    }
//    while(snake.size()>len+1) snake.removeLast();
//   
//    return len;
//}
/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */