class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1]; 
        for (int[] shift : shifts) {
            if (shift[2] == 1) {
                diff[shift[0]]++;
                diff[shift[1] + 1]--;
            } else {
                diff[shift[0]]--;
                diff[shift[1] + 1]++;
            }
        }
        for (int i = 1; i <= n; i++) {
            diff[i] += diff[i - 1];
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int count = diff[i] % 26;
            if (count < 0)
                count += 26;

            char curr = (char) ((s.charAt(i) - 'a' + count) % 26 + 'a');
            res.append(curr);
        }

        return res.toString();
    }
}