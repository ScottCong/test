package test;

public class BestTimeBuyAndSell {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)return 0;
        int[][] AllTime = new int[prices.length + 1][3];
        int[][] LastDaySell = new int[prices.length + 1][3];
        for(int day = 1; day < prices.length; day++){
        	int diff = prices[day] - prices[day - 1];
        	for(int times = 2; times > 0; times--){
        		LastDaySell[day][times] = Math.max(AllTime[day - 1][times - 1] + (diff > 0? diff: 0), LastDaySell[day - 1][times] + diff);
        		AllTime[day][times] = Math.max(AllTime[day - 1][times], LastDaySell[day][times]);
        	}
        }
        int ans = 0;
        for(int times = 1; times <= 2; times++){
        	ans = Math.max(AllTime[prices.length - 1][times], ans);
        }
        return ans;
    }
}
