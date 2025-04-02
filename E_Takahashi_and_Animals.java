import java.util.*;
import java.lang.*;
import java.io.*;

public class E_Takahashi_and_Animals {

    // GCD Method
    static long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    // LCM Method
    static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    // Find Power Method
    static long findPower(long num, long base) {
        if (num < 1 || base <= 1)
            return -1;
        double logResult = Math.log(num) / Math.log(base);
        if (Math.abs(logResult - Math.round(logResult)) < 1e-10) {
            return (long) Math.round(logResult);
        } else {
            return -1;
        }
    }

    // Fast Exponentiation Method using Modular Arithmetic
    static long fastExponentiation(long base, long exp, long mod) {
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

    // Sieve Method
    static boolean[] sieve;

    static void fillSieve(int ssize) {
        sieve = new boolean[ssize + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;
        for (int i = 2; i * i <= ssize; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= ssize; j += i) {
                    sieve[j] = false;
                }
            }
        }
    }

    // Smallest Prime Factor (SPF) Method
    static int[] spf;

    static void fillSpf(int ssize) {
        spf = new int[ssize + 1];
        for (int i = 0; i <= ssize; i++) {
            spf[i] = i;
        }
        for (int i = 2; i * i <= ssize; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= ssize; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
    }

    // Reverse Array Function
    static void reverse(long[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            long temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }

    // Print Array Elements (Space-separated)
    static void aout(long[] arr) {
        StringBuilder sb = new StringBuilder();
        for (long num : arr) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    // Print ArrayList Elements (Space-separated)
    static void lout(ArrayList<Long> list) {
        StringBuilder sb = new StringBuilder();
        for (long num : list) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static FastReader in = new FastReader();

    // Input of int array
    static int[] ai(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        return arr;
    }

    // Input of long array
    static long[] al(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextLong();
        return arr;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static final long INF = Long.MAX_VALUE / 2; // A very large value

    // dp[i][prev][firstPicked] stores the minimum cost from index i onward given
    // these states.
    // Dimensions: i in [0, n], prev in {0, 1}, firstPicked in {0, 1}.
    static long[][][] dp;

    static long f(int i, int prev, int firstPicked, long[] a) {
        int n = a.length;
        if (i == n) {
            // When we reach the end, if the first action was skipped,
            // then we require that the last action (i.e. the previous action) was taken.
            return (firstPicked == 0 && prev == 0) ? INF : 0;
        }
        if (dp[i][prev][firstPicked] != -1) {
            return dp[i][prev][firstPicked];
        }

        long ans = INF;

        // Option 1: pick action i
        // When i==0, picking it sets firstPicked to 1.
        int newFirst = (firstPicked == 1 || i == 0) ? 1 : 0;
        long pick = a[i] + f(i + 1, 1, newFirst, a);
        ans = Math.min(ans, pick);

        // Option 2: skip action i (allowed only if the previous action was picked)
        if (prev == 1) {
            long skip = f(i + 1, 0, firstPicked, a);
            ans = Math.min(ans, skip);
        }

        dp[i][prev][firstPicked] = ans;
        return ans;
    }

    public static void main(String[] args) throws java.lang.Exception {
        int n = in.nextInt();
        long[] a = al(n); // reads the array of costs of size n

        // Initialize dp array with -1
        dp = new long[n + 1][2][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // We run two cases:
        // Case 1: force the first action to be picked.
        long case1 = a[0] + f(1, 1, 1, a);
        // Reset dp array if needed or use separate memo arrays for each case.
        // For simplicity here, we assume our dp works correctly for both calls.
        // Case 2: force the first action to be skipped.
        long case2 = f(1, 0, 0, a);

        System.out.println(Math.min(case1, case2));
    }

}