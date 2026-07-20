class Pair{
    int dist;
    int x;
    int y;
    public Pair(int dist,int x,int y) {
        this.dist = dist;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int[][] res = new int[k][2];
        PriorityQueue<Pair> maxheap = new PriorityQueue<>((a,b)->b.dist - a.dist);
        for(int i=0;i<n;i++) {
            int x = points[i][0];
            int y = points[i][1];
            int dist = x*x + y*y;
            maxheap.add(new Pair(dist,x,y));
            if(maxheap.size()>k) {
                maxheap.poll();
            }
        }
        int idx=0;
        while(maxheap.size()>0) {
            Pair p = maxheap.poll();
            int x = p.x;
            int y = p.y;
            res[idx][0] = x;
            res[idx][1] = y;
            idx++;
        }
        return res;
    }
}