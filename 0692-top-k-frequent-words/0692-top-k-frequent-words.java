class Pair{
    int freq;
    String str;
    Pair(int freq,String str) {
        this.freq = freq;
        this.str = str;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<Pair> minheap = new PriorityQueue<>((a,b) -> {
            if(a.freq != b.freq) return a.freq - b.freq;
            return b.str.compareTo(a.str); // reverse lexicographical
        });

        for(String key : map.keySet()) {
            minheap.add(new Pair(map.get(key),key));
            if(minheap.size()>k) {
                minheap.poll();
            }
        }
        while(minheap.size()>0) {
            ans.add(minheap.poll().str);
        }
        Collections.reverse(ans);
        return ans;
    }
}