class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int [] arr = new int[2];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int val = target -nums[i];
            if(map.containsKey(val) && map.get(val)!=i){
                arr[0] =i;
                arr[1] =map.get(val);
            }
        }
        return arr;
    }
}