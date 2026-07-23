class Solution {
    public int maxArea(int[] heights) {
        // pointer at start and end
        // compare the two next inward bars and choose larger
        int i = 0;
        int j = heights.length - 1;

        int max = Integer.MIN_VALUE;
        while (i < j) {
            max = Math.max(max, Math.min(heights[i], heights[j]) * (j - i));
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
