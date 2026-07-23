class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            counts[c - 'a']++;
        }

        int i = 0;
        int n = s2.length();
        for (int j = 0; j < n; j++) {
            char c = s2.charAt(j);
            counts[c - 'a']--;
            while (counts[c - 'a'] < 0) {
                char st = s2.charAt(i++);
                counts[st - 'a']++;
            }
            if (j - i + 1 == s1.length()) {
                return true;
            }
        }

        return false;
    }
}
