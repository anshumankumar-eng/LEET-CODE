class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int n = s.length();
        int i = 0;
        while (i < n) { 
            int start = i;
            while (i < n && s.charAt(i) != ' ') {
                i++;
            } 
            for (int j = i - 1; j >= start; j--) {
                result.append(s.charAt(j));
            } 
            if (i < n) {
                result.append(' ');
                i++;  
            }
        }
        return result.toString();
    }
}