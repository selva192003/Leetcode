class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num%2!=0) return false;
       int n=num/2;
       int ans=0;
       for(int i=1;i<n;i++){
        if(num%i==0){
            ans+=i;
        }
       }
       ans=ans+n;
       if(ans==num) return true;
       else return false;
    }
}