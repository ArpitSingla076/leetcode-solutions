class Solution {
    public int minAddToMakeValid(String s) {
        int size=0; // it tells how much closing bracket i need
        int open=0; // it tells how much opening bracket i need
        for(char ch : s.toCharArray()) {
            if(ch=='(') size++;
            else if(size>0)size--;
            else open++;
        }
        return open+size;
    }
}