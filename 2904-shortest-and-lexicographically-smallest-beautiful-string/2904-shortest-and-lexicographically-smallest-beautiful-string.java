class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int minLen = Integer.MAX_VALUE;
        java.util.List<String> candidates = new java.util.ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int ones = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '1') ones++;
                if (ones == k) {
                    String sub = s.substring(i, j + 1);
                    int len = sub.length();
                    if (len < minLen) {
                        minLen = len;
                        candidates.clear();
                        candidates.add(sub);
                    } else if (len == minLen) {
                        candidates.add(sub);
                    }
                } else if (ones > k) {
                    break;
                }
            }
        }
        
        if (candidates.isEmpty()) return "";
        String best = candidates.get(0);
        for (String cand : candidates) {
            if (cand.compareTo(best) < 0) best = cand;
        }
        return best;
    }
}