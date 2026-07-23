class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window

        int i = 0;
        int max = 0;
        int n = s.length();
        Map<Character, Integer> counts = new HashMap<>();
        int j = 0;

        while (j < n) {
            char c = s.charAt(j);
            counts.put(c, counts.getOrDefault(c, 0) + 1);

            while (counts.get(c) > 1 && i < n) {
                char start = s.charAt(i);
                counts.put(start, counts.get(start) - 1);
                i++;
            }
            max = Math.max(max, (j - i) + 1);
            j++;
        }

        return max;
    }
}
