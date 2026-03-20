class Solution {
    public int[] twoSum(int[] nums, int target) {
        // --- Brute force --- 
        // int n = nums.length;
        // for(int i=0;i<n;i++) {
        //     for(int j=i+1;j<n;j++) {
        //         if(nums[i] + nums[j] == target) {
        //             return new int [] {i,j};
        //         }
        //     }
        // }
        // return new int [] {0};

        // --- Better App --


        // -- Optimised App --
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            int sec = target - nums[i];
            if(map.containsKey(sec)) {
                return new int[]{i,map.get(sec)};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}