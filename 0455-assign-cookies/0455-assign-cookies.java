import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {

        // Sort children's greed factors
        Arrays.sort(g);

        // Sort cookie sizes
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;

        // Check children and cookies
        while (child < g.length && cookie < s.length) {

            // Cookie can satisfy the current child
            if (s[cookie] >= g[child]) {

                child++;   // Child is satisfied
                cookie++;  // Cookie is used
            }

            // Cookie is too small
            else {
                cookie++;  // Try the next larger cookie
            }
        }

        // Number of satisfied children
        return child;
    }
}