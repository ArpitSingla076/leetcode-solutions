// -- this is recursive --
// class Solution {
//     public int maxamt(int i,int[] nums) {
//         if(i==0) return nums[0];
//         if(i==1) return Math.max(nums[0],nums[1]);
//         return Math.max(nums[i] + maxamt(i-2,nums) , maxamt(i-1,nums)); 
//     }

//     public int rob(int[] nums) {
//         int n = nums.length;
//         return maxamt(n-1,nums);
//     }
// }


// -- this is memoization --
// class Solution {
//     public int maxamt(int i,int[] nums,int[] dp) {
//         if(i==0) return nums[0];
//         if(i==1) return Math.max(nums[0],nums[1]);
//         if(dp[i]!=-1) return dp[i];
//         return dp[i] =  Math.max(nums[i] + maxamt(i-2,nums,dp) , maxamt(i-1,nums,dp)); 
//     }

//     public int rob(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp,-1);
//         return maxamt(n-1,nums,dp);
//     }
// }


// -- this is tabulation --
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if(n==1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++) {
            dp[i] = Math.max(nums[i] + dp[i-2] , dp[i-1]);
        }
        return dp[n-1];
    }
}