class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }

        int limit = 1;
        while (limit <= maxVal) {
            limit <<= 1;
        }

        boolean[] hasNum = new boolean[limit];
        for (int num : nums) {
            hasNum[num] = true;
        }

        boolean[] pairXor = new boolean[limit];
        for (int i = 0; i < limit; i++) {
            if (!hasNum[i]) continue;
            for (int j = i; j < limit; j++) {
                if (hasNum[j]) {
                    pairXor[i ^ j] = true;
                }
            }
        }

        boolean[] tripletXor = new boolean[limit];
        for (int px = 0; px < limit; px++) {
            if (!pairXor[px]) continue;
            for (int num = 0; num < limit; num++) {
                if (hasNum[num]) {
                    tripletXor[px ^ num] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < limit; i++) {
            if (tripletXor[i]) {
                count++;
            }
        }

        return count;
    }
}