class Solution {
    class Pair{
        int freq;
        int val;
        Pair(int freq,int val) {
            this.freq = freq;
            this.val = val;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        PriorityQueue<Pair> minheap = new PriorityQueue<>((a,b) -> {
            if(a.freq != b.freq) return a.freq - b.freq;
            return a.val - b.val;
        });
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : nums) {
            map.put(val,map.getOrDefault(val,0)+1);
        }

        for(int key:map.keySet()) {
            minheap.add(new Pair(map.get(key),key));
            if(minheap.size()>k) {
                minheap.remove();
            }
        }

        int idx=0;
        while(minheap.size()>0) {
            ans[idx++] = minheap.remove().val;
        }
        return ans;

    }
}