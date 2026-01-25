class Solution {
    public int minimumDifference(int[] nums, int k) {
        int minDiff=Integer.MAX_VALUE;
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i+k<=n;i++){
            minDiff=Math.min(minDiff,nums[i+k-1]-nums[i]);
        }
        return minDiff;
    }
}