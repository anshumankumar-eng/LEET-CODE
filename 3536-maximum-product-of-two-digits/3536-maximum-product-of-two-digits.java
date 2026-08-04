class Solution {
    public int maxProduct(int n) {
        String s = Integer.toString(n);
        char[] digits = s.toCharArray();
        java.util.Arrays.sort(digits);  
        int A = digits[digits.length - 1] - '0';  
        int B = digits[digits.length - 2] - '0';

        return A * B;

    }
}