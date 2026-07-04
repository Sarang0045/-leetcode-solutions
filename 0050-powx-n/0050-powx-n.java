class Solution {
    public double myPow(double x, int n) {

        long power = n;
        double ans = 1.0;

        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        while (power > 0) {

            if ((power & 1) == 1) {
                ans *= x;
            }

            x *= x;
            power >>= 1;
        }

        return ans;
    }
}