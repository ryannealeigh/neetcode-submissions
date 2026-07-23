class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // count up the numbers in a map -> O(N)
        // take a list of all the unique numbers sorted by frequency -> O(nlogn)
        // return top k of the list
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer> unique = new ArrayList<>(count.keySet());
        Collections.sort(unique, (a,b) -> count.get(b).compareTo(count.get(a)));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = unique.get(i);
        }

        return result;
    }
}
