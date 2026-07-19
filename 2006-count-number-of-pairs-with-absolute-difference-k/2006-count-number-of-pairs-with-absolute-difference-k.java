class Solution {
    public int countKDifference(int[] nums, int k) {
        // -- Brute force ---
        // int n = nums.length;
        // int count=0;
        // for(int i=0;i<n;i++) {
        //     for(int j=i+1;j<n;j++) {
        //         if(Math.abs(nums[i]-nums[j])==k) {
        //             count++;
        //         }
        //     }
        // }
        // return count;


        // -- using map --
        HashMap<Integer,Integer>map = new HashMap<>();
        int count=0;
        for(int val : nums) {
            if(k == 0){
                count += map.getOrDefault(val,0);
            }
            else{
                count += map.getOrDefault(val-k,0);
                count += map.getOrDefault(val+k,0);
            }
            map.put(val,map.getOrDefault(val,0)+1);

        }
        return count;
    }
}