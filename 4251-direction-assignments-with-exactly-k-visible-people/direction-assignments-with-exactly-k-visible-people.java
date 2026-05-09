class Solution {

    static final long MOD = 1_000_000_007;

    // Computes a^b % MOD
    long power(long a, long b) {

        long ans = 1;

        while (b > 0) {

            // if b is odd
            if (b % 2 == 1) {
                ans = (ans * a) % MOD;
            }

            a = (a * a) % MOD;
            b /= 2;
        }

        return ans;
    }

    public int countVisiblePeople(int n, int pos, int k) {

        long[] fact = new long[n + 1];

        // factorial calculation
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        // C(n-1, k)

        long nFact = fact[n - 1];

        long rFactInverse = power(fact[k], MOD - 2);

        long remainingInverse = power(fact[n - 1 - k], MOD - 2);

        long nCr = nFact * rFactInverse % MOD;

        nCr = nCr * remainingInverse % MOD;

        return (int) ((2 * nCr) % MOD);
    }
}