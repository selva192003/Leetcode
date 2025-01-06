class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int sum = 0;
        int rightOnes = 0;
        for (int i = 0; i < n; ++i) {
            if (boxes.charAt(i) == '1') {
                sum += i;
                rightOnes++;
            }
        }
        int[] res = new int[n];
        int prefixSum = 0;
        int leftOnes = 0;
        
        for (int i = 0; i < n; ++i) {
            int moves = sum + prefixSum;
            res[i] = moves;
            if (boxes.charAt(i) == '1') {
                leftOnes++;
                rightOnes--;
            }
            prefixSum += leftOnes;
            sum -= rightOnes;
        }
        
        return res;
    }
}