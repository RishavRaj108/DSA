class Solution {

    static final long MOD = 1_000_000_007;

    // Fast Power
    long power(long a, long b) {
        long result = 1;

        while (b > 0) {
            // If current bit is 1
            if ((b & 1) == 1) {
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return result;
    }

    public int countVisiblePeople(int n, int pos, int k) {
        // Impossible case
        if (k > n - 1) return 0;
        // factorial[i] = i!
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        /*
            Compute:
            C(n-1, k)
            Formula:
            n! / (k! * (n-k)!)
        */

        long numerator = factorial[n - 1];
        // inverse(k!)
        long inverseK = power(factorial[k], MOD - 2);

        // inverse((n-1-k)!)
        long inverseRemaining =  power(factorial[n - 1 - k], MOD - 2);

        long combinations = numerator * inverseK % MOD;
        combinations = combinations * inverseRemaining % MOD;

        // multiply by 2 because pos person is free
        long answer = (2 * combinations) % MOD;
        return (int) answer;
    }
}