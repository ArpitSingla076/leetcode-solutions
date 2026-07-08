class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            int fst = nums[i];
            int sec = target-nums[i];
            if(map.containsKey(sec)) {
                return new int[]{i,map.get(sec)};
            }
            map.put(nums[i],i);
        }
        return new int[]{0,0};
    }
}