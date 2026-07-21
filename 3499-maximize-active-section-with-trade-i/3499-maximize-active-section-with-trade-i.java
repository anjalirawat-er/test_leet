import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int initialOnes = 0;
        List<Integer> zeroBlockLengths = new ArrayList<>();
        int i = 0;
        int n = s.length();

        while (i < n) {
            char ch = s.charAt(i);
            int len = 0;
            while (i < n && s.charAt(i) == ch) {
                len++;
                i++;
            }
            if (ch == '1') {
                initialOnes += len;
            } else {
                zeroBlockLengths.add(len);
            }
        }

        int maxZeroGain = 0;
        for (int j = 0; j < zeroBlockLengths.size() - 1; j++) {
            maxZeroGain = Math.max(maxZeroGain, zeroBlockLengths.get(j) + zeroBlockLengths.get(j + 1));
        }
        return initialOnes + maxZeroGain;
    }
}