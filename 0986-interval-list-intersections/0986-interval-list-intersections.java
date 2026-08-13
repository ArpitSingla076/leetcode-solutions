class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]>ans = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<A.length && j<B.length) {
            // find intersection
            int start = Math.max(A[i][0],B[j][0]);
            int end = Math.min(A[i][1],B[j][1]);

            // if overlap
            if(start<=end) {
                ans.add(new int[]{start,end});
            }

            // move the interval that finishes first
            if(A[i][1]<B[j][1]) {
                i++;
            }
            else{
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}