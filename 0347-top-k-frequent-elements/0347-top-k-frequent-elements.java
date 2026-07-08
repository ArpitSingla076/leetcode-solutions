class Pair{
    int freq;
    int val;
    Pair(int freq,int val) {
        this.freq = freq;
        this.val = val;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : nums) {
            map.put(val,map.getOrDefault(val,0)+1);
        }

        PriorityQueue<Pair> minheap = new PriorityQueue<>((a,b) -> {
            if(a.freq != b.freq) return a.freq-b.freq;
            else return a.val - b.val;
        });

        for(int key : map.keySet()) {
            minheap.add(new Pair(map.get(key),key));
            if(minheap.size()>k) {
                minheap.poll();
            }
        }

        int idx=0;
        while(minheap.size()>0) {
            ans[idx++] = minheap.poll().val;
        }
        return ans;
    }
}