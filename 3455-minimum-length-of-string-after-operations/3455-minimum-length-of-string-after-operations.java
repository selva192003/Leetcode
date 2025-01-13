class Solution {

    public int minimumLength(String s) {
        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char currentChar : s.toCharArray()) {
            charFrequencyMap.put(
                currentChar,
                charFrequencyMap.getOrDefault(currentChar, 0) + 1
            );
        }
        int deleteCount = 0;
        for (int frequency : charFrequencyMap.values()) {
            if (frequency % 2 == 1) {
                deleteCount += frequency - 1;
            } else {
                deleteCount += frequency - 2;
            }
        }
        return s.length() - deleteCount;
    }
}