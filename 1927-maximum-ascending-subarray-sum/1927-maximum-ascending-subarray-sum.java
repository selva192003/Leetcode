class Solution {
    public int maxAscendingSum(int[] nums) {
        int currentSum = nums[0];
        int ans = currentSum;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) { 
                currentSum += nums[i];
            } 
            else { 
                currentSum = nums[i];
            }
            ans = Math.max(ans, currentSum);
        }    
        return ans; 
    }
}