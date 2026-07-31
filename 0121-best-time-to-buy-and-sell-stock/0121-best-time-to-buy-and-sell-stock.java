class Solution {
    public int maxProfit(int[] prices) {
        // int n = prices.length;
        // int maxprofit=0;
        // int buyprice=prices[0];
        // for(int i=1;i<n;i++) {
        //     int profit = prices[i] - buyprice;
        //     maxprofit = Math.max(maxprofit,profit);
        //     buyprice = Math.min(buyprice,prices[i]);
        // }
        // return maxprofit;

        // -- greedy app --
        int n = prices.length;
        int min = prices[0];
        int profit=0;
        for(int i=1;i<n;i++) {
            min = Math.min(min,prices[i]);
            profit = Math.max(profit,prices[i]-min);
        }
        return profit;
    }
}