class Solution {
    public int longestSubarray(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int maxLen=0;
        int currLen=0;
        for(int i:nums){
            if(i==max){
                currLen++;
            }else{
                maxLen=Math.max(currLen,maxLen);
                currLen=0;
            }
        }
        return Math.max(currLen,maxLen);
    }
}