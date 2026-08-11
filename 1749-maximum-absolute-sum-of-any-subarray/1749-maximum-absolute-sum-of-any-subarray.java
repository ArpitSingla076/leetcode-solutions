class Solution {
    public int maxsum(int[] nums) {
        int n = nums.length;
        int bestend = nums[0];
        int maxsum = nums[0];
        for(int i=1;i<n;i++) {
            int v1 = bestend + nums[i];
            int v2 = nums[i];
            bestend = Math.max(v1,v2);
            maxsum = Math.max(maxsum,bestend);
        }
        return maxsum;
    }

    public int minsum(int[] nums) {
        int n = nums.length;
        int bestend = nums[0];
        int minsum = nums[0];
        for(int i=1;i<n;i++) {
            int v1 = bestend + nums[i];
            int v2 = nums[i];
            bestend = Math.min(v1,v2);
            minsum = Math.min(minsum,bestend);
        }
        return minsum;
    }
    
    public int maxAbsoluteSum(int[] nums) {
        return Math.max(Math.abs(maxsum(nums)),Math.abs(minsum(nums)));
    }
}