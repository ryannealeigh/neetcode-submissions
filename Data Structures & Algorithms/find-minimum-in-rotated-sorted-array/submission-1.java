class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        int min = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] < nums[r]) {
                // go left
                min = Math.min(min, nums[mid]);
                r = mid - 1;
            } else {
                min = Math.min(min, nums[mid]);
                l = mid + 1;
            }
        }

        return min;
    }
}
