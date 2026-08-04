class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < nums.length; i++) {
            char currChar = nums[i].charAt(i);
            result.append(currChar == '0' ? '1' : '0');
        }
        
        return result.toString();
    }
}