class Solution {

    public boolean[] pathExistenceQueries(
        int n,
        int[] nums,
        int maxDiff,
        int[][] queries
    ) {
        List<Integer> rights = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                rights.add(i - 1);
            }
        }
        rights.add(n - 1);

        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];

            int idxX = lowerBound(rights, x);
            int idxY = lowerBound(rights, y);
            res[i] = idxX == idxY;
        }
        return res;
    }

    private int lowerBound(List<Integer> list, int target) {
        int left = 0,
            right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}