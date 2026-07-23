class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // look through input, count characters, if count arrays are same, add to same list
        // could use a Map<Character[], List<String>> and transform to List<List<String>> at end

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = new char[26];
            for (int i = 0; i < str.length(); i++) {
                chars[str.charAt(i) - 'a']++;
            }
            StringBuilder counts = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                counts.append(i + 'a');
                counts.append(chars[i]);
            }
            List<String> list = map.getOrDefault(counts.toString(), new ArrayList<>());
            list.add(str);
            map.put(counts.toString(), list);
        }

        List<List<String>> results = new ArrayList<>();
        for (String key : map.keySet()) {
            results.add(map.get(key));
        }
        return results;
    }
}
