import java.util.Arrays;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[] countDivisors = new int[maxVal + 1];
        for (int num : nums) {
            countDivisors[num]++;
        }

        for (int d = 1; d <= maxVal; d++) {
            int totalMultiples = 0;
            for (int multiple = d; multiple <= maxVal; multiple += d) {
                totalMultiples += countDivisors[multiple];
            }

        }

        int[] multiples = new int[maxVal + 1];
        for (int num : nums) {
            multiples[num]++;
        }
        
        int[] countMultiples = new int[maxVal + 1];
        for (int d = 1; d <= maxVal; d++) {
            for (int multiple = d; multiple <= maxVal; multiple += d) {
                countMultiples[d] += multiples[multiple];
            }
        }

        long[] countGcdPair = new long[maxVal + 1];

        for (int g = maxVal; g >= 1; g--) {
            long totalPairsWithDivisorG = (long) countMultiples[g] * (countMultiples[g] - 1) / 2;
            
            for (int largerG = 2 * g; largerG <= maxVal; largerG += g) {
                totalPairsWithDivisorG -= countGcdPair[largerG];
            }
            countGcdPair[g] = totalPairsWithDivisorG;
        }

        long[] prefixCountGcdPair = new long[maxVal + 1];
        for (int g = 1; g <= maxVal; g++) {
            prefixCountGcdPair[g] = prefixCountGcdPair[g - 1] + countGcdPair[g];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = binarySearch(prefixCountGcdPair, queries[i]);
        }

        return ans;
    }

    private int binarySearch(long[] prefixSums, long targetIndex) {
        int low = 1;
        int high = prefixSums.length - 1;
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prefixSums[mid] > targetIndex) {
                result = mid; 
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}