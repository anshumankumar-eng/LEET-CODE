class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;
        
        int q1 = 0, q2 = 0;
        int sum1 = 0, sum2 = 0;
        
        for (int i = 0; i < half; i++) {
            char c = num.charAt(i);
            if (c == '?') q1++;
            else sum1 += c - '0';
        }
        
        for (int i = half; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') q2++;
            else sum2 += c - '0';
        }
        
        int totalQ = q1 + q2; 
        if (totalQ % 2 == 1) return true; 
        int diff = sum1 - sum2;
        int target = 9 * (q2 - q1) / 2;
        return diff != target;


    }
}


