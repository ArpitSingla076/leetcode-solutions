class Pair{
    int soldiers;
    int row;
    Pair(int soldiers,int row) {
        this.soldiers = soldiers;
        this.row = row;
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[k];
        PriorityQueue<Pair>maxheap = new PriorityQueue<>((a,b) -> {
            if(a.soldiers != b.soldiers) return b.soldiers - a.soldiers;
            else return b.row - a.row;
        });

        for(int i=0;i<m;i++) {
            int count=0;
            for(int j=0;j<n;j++) {
                if(mat[i][j]==1) {
                    count++;
                }
            }
            maxheap.add(new Pair(count,i));

            if(maxheap.size()>k) {
                maxheap.poll();
            }
        }

        int idx=k-1;   
        while(maxheap.size()>0) {
            ans[idx--] = maxheap.poll().row;
        }
        return ans; 
    }
}