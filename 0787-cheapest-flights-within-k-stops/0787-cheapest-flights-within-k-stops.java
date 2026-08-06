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











// class Pair{
//     int stops;
//     int node;
//     int dist;
//     public Pair(int stops,int node,int dist) {
//         this.stops = stops;
//         this.node = node;
//         this.dist = dist;
//     }
// }


// class Solution {
//     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//         ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
//         for(int i=0;i<n;i++) {
//             adj.add(new ArrayList<>());
//         }

//         for(int i=0;i<flights.length;i++) {
//             int sr = flights[i][0];
//             int de = flights[i][1];
//             int wt = flights[i][2];
//             adj.get(sr).add(new Pair(0,de,wt));
//         }

//         Queue<Pair> q = new LinkedList<>();
//         int[] dist = new int[n];
//         Arrays.fill(dist,Integer.MAX_VALUE);
//         dist[src] = 0;

//         q.add(new Pair(0,src,0));
//         while(!q.isEmpty()) {
//             int s = q.peek().stops;
//             int nd = q.peek().node;
//             int d = q.peek().dist;
//             q.poll();
//             for(int i=0;i<adj.get(nd).size();i++) {
//                 Pair neig = adj.get(nd).get(i);
//                 int adjNode = neig.node;
//                 int edgeW = neig.dist;
//                 if(d + edgeW < dist[adjNode] && s<=k) {
//                     dist[adjNode] = d + edgeW;
//                     q.add(new Pair(s+1,adjNode,d+edgeW));
//                 }
//             }
//         }
//         if(dist[dst]==Integer.MAX_VALUE) return -1;
//         else return dist[dst];
//     }
// }