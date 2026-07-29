class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if(n>m) return false;
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer>map2 = new HashMap<>();

        for(int i=0;i<n;i++) {
            char ch = s1.charAt(i);
            char ch2 = s2.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
            map2.put(ch2,map2.getOrDefault(ch2,0)+1);
        }
        if(map1.equals(map2)) return true;

        int l=0;
        int r=0;
        for(r=n;r<m;r++) {
            char charRight = s2.charAt(r);
            map2.put(charRight,map2.getOrDefault(charRight,0)+1);

            char charleft = s2.charAt(l);
            map2.put(charleft,map2.get(charleft)-1);

            if(map2.get(charleft)==0) {
                map2.remove(charleft);
            }
            l++;

            if(map1.equals(map2)) return true;
        }
        return false;
    }
}








