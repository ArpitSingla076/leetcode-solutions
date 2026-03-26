class Solution {
    public boolean isPalin(String a) {
        StringBuilder sb = new StringBuilder(a);
        // sb.reverse();
        // String res = sb.toString();
        // if(res.equals(a)) {
        //     return true;
        // }
        // return false;
        return sb.reverse().toString().equals(a);
    }
    
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i=0;i<n;i++) {
            char ch = s.charAt(i);
            if(( ch>='a' && ch<='z') || (ch>='0' && ch<='9')) {
                sb.append(ch);
            }
        }
        String res = sb.toString();
        if(isPalin(res)) return true;
        return false;
    }
}