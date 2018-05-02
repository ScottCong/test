package test;

public class Solution799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
    	int size = Math.max(query_row + 1, query_glass + 1);
        double[][] glasses = new double[size + 1][size + 1];
        glasses[1][1] = (double)poured;
        
        for(int row = 2; row <= size; row++){
        	for(int glass = 1; glass <= row; glass++){

        		glasses[row][glass] = Math.max(0, glasses[row - 1][glass - 1] - 1) / 2.0 + Math.max(0, glasses[row - 1][glass] - 1) / 2.0;
        		
        	}
        }
        
        // for(int i = 0; i <= size; i++){
        //     for(int j = 0; j <= size; j++)System.out.println(glasses[i][j]);
        // }
        return Math.min(glasses[query_row + 1][query_glass + 1], 1.0);
    }
}
