class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length;
        long right=0;
        for(int i=0;i<n;i++){
             right+=nums[i];
        }
        long left=0;
        int count=0;
        for(int i=0;i<n-1;i++){
            right=right-nums[i];
            left=left+nums[i];
            if(left>=right){
                count++;
            }
        }
// --First take sum of all elements in the array as for right
// --Next take another variable as zero for left
// --Next Iterate over nums array
// --decrease the right -nums[i]
// --increase the left +nums[i]
// --check left greater than right
// --increment the count
// -- and so you get the answer :)
return count;
    }
}