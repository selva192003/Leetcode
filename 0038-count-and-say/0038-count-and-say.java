public class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";

        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = getNext(result);
        }
        return result;
    }

    private String getNext(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char prev = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == prev) {
                count++;
            } else {
                sb.append(count).append(prev);
                count = 1;
                prev = curr;
            }
        }

        sb.append(count).append(prev); // append the last group
        return sb.toString();
    }

    // Optional: You can include a main method to run it independently
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 4;
        System.out.println("Count and Say for n = " + n + ": " + sol.countAndSay(n));
    }
}
