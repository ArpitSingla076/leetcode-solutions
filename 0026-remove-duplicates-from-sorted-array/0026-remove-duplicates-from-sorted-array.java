class Solution {
    public int removeDuplicates(int[] nums) {
        // -------- Using Map ----------------
        // int n = nums.length;
        // LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        // for(int val : nums) {
        //     map.put(val,map.getOrDefault(val,0)+1);
        // }
        // int idx = 0;
        // for(int key : map.keySet()) {
        //     nums[idx++] = key;
        // }
        // return idx;

        // -------- using Set --------------
        // int n = nums.length;
        // LinkedHashSet<Integer> set = new LinkedHashSet<>();
        // for(int val : nums) {
        //     set.add(val);
        // }
        // int idx=0;
        // for(int val : set) {
        //     nums[idx++] = val;
        // }
        // return set.size();


    // --- Two Pointer App --
        int n = nums.length;
        int i=0;
        for(int j=1;j<n;j++) {
            if(nums[i]<nums[j]) {
                int temp = nums[i+1];
                nums[i+1] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return i+1;
    }
}