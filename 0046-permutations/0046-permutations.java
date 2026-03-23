// --- Permutation using a visited array ---

class Solution {
    public void helper(int[]nums,List<Integer>sub,List<List<Integer>>ans,boolean[]isValid) {
        if(sub.size()==nums.length) {
            ans.add(new ArrayList<>(sub));
            return;
        }
        for(int i=0;i<nums.length;i++) {
            if(isValid[i]==false) { // call lagega
                sub.add(nums[i]);
                isValid[i] = true;
                helper(nums,sub,ans,isValid);
                isValid[i] = false; // backtrack
                sub.remove(sub.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        boolean[] isValid = new boolean[n];
        helper(nums,sub,ans,isValid);
        return ans;
    }
}