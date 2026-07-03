class Solution {

    public static String findcount(String str) {
        int count = 1;
        char el = str.charAt(0);
        String ans = "";

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == el) {
                count++;
            } else {
                ans += String.valueOf(count);
                ans += el;

                count = 1;
                el = str.charAt(i);
            }
        }

        // Append the last group
        ans += String.valueOf(count);
        ans += el;

        return ans;
    }

    public String countAndSay(int n) {
        String ans = "1";

        for (int i = 1; i < n; i++) {
            ans = findcount(ans);
        }

        return ans;
    }
}