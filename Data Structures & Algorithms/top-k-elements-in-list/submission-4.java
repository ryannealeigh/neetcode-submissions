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
        List<Integer>[] freqs = new List[nums.length + 1];
        
        for (int i = 0; i < freqs.length; i++) {
            freqs[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freqs[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = freqs.length - 1; i >= 0 && index < k; i--) {
            for (int n : freqs[i]) {
                result[index++] = n;
                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }
}
