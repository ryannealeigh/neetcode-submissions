class Solution {
    public String minWindow(String s, String t) {
        HashSet<Character> unique = new HashSet<>();
        int[] counts = new int[256];

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            unique.add(c);
            counts[c]++;
        }

        int i = 0;
        int n = s.length();
        HashSet<Character> found = new HashSet<>();
        String min = "";
        for (int j = 0; j < n; j++) {
            char c = s.charAt(j);
            counts[c]--;
            if (counts[c] == 0) {
                found.add(c);
            }
            while (found.equals(unique)) {
                if (min.length() > 0 && j - i + 1 < min.length() || min.length() == 0) {
                    min = s.substring(i, j + 1);
                }
                char st = s.charAt(i++);
                counts[st]++;
                if (counts[st] > 0) {
                    found.remove(st);
                }
            }
        }

        return min;
    }
}
