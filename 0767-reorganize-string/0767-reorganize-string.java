class Pair{
    char ch;
    int freq;
    Pair(char ch,int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}
class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Pair>maxheap = new PriorityQueue<>((a,b) -> b.freq - a.freq);

        for(char ch : map.keySet()) {
            maxheap.add(new Pair(ch,map.get(ch)));
        }
        StringBuilder ans = new StringBuilder();

        Pair prev = null;
        while(maxheap.size()>0) {
            Pair curr = maxheap.poll();
            ans.append(curr.ch);
            curr.freq--;
            if(prev!=null && prev.freq>0) {
                maxheap.add(prev);
            }
            prev = curr;
        }
        // Couldn't use all characters
        if(ans.length() != s.length()) {
            return "";
        }
        return ans.toString();
    }
}