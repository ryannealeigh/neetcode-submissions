class Solution {
    public int maxProfit(int[] prices) {
        // sliding window
        int n = prices.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && prices[j] > prices[i]) {
                int diff = prices[j] - prices[i];
                max = Math.max(max, diff);
                j++;
            }
        }

        return max;
    }
}
