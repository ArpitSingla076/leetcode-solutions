class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int l=0;
        int r=0;
        long sum=0;
        long maxsum=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(r=0;r<n;r++) {
            sum+=nums[r];
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            // window size>k
            if(r-l+1>k) {
                sum-=nums[l];
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])==0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            // window size==k
            if(r-l+1==k) {
                if(map.size()==k) {
                    maxsum = Math.max(maxsum,sum);
                }
            }
        }
        return maxsum;
    }
}