class Solution {
    public void reverseString(char[] s) {
        int left=0;
        int right=s.length-1;
        char temp='0';

        while(left<right){
            temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            right--; left++;
        }
    }
}