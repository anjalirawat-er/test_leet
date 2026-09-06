class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] lows = new int[n];  // lows[i] = min(nums[i:])
        lows[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--)
            lows[i] = Math.min(nums[i], lows[i + 1]);

        int high = nums[0];  // high = max(nums[:i+1])
        for (int i = 0; i < n; i++) {
            high = Math.max(high, nums[i]);
            if (high - lows[i] <= k)
                return i;
        }

        return -1;
    }
}