class Solution {
    public int calFib(int n, int[] dp) {
        if(n==1 || n==0) return n;
        if(dp[n]!=0) return dp[n];
        // dp[n] = calFib(n-1,dp) + calFib(n-2,dp);
        // return dp[n];
        return dp[n] = calFib(n-1,dp) + calFib(n-2,dp);
    }

    public int fib(int n) {
        int dp[] = new int[n+1];
        return calFib(n,dp);
    }
}