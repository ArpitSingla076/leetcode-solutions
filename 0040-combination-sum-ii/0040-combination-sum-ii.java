class Solution {
    public void helper(int[] candidates,int target,List<List<Integer>> ans, List<Integer>sub,int i) {
        // base case 
        if(target==0) {
            ans.add(new ArrayList<>(sub));
            return;
        }

        if(i==candidates.length || target<0) return;

        // take
        sub.add(candidates[i]);
        helper(candidates,target-candidates[i],ans,sub,i+1);

        // backtrack
        sub.remove(sub.size()-1);

        // skipping duplicates
        int idx=i+1;
        while(idx<candidates.length && candidates[idx]==candidates[idx-1]) idx++;

        // not take
        helper(candidates,target,ans,sub,idx);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>sub = new ArrayList<>();
        helper(candidates,target,ans,sub,0);
        return ans;
    }
}