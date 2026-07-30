// -- Recursive -- 
// class Solution {
//     public int mincost(int i,int[] cost) {
//         if(i==0) return cost[0];
//         if(i==1) return cost[1];
//         return cost[i] + Math.min(mincost(i-1,cost),mincost(i-2,cost));
//     }
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         return Math.min(mincost(n-1,cost),mincost(n-2,cost));
//     }
// }


// -- memoization --
// class Solution {
//     public int mincost(int i,int[] cost,int[] dp) {
//         if(i==0) return cost[0];
//         if(i==1) return cost[1];
//         if(dp[i]!=-1) return dp[i];
//         return dp[i] = cost[i] + Math.min(mincost(i-1,cost,dp),mincost(i-2,cost,dp));
//     }
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         int[] dp = new int[n+1];
//         Arrays.fill(dp,-1);
//         return Math.min(mincost(n-1,cost,dp),mincost(n-2,cost,dp));
//     }
// }


// -- tabulation --
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2;i<n;i++) {
            dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}