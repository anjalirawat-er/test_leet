class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans =new ArrayList<>();
        if(nums == null || nums.length == 0) return ans;

        permutations(nums, 0, ans);
        return ans;

    }  
    private void permutations(int[] nums, int i, List<List<Integer>> ans) {
        Set<Integer> set = new HashSet<>(); // for the particular recursion call

        if(i == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for(int num: nums) temp.add(num);

            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int c = i; c < nums.length; c++) { 
            if(set.contains(nums[c])) continue;

            // if not in the set
            set.add(nums[c]);

            swap(nums, i, c);

            permutations(nums, i + 1, ans);

            swap(nums, i, c);   // undo
        }
    }

    private void swap(int[] nums, int i, int c) {
            int temp = nums[i];
            nums[i] = nums[c];
            nums[c] = temp;
        }
}