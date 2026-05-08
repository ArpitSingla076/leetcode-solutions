class Solution {
    public static int lcs(int nums[], int nums2[]) {
        // Write your code here
        int n = nums.length;
        int m = nums2.length;
        int[][] dp = new int[n+1][m+1];

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
                if(nums[i-1]==nums2[j-1]) {
                    dp[i][j] = 1+dp[i-1][j-1];
                } 
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int val : nums) {
            set.add(val);
        }

        int nums2[] = new int[set.size()];
        int idx = 0;
        for (int val : set) {
            nums2[idx++] = val;
        }
        Arrays.sort(nums2);
        return lcs(nums, nums2);
    }
}