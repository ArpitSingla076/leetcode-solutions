class Solution {
    // public int countways(int n,int[] dp) {
    //     if(n==0 || n==1) return 1;
    //     if(dp[n]!=-1) return dp[n];
    //     dp[n] = countways(n-1,dp) + countways(n-2,dp);
    //     return dp[n];
    // }
    public int climbStairs(int n) {
        // -- recursion -- 
        // if(n==0 || n==1) return 1;
        // return climbStairs(n-1) + climbStairs(n-2);

        // -- memoization --
        // int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // return countways(n,dp);

        // -- tabulation --
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}