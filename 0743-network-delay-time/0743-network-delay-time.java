class Pair{
    int node;
    int time;
    Pair(int node,int time) {
        this.node = node;
        this.time = time;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            adj.get(u).add(new Pair(v,w));
        }
        int[] ans = new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src] = 0;
        PriorityQueue<Pair>minheap = new PriorityQueue<>((a,b) -> a.time-b.time);
        minheap.add(new Pair(src,0));
        while(minheap.size()>0) {
            Pair curr = minheap.poll();
            int node = curr.node;
            int time = curr.time;
            if(time>ans[node]) continue;
            for(Pair neig : adj.get(node)) {
                int totaltime = time + neig.time;
                if(ans[neig.node]>totaltime) {
                    ans[neig.node] = totaltime;
                    minheap.add(new Pair(neig.node,totaltime));
                }
            }
        }
        int max=-1;
        for(int i=1;i<=n;i++) {
            if(ans[i]==Integer.MAX_VALUE) return -1;
            max = Math.max(max,ans[i]);
        }
        return max;
    }
}