class Solution {
    class Pair{
        int dist;
        int x;
        int y;
        Pair(int dist,int x,int y) {
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<Pair> maxheap = new PriorityQueue<>((a,b) -> b.dist-a.dist);

        for(int i=0;i<points.length;i++) {
            int x = points[i][0];
            int y = points[i][1];
            int dist = x*x + y*y;
            maxheap.add(new Pair(dist,x,y));
            if(maxheap.size()>k) {
                maxheap.remove();
            }
        }
        int idx=0;
        while(maxheap.size()>0) {
            Pair p = maxheap.remove();
            int x = p.x;
            int y = p.y;
            ans[idx][0] = x;
            ans[idx][1] = y;
            idx++;
        }
        return ans;
    }
}