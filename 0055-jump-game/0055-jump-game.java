class Solution {
    public boolean canJump(int[] nums) {
        int maxidx = 0;
        int n = nums.length;
        for(int i=0;i<n;i++) {
            if(i>maxidx) return false;

            // Update the farthest reachable index
            maxidx= Math.max(maxidx,i+nums[i]);
        }
        return true;
    }
}