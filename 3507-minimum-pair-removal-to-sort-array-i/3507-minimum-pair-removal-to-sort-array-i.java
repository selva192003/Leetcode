class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int x:nums){
            list.add(x);
        }
        int ans=0;

        while(!isNonDecreasing(list)){
            int idx=0;
            int max=Integer.MAX_VALUE;
            for(int i=0;i<list.size()-1;i++){
                if(list.get(i)+list.get(i+1)<max){
                    max=list.get(i)+list.get(i+1);
                    idx=i;
                }
            }
            list.set(idx,max);
            list.remove(idx+1);
            ans++;
        }
        return ans;
        
    }
        private boolean isNonDecreasing(List<Integer> list){
            for(int i=1;i<list.size();i++){
                if(list.get(i)<list.get(i-1)){
                    return false;
                }
            }
            return true;
        }
}