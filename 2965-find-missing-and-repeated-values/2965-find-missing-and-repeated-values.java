class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        HashSet<Integer> set = new HashSet<>();
        int repeated = -1;
        int missing = -1;
        int size = n*n;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(set.contains(grid[i][j])) {
                    repeated = grid[i][j];
                }
                else{
                    set.add(grid[i][j]);
                }
            }
        }
        for(int i=1;i<=size;i++) {
            if(!set.contains(i)) {
                missing = i;
                break;
            }
        }
        return new int[]{repeated,missing};
    }
}