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
        int n = s.length();
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z' || ch>='0' && ch<='9') {
                sb.append(ch);
            }
        }
        String res = sb.toString();
        if(isPalin(res)) return true;
        else return false;
    }
}