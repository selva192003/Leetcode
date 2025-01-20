class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] rowTally = new int[rows];
        int[] colTally = new int[cols];

        Map<Integer, int[]> nums = new HashMap<>();

        for(int r = 0; r < rows; r++)
            for(int c = 0; c < cols; c++) {
                nums.put(mat[r][c], new int[]{r, c});
            }
        
        for(int i = 0; i < arr.length; i++) {
            int[] curr = nums.get(arr[i]);

            rowTally[curr[0]]++;
            if(rowTally[curr[0]] == cols)
                return i;

            colTally[curr[1]]++;
            if(colTally[curr[1]] == rows)
                return i;
        }

        return arr.length - 1;
    }
}