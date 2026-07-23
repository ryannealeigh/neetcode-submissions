class Solution {
    public int longestConsecutive(int[] nums) {
        // subsequence means keep track of multiple possibilities
        // make a hashmap with keys as last element seen, with length
        // so look for curr val - 1 key and and 1 then
        // put curr val + old length into map
        Arrays.sort(nums);
        HashMap<Integer, Integer> lengths = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            lengths.put(val, lengths.getOrDefault(val - 1, 0) + 1);
        }

        int max = 0;
        for (Integer val : lengths.values()) {
            max = Math.max(max, val);
        }

        return max;
    }
}
