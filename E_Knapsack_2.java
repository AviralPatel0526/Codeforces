import java.util.*;
import java.lang.*;
import java.io.*;
public class E_Knapsack_2 {

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
    static long f(int i, int sum, int[][] a, long[][] dp) {
        // Base case: if the required sum is <= 0, no weight is needed.
        if (sum <= 0) {
            return 0;
        }
        // Base case: if all items have been considered and sum > 0, return "infinity" (impossible).
        if (i == a.length) {
            return Long.MAX_VALUE;
        }
        // If result is already computed for this state, return it.
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }
        
        // Option 1: Skip the current item.
        long skip = f(i + 1, sum, a, dp);
        
        // Option 2: Pick the current item.
        long temp = f(i + 1, sum - a[i][1], a, dp);
        long pick;
        // Check if the recursive call returned Long.MAX_VALUE (impossible scenario)
        if (temp == Long.MAX_VALUE) {
            pick = Long.MAX_VALUE;
        } else {
            pick = a[i][0] + temp;
        }
        
        // Store and return the minimum weight required between picking and skipping.
        return dp[i][sum] = Math.min(pick, skip);
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);  // Scanner initialization
        
        // Read number of items and knapsack capacity.
        int n = in.nextInt();
        long w = in.nextLong();
        
        // a[i][0] will hold the weight, a[i][1] will hold the value of the i-th item.
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = in.nextInt();  // weight
            a[i][1] = in.nextInt();  // value
        }
        
        // dp[i][sum] represents the minimum weight needed to achieve 'sum' value using items from index i onward.
        long[][] dp = new long[n][100001];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        int ans = 0;
        // Iterate from the maximum possible value (100000) downwards to find the highest achievable value 
        // within weight limit 'w'.
        for (int i = 100000; i >= 0; i--) {
            if (f(0, i, a, dp) <= w) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}