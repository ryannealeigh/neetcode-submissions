class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // look through input, count characters, if count arrays are same, add to same list
        // could use a Map<Character[], List<String>> and transform to List<List<String>> at end

        Map<String, List<String>> ans = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(count);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }

            ans.get(key).add(s);
        }

        return new ArrayList<>(ans.values());
    }
}
