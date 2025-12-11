class Solution {
    public int missingInteger(int[] nums) {
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                ans+=nums[i];
            }else{
                break;
            }
        }
       Set<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x);
        }

        while(set.contains(ans)){
            ans++;
        }
        return ans;
    }
}