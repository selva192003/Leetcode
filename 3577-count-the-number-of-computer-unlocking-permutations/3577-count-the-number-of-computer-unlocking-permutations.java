class Solution {
    static final int MOD=1000000007;
    public int countPermutations(int[] comp) {
        int n = comp.length;

        for (int i = 1; i < n; i++) {
            if (comp[i] <= comp[0]) {
                return 0; 
            }
        }

        long ans = 1;
        for (int i = 2; i <= n-1; i++) {
            ans = (ans*i)%MOD;
        }

        return (int) ans;
    }
}
