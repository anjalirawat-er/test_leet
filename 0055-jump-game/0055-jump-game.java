class Solution {
    public boolean canJump(int[] nums) {
        int counter = 1;
        for(int i = 0; i < nums.length; i++){
            if(counter < 1) return false;
            counter = Math.max(counter - 1, nums[i]);
        }
        return true;
    }
}