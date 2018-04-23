package test;

public class Solution531 {
	char[][] record;
	char[][] picture;
	int ans = 0;
    public int findLonelyPixel(char[][] picture) {
        this.record = picture;
        this.picture = picture;
        for(int i = 0; i < picture[0].length; i++){
        	for(int j = 0; j < picture.length; j++){
        		if(this.record[j][i] == 'B'){
        			if(dfsVer(i,j)){
        				System.out.println(i);
        				System.out.println(j);
        				ans += 1;
        			}
        		}
        	}
        }
        return ans;
    }
    public boolean dfsVer(int x, int y){
    	if(x >= picture[0].length || y >= picture.length){
    		return true;
    	}
    	if(picture[y][x] == 'W'){
    		return dfsVer(x+1,y) && true;
    	}
    	if(picture[y][x] == 'B'){
    		this.record[y][x] = 'W';
    		return dfsVer(x+1,y) && false;
    	}
    	else{
    		System.out.println("unexpeced");
    		return true;
    	}
    }
    public boolean dfsHor(int x, int y){
    	if(x >= picture[0].length || y >= picture.length){
    		return true;
    	}
    	if(picture[y][x] == 'W'){
    		return dfsVer(x,y + 1) && true;
    	}
    	if(picture[y][x] == 'B'){
    		this.record[y][x] = 'W';
    		return dfsVer(x,y + 1) && false;
    	}
    	else{
    		System.out.println("unexpeced");
    		return true;
    	}
    }
}