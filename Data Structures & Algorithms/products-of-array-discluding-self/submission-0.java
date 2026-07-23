class Solution {
    public int[] productExceptSelf(int[] nums) {
        // from left to right, start with val = 1
        // multiply curr * val, save to result array i + 1
        // continue on until done with nums
        // from right to left, start with val = 1
        // multiply curr * val * result i, save to i - 1
        int[] res = new int[nums.length];
        int val = 1;
        res[0] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            val *= nums[i];
            res[i + 1] = val;
        }

        val = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            val *= nums[i];
            res[i - 1] *= val;
        }

        return res;
    }
}  
