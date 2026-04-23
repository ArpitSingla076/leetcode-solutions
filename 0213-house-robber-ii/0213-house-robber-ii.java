class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);

        // case 1 : 0 to n-2 (ignore last house)
        int dp1[] = new int[n];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<=n-2;i++) {
            dp1[i] = Math.max(nums[i] + dp1[i-2],dp1[i-1]);
        }
        int case1 = dp1[n-2];

        // case 2 : 1 to n-1 (ignore first house)
        int dp2[] = new int[n];
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[1],nums[2]);
        for(int i=3;i<=n-1;i++) {
            dp2[i] = Math.max(nums[i] + dp2[i-2],dp2[i-1]);
        }
        int case2 = dp2[n-1];
        return Math.max(case1,case2);
    }
}