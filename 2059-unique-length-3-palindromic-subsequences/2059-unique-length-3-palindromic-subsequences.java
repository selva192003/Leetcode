class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<String> uniquePalindromes = new HashSet<>();

        for (int i = 1; i < s.length() - 1; i++) {
            Set<Character> leftChars = new HashSet<>();
            for (int j = 0; j < i; j++) {
                leftChars.add(s.charAt(j));
            }

            for (int k = i + 1; k < s.length(); k++) {
                if (leftChars.contains(s.charAt(k))) {
                    String palindrome = "" + s.charAt(k) + s.charAt(i) + s.charAt(k);
                    uniquePalindromes.add(palindrome);
                }
            }
        }

        return uniquePalindromes.size();
    }
}
