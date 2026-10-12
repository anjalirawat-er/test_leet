class Solution {
    private static final int MOD = 1_000_000_007;
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCount = new int[31];
        for (int num : nums) {
            for (int b = 0; b < 31; b++) {
                if (((num >> b) & 1) == 1) {
                    bitCount[b]++;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < k; i++) {
            long val = 0;

            for (int b = 0; b < 31; b++) {
                if (bitCount[b] > i) {
                    val |= (1L << b);
                }
            }
            ans = (ans + val * val % MOD) % MOD;
        }
        return (int) ans;
    }
}