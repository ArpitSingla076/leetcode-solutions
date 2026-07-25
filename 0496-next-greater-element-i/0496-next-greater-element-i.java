class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        HashMap<Integer,Integer> map = new HashMap<>(); // (nums2[i],NGE)
        Stack<Integer>st = new Stack<>();
        for(int i=m-1;i>=0;i--) {
            while(st.size()>0 && st.peek()<=nums2[i]) {
                st.pop();
            }
            if(st.size()==0) map.put(nums2[i],-1);
            else map.put(nums2[i],st.peek());
            st.push(nums2[i]);
        }
        int idx=0;
        int[] ans = new int[n];
        for(int i=0;i<n;i++) {
            ans[idx++] = map.get(nums1[i]);
        }
        return ans;
    }
}