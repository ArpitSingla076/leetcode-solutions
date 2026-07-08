class Solution {
    public boolean isPalin(String a) {
        int n = a.length();
        int i=0;
        int j=n-1;
        while(i<j) {
            if(a.charAt(i)!=a.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        int n = s.length();
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z' || ch>='0' && ch<='9') {
                sb.append(ch);
            }
        }
        String ans = sb.toString();
        if(isPalin(ans)) return true;
        else return false;
    }
}