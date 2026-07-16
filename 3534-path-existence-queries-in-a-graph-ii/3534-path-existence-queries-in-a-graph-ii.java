import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[arr[i][1]] = i;
        }

        int LOG = 18;
        int[][] up = new int[LOG][n];

        up[0][n - 1] = n - 1;

        int r = 0;
        for (int l = 0; l < n; l++) {
            while (r + 1 < n && arr[r + 1][0] - arr[l][0] <= maxDiff) {
                r++;
            }
            up[0][l] = r;
        }

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {

            int a = pos[queries[qi][0]];
            int b = pos[queries[qi][1]];

            if (a > b) {
                int t = a;
                a = b;
                b = t;
            }

            if (a == b) {
                ans[qi] = 0;
                continue;
            }

            if (up[LOG - 1][a] < b) {
                ans[qi] = -1;
                continue;
            }

            int cur = a;
            int dist = 0;

            for (int k = LOG - 1; k >= 0; k--) {
                if (up[k][cur] < b) {
                    cur = up[k][cur];
                    dist += 1 << k;
                }
            }

            ans[qi] = dist + 1;
        }

        return ans;
    }
}