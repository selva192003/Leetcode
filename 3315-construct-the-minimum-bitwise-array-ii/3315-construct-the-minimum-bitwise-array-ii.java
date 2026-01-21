class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans=new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            int target=nums.get(i);
            int answer=-1;
            int bitmask=1;
            while((target & bitmask) !=0){
                answer = target - bitmask;
                bitmask<<=1;
            }
        ans[i]=answer;
        }
        return ans;
    }
}