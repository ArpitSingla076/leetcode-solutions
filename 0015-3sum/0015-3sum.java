class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // -- Brute force --
        // int n = nums.length;

        // Set<List<Integer>> set = new HashSet<>();
        // for (int i=0; i<n;i++) {
        //     for (int j=i+1; j<n;j++) {
        //         for (int k=j+1;k<n;k++) {
        //             List<Integer> temp = new ArrayList<>();
        //             if (nums[i] + nums[j] + nums[k] == 0) {
        //                 temp.add(nums[i]);
        //                 temp.add(nums[j]);
        //                 temp.add(nums[k]);
        //                 Collections.sort(temp);
        //                 set.add(temp);
        //             }
        //         }
        //     }
        // }
        // return new ArrayList<>(set);

        // -- Optimal Sol --
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++) {
        if(i>0 && nums[i]==nums[i-1]) continue;
        int j = i+1;
        int k = n-1;
        while(j<k) {
            int sum = nums[i] + nums[j] + nums[k];
            if(sum<0) {
                j++;
            }
            else if(sum>0) {
                k--;
            }
            else{
                List<Integer> sub = new ArrayList<>();
                sub.add(nums[i]);
                sub.add(nums[j]);
                sub.add(nums[k]);
                ans.add(sub);
                j++;
                k--;
                while(j<k && nums[j]==nums[j-1]) j++;
                while(j<k && nums[k]==nums[k+1]) k--;
            }
        }
    }
    return ans;
    }
}