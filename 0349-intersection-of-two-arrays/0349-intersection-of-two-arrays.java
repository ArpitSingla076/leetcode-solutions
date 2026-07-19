class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums1) {
            set.add(val);
        }

        List<Integer>ans = new ArrayList<>();
        for(int val : nums2) {
            if(set.contains(val)) {
                ans.add(val);
                set.remove(val);
            }
        }
        int[] res = new int[ans.size()];
        for(int i=0;i<ans.size();i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}