class Solution {
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length];
        int count = 0;
        int i = 0;

        for (String word : words) {
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                count++;
            }
            prefix[i++] = count;
        }

        int[] result = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            int l = queries[j][0];
            int r = queries[j][1];

            if (l == 0) {
                result[j] = prefix[r];
            } else {
                result[j] = prefix[r] - prefix[l - 1];
            }
        }

        return result;
    }
}
