class Solution {
   public static int lcs(String s,String rev) {
        int n = s.length();
        int m = rev.length();

        int dp[][] = new int[n+1][m+1];

        // initilisation
        for(int i=0;i<n+1;i++) {
            dp[i][0] = 0;
        }
        for(int j=0;j<m+1;j++) {
            dp[0][j] = 0;
        }

        // code
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<m+1;j++) {
                if(s.charAt(i-1) == rev.charAt(j-1)) {
                    dp[i][j] = 1+ dp[i-1][j-1];
                }
                else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1,ans2);
                }
            }
        }
        return dp[n][m];
    }

    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        return lcs(s,rev);
    }
}