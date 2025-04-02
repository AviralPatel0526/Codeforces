import java.util.*;

public class E_Dice_Product_3 {
    static final int MOD = 998244353;
    static HashMap<Long, Long> dp; // Changed to Long for large numbers

    static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    static long modInverse(long x, long mod) {
        return modPow(x, mod - 2, mod);
    }

    static long f(long x, long n) {
        if (x == n) return 1;
        if (x > n) return 0;
        if (dp.containsKey(x)) return dp.get(x);

        long ans = 0;
        long inv5 = modInverse(5, MOD);
        for (long i = 2; i <= 6; i++) {
            long next = x * i;
            if (next > n) continue; // Avoid unnecessary recursive calls
            ans = (ans + (inv5 * f(next, n)) % MOD) % MOD;
        }
        dp.put(x, ans);
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        dp = new HashMap<>();
        System.out.println(f(1, n));
    }
}
