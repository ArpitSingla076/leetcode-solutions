class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        // initialise
        dp[0] = 1;

        // kaam
        for(int i=1;i<=n;i++) {
            if(i==1) {
                dp[i] = dp[i-1];
            }
            else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
}