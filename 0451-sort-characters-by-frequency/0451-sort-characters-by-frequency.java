class Solution {
    class Pair{
        int freq;
        char ch;

        Pair(int freq,char ch) {
            this.freq = freq;
            this.ch = ch;
        }
    }

    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Pair> maxheap = new PriorityQueue<>((a,b) -> {
            if(a.freq != b.freq) return b.freq - a.freq;
            return a.ch - b.ch;
        });

        for(char key : map.keySet()) {
            maxheap.add(new Pair(map.get(key),key));
        }

        while(maxheap.size()>0) {
            Pair p = maxheap.remove();
            for(int i=0;i<p.freq;i++) {
                sb.append(p.ch);
            }
        }
        return sb.toString();
    }
}