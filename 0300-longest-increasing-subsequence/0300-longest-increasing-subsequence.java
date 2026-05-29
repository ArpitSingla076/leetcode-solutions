class Solution {
    public int lcs(int[]nums,int[]nums2) {
        int m = nums.length;
        int n = nums2.length;
        int[][] dp = new int[m+1][n+1];

        for(int i=1;i<m+1;i++) {
            for(int j=1;j<n+1;j++) {
                if(nums[i-1]==nums2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums) {
            set.add(val);
        }
        int[] nums2 = new int[set.size()];
        int idx=0;
        for(int val : set) {
            nums2[idx++] = val;
        }
        Arrays.sort(nums2);
        return lcs(nums,nums2);
    }
}