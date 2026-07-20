class Solution {
    public int longestConsecutive(int[] nums) {
        // int n = nums.length;
        // if(n==0) return 0;
        // Arrays.sort(nums);
        // int len = 1;
        // int maxlen=1;
        // for(int i=0;i<n-1;i++) {
        //     if(nums[i]+1==nums[i+1]) {
        //         len++;
        //         maxlen = Math.max(len,maxlen);
        //     }
        //     else if(nums[i]==nums[i+1]) continue;
        //     else {
        //         len = 1;
        //     }
        // }
        // return maxlen;


        // -- using set --
        HashSet<Integer>set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int maxlen=0;
        for(int num : set) {
            // Start only if num is the beginning of a sequence
            if(!set.contains(num-1)) {
                int curr = num;
                int len=1;

                while(set.contains(curr+1)) {
                    curr++;
                    len++;
                }
                maxlen = Math.max(maxlen,len);
            }
        }
        return maxlen;
    }
}