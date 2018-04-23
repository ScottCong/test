package test;

public class Solution302 {
	int minx, miny, maxx,maxy;
	boolean[][] visited;
    public int minArea(char[][] image, int x, int y) {
        minx = x;
        maxx = x;
        miny = y;
        maxy = y;
        visited = new boolean[image.length][image[0].length];
        dfs(image, x, y);
        return (maxx - minx + 1) * (maxy - miny + 1);
    }
    public void dfs(char[][] image, int x, int y){
        
    	if(x < 0 || x >= image.length || y < 0 || y >= image[0].length)return;
    	System.out.println(image[x][y] == 1);
        if(image[x][y] != 1)return;
    	if(visited[x][y])return;
    	visited[x][y] = true;
    	minx = Math.min(minx, x);
    	maxx = Math.max(maxx, x);
    	miny = Math.min(miny, y);
    	maxy = Math.min(maxy, y);
        
    	dfs(image, x + 1, y);
    	dfs(image, x, y + 1);
    	dfs(image, x - 1, y);
    	dfs(image, x, y - 1);
    }
}
