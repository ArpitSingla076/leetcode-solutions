class Pair{
    int node;
    double prob;
    Pair(int node,double prob) {
        this.node = node;
        this.prob = prob;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];
            adj.get(u).add(new Pair(v,p));
            adj.get(v).add(new Pair(u,p));
        }
        double[] ans = new double[n];
        ans[start] = 1;
        PriorityQueue<Pair>maxheap = new PriorityQueue<>((a,b) -> Double.compare(b.prob,a.prob));
        maxheap.add(new Pair(start,1));
        while(maxheap.size()>0) {
            Pair curr = maxheap.poll();
            int node = curr.node;
            double prob = curr.prob;
            if(prob<ans[node]) continue;
            for(Pair neig : adj.get(node)) {
                double totalprob = prob*neig.prob;
                if(ans[neig.node]<totalprob) {
                    ans[neig.node] = totalprob;
                    maxheap.add(new Pair(neig.node,totalprob));
                }
            }
        }
        return ans[end];
    }
}