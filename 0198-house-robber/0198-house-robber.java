class Solution {
    public int find(int[]nums,int i,int dp[]) {
        int n = nums.length;
        if(i==0)return nums[i];
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int pick = nums[i] + find(nums,i-2,dp);
        int notpick = 0 + find(nums,i-1,dp);
        return dp[i] = Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
       int n = nums.length;
       int dp[] = new int[n+1];
       Arrays.fill(dp,-1);
       return find(nums,n-1,dp);
    }
}