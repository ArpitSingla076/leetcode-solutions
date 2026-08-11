// -- brute force --
// class Solution {
//     public int kthSmallest(int[][] matrix, int k) {
//         int n = matrix.length;
//         int[] ans = new int[n*n];
//         int idx=0;
//         for(int i=0;i<n;i++) {
//             for(int j=0;j<n;j++) {
//                 ans[idx++] = matrix[i][j];
//             }
//         }
//         Arrays.sort(ans);
//         return ans[k-1];
//     }
// }


// -- Optimal App(using heap) --
class Pair{
    int val;
    int row;
    int col;
    Pair(int val,int row,int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
       int n = matrix.length;
       PriorityQueue<Pair>minheap = new PriorityQueue<>((a,b) -> a.val - b.val);

       // put first element of each row
       for(int i=0;i<n;i++) {
        minheap.add(new Pair(matrix[i][0],i,0));
       }

       int count=0;
       int ans=0;
       while(count<k) {
        Pair curr = minheap.poll();
        ans = curr.val;
        
        // Put next element from same row
        if(curr.col+1<matrix[curr.row].length) {
            int nextval = matrix[curr.row][curr.col+1];
            minheap.add(new Pair(nextval,curr.row,curr.col+1));
        }
        count++;
       }
       return ans;
    }
}