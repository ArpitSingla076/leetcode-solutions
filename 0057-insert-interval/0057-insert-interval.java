class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]>ans = new ArrayList<>();
        for(int[] curr : intervals) {
            // if curr interval is completely before new interval
            if(curr[1]<newInterval[0]) {
                ans.add(curr);
            }
            // if curr is completely after new interval
            else if(curr[0]>newInterval[1]) {
                ans.add(newInterval);
                newInterval = curr;
            }
            else{
                // overlap -> merge
                newInterval[0] = Math.min(curr[0],newInterval[0]);
                newInterval[1] = Math.max(curr[1],newInterval[1]);
            }
        }
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}