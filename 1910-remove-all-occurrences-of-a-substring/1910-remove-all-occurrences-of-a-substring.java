class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.length()>0 && sb.indexOf(part) != -1) {
            sb.delete(sb.indexOf(part),sb.indexOf(part) + part.length());
        }
        return sb.toString();
    }
}