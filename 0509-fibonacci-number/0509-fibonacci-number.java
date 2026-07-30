class Solution {
    // public int calfib(int n,int[] dp) {
    //     if(n==0 || n==1) return n;
    //     if(dp[n]!=-1) return dp[n];
    //     dp[n] = calfib(n-1,dp) + calfib(n-2,dp);
    //     return dp[n];
    // }

    public int fib(int n) {
        // -- recursive --
        // if(n==0 || n==1) return n;
        // return fib(n-1) + fib(n-2);

        // -- memoization --
        // int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // return calfib(n,dp);

        // -- tabulation --
        if(n==0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}