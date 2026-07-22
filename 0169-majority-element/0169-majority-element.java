class Solution {
    public int majorityElement(int[] nums) {
        // -- Brute foce --
        // int n = nums.length;
        // for(int i=0;i<n;i++) {
        //     int cnt=0;
        //     for(int j=0;j<n;j++) {
        //         if(nums[j]==nums[i]) cnt++;
        //     }
        //     if(cnt>n/2) return nums[i];
        // }
        // return -1;


        // -- Better App(using map) --
        // int n = nums.length;
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<n;i++) {
        //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        // }

        // for(int key : map.keySet()) {
        //     if(map.get(key)>n/2) {
        //         return key;
        //     }
        // }
        // return 0;


        // -- Moore's Voting Algo --
        int n = nums.length;
        int ans=0;
        int cnt=0;
        for(int i=0;i<n;i++) {
            if(cnt==0) {
                ans = nums[i];
                cnt=1;
            } 
            else if(ans==nums[i]) cnt++;
            else cnt--;
        }
        return ans;
    }
}