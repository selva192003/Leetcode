import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int nSquared = n * n;

        // Queue to store (current_square, moves)
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0}); // Start at square 1 with 0 moves

        // Set to keep track of visited squares
        Set<Integer> visited = new HashSet<>();
        visited.add(1);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currSquare = current[0];
            int moves = current[1];

            if (currSquare == nSquared) {
                return moves; // Reached the destination
            }

            // Simulate dice rolls (1 to 6)
            for (int i = 1; i <= 6; i++) {
                int nextSquare = currSquare + i;

                // If the next square is beyond the board, stop
                if (nextSquare > nSquared) {
                    break;
                }

                // Get (row, col) for the nextSquare
                int[] coords = getCoordinates(nextSquare, n);
                int r = coords[0];
                int c = coords[1];

                int actualDestination;
                // Check if there's a snake or ladder at board[r][c]
                if (board[r][c] != -1) {
                    actualDestination = board[r][c]; // Follow snake/ladder
                } else {
                    actualDestination = nextSquare; // Move to nextSquare directly
                }

                // If this actual destination hasn't been visited, add to queue
                if (!visited.contains(actualDestination)) {
                    visited.add(actualDestination);
                    queue.offer(new int[]{actualDestination, moves + 1});
                }
            }
        }

        return -1; // If nSquared is not reachable
    }

    // Helper function to convert a 1-indexed square number to (row, col)
    private int[] getCoordinates(int s, int n) {
        // s is 1-indexed
        int rOffset = (s - 1) / n;
        int row = n - 1 - rOffset; // Rows are counted from top to bottom

        int col;
        // Check if it's an even row from the bottom (left-to-right traversal)
        // or an odd row from the bottom (right-to-left traversal)
        if (rOffset % 2 == 0) {
            col = (s - 1) % n; // Left-to-right
        } else {
            col = n - 1 - ((s - 1) % n); // Right-to-left
        }
        return new int[]{row, col};
    }
}