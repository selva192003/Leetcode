class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n=words.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
               if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])){
                    cnt++;
                }
            }
        }
        return cnt;      
    }
}