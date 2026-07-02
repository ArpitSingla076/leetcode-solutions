class Solution {
    public int lastStoneWeight(int[] stones) {
      //  PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> b-a);
        int n = stones.length;
        for(int val : stones) {
            maxheap.add(val);
        }
        while(maxheap.size()>1) {
            int v1 = maxheap.poll();
            int v2 = maxheap.poll();
            if(v1!=v2) maxheap.add(v1-v2);
        }
        return maxheap.isEmpty()? 0 : maxheap.peek();
    }
}