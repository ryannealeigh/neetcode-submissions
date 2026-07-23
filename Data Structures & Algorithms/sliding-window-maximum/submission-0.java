class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // max heap should solve this,
        // if we have to add or remove it will be log(n)
        // if we want to grab max item, it's going to be O(1)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        HashMap<Integer, Integer> counts = new HashMap<>();
        int n = nums.length;
        int start = 0;

        int max = nums[0];
        int[] result = new int[n - k + 1];
        int z = 0;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            maxHeap.add(curr);
            max = Math.max(max, curr);

            while (i - start + 1 > k) {
                // window too big, shrink from start
                int st = nums[start++];
                maxHeap.remove(st);
                max = maxHeap.peek();
            }
            if (i - start + 1 == k) {
                // window correct size, record max
                result[z++] = max;
            }
        }
        return result;
    }
}
