class Solution {
    public int trap(int[] h) {
        // pre process left and right, tracking max column seen thus far
        int n = h.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            left[i] = max;
            max = Math.max(max, h[i]);
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = max;
            max = Math.max(max, h[i]);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (Math.min(left[i], right[i]) > h[i]) {
                sum += (Math.min(left[i], right[i]) - h[i]);
            }
        }
        return sum;
    }
}
