class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count=0;
        int[]prefixsum = new int[n];
        prefixsum[0] = nums[0];
        for(int i=1;i<n;i++) {
            prefixsum[i] = prefixsum[i-1] + nums[i];
        }

        HashMap<Integer,Integer> map = new HashMap<>(); // (PS,Freq)
        for(int j=0;j<n;j++) {
            if(prefixsum[j]==k) count++;

            int key = prefixsum[j]-k;
            if(map.containsKey(key)) {
                count+=map.get(key);
            }
            // Store current prefix sum
            map.put(prefixsum[j], map.getOrDefault(prefixsum[j], 0) + 1); 
        }
        return count; 
    }
}