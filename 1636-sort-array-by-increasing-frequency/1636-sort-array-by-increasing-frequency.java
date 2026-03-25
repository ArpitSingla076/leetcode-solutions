class Solution {
    class Pair{
        int freq;
        int val;
        Pair(int freq,int val) {
            this.freq = freq;
            this.val = val;
        }
    }

    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        PriorityQueue<Pair> minheap = new PriorityQueue<>((a,b) -> {
            if(a.freq != b.freq) return a.freq - b.freq;
            return b.val - a.val;
        });

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : nums) {
            map.put(val,map.getOrDefault(val,0)+1);
        }

        for(int key : map.keySet()) {
            minheap.add(new Pair(map.get(key),key));
        }

        int idx=0;
        while(minheap.size()>0) {
            Pair p = minheap.remove();
            int freq = p.freq;
            int val =  p.val;

            for(int i=0;i<freq;i++) {
                ans[idx++] = val;
            }
        }
        return ans;
    }
}