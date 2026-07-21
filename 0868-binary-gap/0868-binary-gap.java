class Solution {
    public int binaryGap(int n) {
        int maxGap = 0;
        int lastIndex = -1;
        int currentIndex = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (lastIndex != -1) {
                    maxGap = Math.max(maxGap, currentIndex - lastIndex);
                }
                lastIndex = currentIndex;
            }   
            n >>= 1;
            currentIndex++;
        }
        return maxGap;
    }
}
