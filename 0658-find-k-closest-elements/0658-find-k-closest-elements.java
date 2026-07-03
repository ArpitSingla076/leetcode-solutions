class Pair{
    int key;
    int val;
    Pair(int key,int val) {
        this.key = key;
        this.val = val;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> maxheap = new PriorityQueue<>((a,b) -> {
           if(a.key!=b.key) return b.key - a.key;
            else return b.val - a.val;
        });

        int n = arr.length;
        for(int i=0;i<n;i++) {
            int key = Math.abs(arr[i]-x);
            maxheap.add(new Pair(key,arr[i]));
            if(maxheap.size()>k) {
                maxheap.poll();
            }
        }

        while(maxheap.size()>0) {
            ans.add(maxheap.poll().val);
        }
        Collections.sort(ans);
        return ans;
    }
}