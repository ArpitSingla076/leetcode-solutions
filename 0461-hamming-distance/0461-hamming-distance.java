class Solution {
    public int hammingDistance(int x, int y) {
        int n = x^y;
        int cnt=0;
        for(int i=0;i<31;i++) {
            if((n>>i)%2==1) cnt++;
        }
        return cnt;
    }
}