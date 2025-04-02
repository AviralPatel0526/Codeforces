import java.util.*;
import java.lang.*;
import java.io.*;
public class D_Max_Multiple {

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
        if (num < 1 || base <= 1) return -1;
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
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();
        return arr;
    }
    
    // Input of long array
    static long[] al(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextLong();
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
    static final long MIN_VAL = -1000000000000000000L; // a very small number to represent -infinity

    // f returns the maximum sum possible using elements from index i onward,
    // having already picked 'count' elements with current modulo 'mod'.
    // We must pick exactly targetCount elements and the final modulo should be 0.
    static long f(int i, int count, int mod, int d, int n, int targetCount, long a[], long dp[][][]) {
        // If we've reached the end of the array...
        if(i == n) {
            // Accept only if we have exactly targetCount picks and the modulo is 0.
            return (count == targetCount && mod == 0) ? 0 : MIN_VAL;
        }
        // If state already computed, return it.
        if(dp[i][count][mod] != -1) return dp[i][count][mod];

        // Option 1: Skip the current element.
        long skip = f(i+1, count, mod, d, n, targetCount, a, dp);
        
        // Option 2: Pick the current element if we still need more elements.
        long pick = MIN_VAL;
        if(count < targetCount) {
            // Calculate new modulo after picking a[i].
            int newMod = (mod + (int)(a[i] % d) + d) % d;
            pick = a[i] + f(i+1, count + 1, newMod, d, n, targetCount, a, dp);
        }
        
        dp[i][count][mod] = Math.max(skip, pick);
        return dp[i][count][mod];
    }

    public static void main(String[] args) throws Exception {
        int n = in.nextInt();          // number of elements
        int targetCount = in.nextInt();  // exactly how many elements to pick
        int d = in.nextInt();          // modulo divisor
        long a[] = new long[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextLong();
        }
        
        // Create a DP array with dimensions [n+1][targetCount+1][d]
        long dp[][][] = new long[n+1][targetCount+1][d];
        // Initialize the dp with -1 (meaning uncomputed)
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= targetCount; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        long ans = f(0, 0, 0, d, n, targetCount, a, dp);
        // If the answer is MIN_VAL, then no valid solution exists.
        System.out.println(ans < 0 ? -1 : ans);
    }
}