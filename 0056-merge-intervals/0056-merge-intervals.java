class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        List<int[]>ans = new ArrayList<>();
        int currst = intervals[0][0];
        int currend = intervals[0][1];
        for(int i=1;i<intervals.length;i++) {
            // overlap
            if(intervals[i][0]<=currend) {
                currend = Math.max(currend,intervals[i][1]);
            }

            // no overlap
            else{
                ans.add(new int[]{currst,currend});

                currst = intervals[i][0];
                currend = intervals[i][1];
            }
        }
        // add last interval
        ans.add(new int[]{currst,currend});
        
        return ans.toArray(new int[ans.size()][]);
    }
}