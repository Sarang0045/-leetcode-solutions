class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String common = "";
        int length = 0;
        int n = Math.min(strs[0].length(), strs[1].length());

        for (int i = 0; i < n; i++) {
            if (strs[0].charAt(i) == strs[1].charAt(i)) {
                common += strs[0].charAt(i);
                length++;
            } else {
                break;
            }
        }

        for (int i = 2; i < strs.length; i++) {
            length = Math.min(length, strs[i].length());
            common = common.substring(0, length);

            for (int j = 0; j < length; j++) {
                if (strs[i].charAt(j) != common.charAt(j)) {
                    length = j;
                    common = common.substring(0, length);
                    break;
                }
            }
        }

        return common;
    }
}