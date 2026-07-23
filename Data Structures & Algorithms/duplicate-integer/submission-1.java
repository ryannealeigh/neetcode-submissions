class Solution {
    public boolean hasDuplicate(int[] nums) {
        // count all with map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > 1) {
                return true;
            }
        }

        return false;
    }
}
