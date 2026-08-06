class Pair{
    int node;
    int dist;
    int stops;
    Pair(int node,int dist,int stops) {
        this.node = node;
        this.dist = dist;
        this.stops = stops;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] edges, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++) {
            int sr = edges[i][0];
            int dest = edges[i][1];
            int cost = edges[i][2];
            adj.get(sr).add(new Pair(dest,cost,0));
        }
        PriorityQueue<Pair>minheap = new PriorityQueue<>((a,b) -> a.stops-b.stops);
        int[] ans = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src] = 0;
        minheap.add(new Pair(src,0,0));
        while(minheap.size()>0) {
            Pair curr = minheap.poll();
            int node = curr.node;
            int dist = curr.dist;
            int stops = curr.stops;
            for(Pair neig : adj.get(node)) {
                int totaldis = dist+neig.dist;
                if(totaldis<ans[neig.node] && stops<=k) {
                    ans[neig.node] = totaldis;
                    minheap.add(new Pair(neig.node,totaldis,stops+1));
                }
            }
        }
        return ans[dst]==Integer.MAX_VALUE?-1:ans[dst];
    }
}