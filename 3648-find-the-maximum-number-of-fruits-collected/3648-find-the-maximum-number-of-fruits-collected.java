class Solution {
    int n;
    int[][] memo;

    // row = i, col = j
    int dfs3(int row, int col, int[][] mat) {
        if (row < 0 || col < 0 || row >= n || col >= n) return 0;

        if (memo[row][col] != -1) return memo[row][col];

        int val = mat[row][col];
        int res = 0;

        if (row == col) {
            res = Math.max(res, dfs3(row + 1, col + 1, mat));
        } else if (row - 1 == col) {
            res = Math.max(res, Math.max(
                dfs3(row + 1, col + 1, mat),
                dfs3(row, col + 1, mat)
            ));
        } else {
            res = Math.max(res, Math.max(
                dfs3(row + 1, col + 1, mat),
                Math.max(dfs3(row, col + 1, mat),
                         dfs3(row - 1, col + 1, mat))
            ));
        }

        return memo[row][col] = val + res;
    }

    int dfs2(int row, int col, int[][] mat) {
        if (row < 0 || col < 0 || row >= n || col >= n) return 0;

        if (memo[row][col] != -1) return memo[row][col];

        int val = mat[row][col];
        int res = 0;

        if (row == col) {
            res = Math.max(res, dfs2(row + 1, col + 1, mat));
        } else if (row == col - 1) {
            res = Math.max(res, Math.max(
                dfs2(row + 1, col + 1, mat),
                dfs2(row + 1, col, mat)
            ));
        } else {
            res = Math.max(res, Math.max(
                dfs2(row + 1, col + 1, mat),
                Math.max(dfs2(row + 1, col, mat),
                         dfs2(row + 1, col - 1, mat))
            ));
        }

        return memo[row][col] = val + res;
    }

    public int maxCollectedFruits(int[][] mat) {
        n = mat.length;
        int total = 0;

        memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // child - 1
        // he will eat all diagonal fruits, so set them to 0 
        for (int i = 0; i < n; i++) {
            total += mat[i][i];
            mat[i][i] = 0;
        }

        // child - 2
        total += dfs3(n - 1, 0, mat);
        // child - 3
        total += dfs2(0, n - 1, mat);

        return total;
    }
}