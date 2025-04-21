import java.util.*;

public class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;

        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey();     // x other rabbits with the same color
            int count = entry.getValue(); // how many rabbits gave this answer

            int groupSize = x + 1;
            int groups = (count + groupSize - 1) / groupSize;
            total += groups * groupSize;
        }

        return total;
    }

    // Optional: main method for local testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answers1 = {1, 1, 2};
        System.out.println(solution.numRabbits(answers1)); // Output: 5

        int[] answers2 = {10, 10, 10};
        System.out.println(solution.numRabbits(answers2)); // Output: 11
    }
}
