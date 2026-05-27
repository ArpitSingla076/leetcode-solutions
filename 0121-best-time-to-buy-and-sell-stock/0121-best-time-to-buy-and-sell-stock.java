class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int buy = prices[0];
        for(int i=1;i<n;i++) {
            int profit = prices[i] - buy;
            maxProfit = Math.max(profit,maxProfit);
            buy = Math.min(buy,prices[i]);
        }
        return maxProfit;
    }
}