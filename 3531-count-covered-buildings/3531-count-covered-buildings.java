class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        // Step 1: Arrays to track min/max on rows and columns
        int[] leftMost = new int[n + 1];
        int[] rightMost = new int[n + 1];
        int[] topMost = new int[n + 1];
        int[] bottomMost = new int[n + 1];

        // Fill min arrays with very large numbers
        Arrays.fill(leftMost, n + 1);
        Arrays.fill(topMost, n + 1);

        // Step 2: Collect row and column info
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            // Row information (horizontal)
            leftMost[y] = Math.min(leftMost[y], x);
            rightMost[y] = Math.max(rightMost[y], x);

            // Column information (vertical)
            topMost[x] = Math.min(topMost[x], y);
            bottomMost[x] = Math.max(bottomMost[x], y);
        }

        // Step 3: Count covered buildings
        int covered = 0;

        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            if (x > leftMost[y] && x < rightMost[y] && 
                y > topMost[x] && y < bottomMost[x]) {
                covered++;
            }
        }

        return covered;
    }
}
