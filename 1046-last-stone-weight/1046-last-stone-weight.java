class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
      //  PriorityQueue<Integer>maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer>maxheap = new PriorityQueue<>((a,b) -> b - a);
        for(int i=0;i<n;i++) {
            maxheap.add(stones[i]);
        }
        while(maxheap.size()>1) {
            int v1 = maxheap.poll();
            int v2 = maxheap.poll();
            if(v1!=v2) maxheap.add(v1-v2);
        }
        return maxheap.isEmpty()?0:maxheap.peek();
    }
}