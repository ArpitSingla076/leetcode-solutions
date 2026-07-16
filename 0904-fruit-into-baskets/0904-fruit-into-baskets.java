class Solution {
    public int totalFruit(int[] fruits) {
        // -- Brute force --
        // int n = fruits.length;
        // int maxlen=0;
        // for(int i=0;i<n;i++) {
        //     HashSet<Integer>set = new HashSet<>();
        //     for(int j=i;j<n;j++) {
        //         set.add(fruits[j]);
        //         if(set.size()<=2) {
        //             maxlen = Math.max(maxlen,j-i+1);
        //         }
        //         else{
        //             break;
        //         }
        //     }
        // }
        // return maxlen;

        // -- Optimal Sol(Sliding window) --
        int n = fruits.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxlen = 0;
        int l = 0;
        for (int r=0;r<n;r++) {
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
            while(map.size()>2) {
                map.put(fruits[l],map.get(fruits[l])-1);
                if(map.get(fruits[l])==0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            maxlen = Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}