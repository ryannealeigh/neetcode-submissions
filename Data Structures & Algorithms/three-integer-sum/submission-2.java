class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> results = new HashSet<>();
        Arrays.sort(nums);

        if (nums[0] > 0) {
            return List.of();
        }

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            int target = 0 - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    results.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                }
                if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.addAll(results);
        return res;
    }
}
