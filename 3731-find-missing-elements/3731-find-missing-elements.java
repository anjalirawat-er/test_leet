class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        int small = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();

        for (int n : nums) {
            set.add(n);
            small = Math.min(small, n);
            max = Math.max(max, n);
        }

        for (int i = small; i <= max; i++) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }

        Collections.sort(res);
        return res;
    }
}