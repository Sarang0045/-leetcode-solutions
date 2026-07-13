class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int length = 0;

        for (int i = n - 1; i >= 0; i--) {

            // Skip trailing spaces
            if (s.charAt(i) == ' ' && length == 0) {
                continue;
            }

            // Stop after the last word ends
            if (s.charAt(i) == ' ') {
                break;
            }

            // Count characters of the last word
            length++;
        }

        return length;
    }
}