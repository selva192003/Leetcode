class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        // dp[i][j] = max dot product using nums1[0..i-1] and nums2[0..j-1]
        int[][] dp = new int[n + 1][m + 1];

        // Initialize with very small value to ensure non-empty subsequence
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MIN_VALUE / 2;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int product = nums1[i - 1] * nums2[j - 1];

                dp[i][j] = Math.max(
                    product,                         // start new subsequence
                    product + dp[i - 1][j - 1]       // extend subsequence
                );

                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]); // skip nums1
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]); // skip nums2
            }
        }

        return dp[n][m];
    }
}
