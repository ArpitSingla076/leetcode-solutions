class Solution {
    public int removeDuplicates(int[] nums) {
        // int n = nums.length;
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int val : nums) {
        //     map.put(val,map.getOrDefault(val,0)+1);
        // }
        // int idx = 0;
        // for(int key : map.keySet()) {
        //     nums[idx++] = key;
        // }
        // return idx;

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