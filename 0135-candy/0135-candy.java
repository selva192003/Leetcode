import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) {
            return 0;
        }

        int[] candies = new int[n];
        // Initialize each child with at least one candy
        Arrays.fill(candies, 1);

        // Left-to-right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right-to-left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // Take the maximum to satisfy both neighbor conditions
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Calculate the total number of candies
        long totalCandies = 0; // Use long to avoid potential overflow for very large n
        for (int candy : candies) {
            totalCandies += candy;
        }

        return (int) totalCandies;
    }
}