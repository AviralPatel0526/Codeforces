import java.util.*;
import java.lang.*;
import java.io.*;
public class D_Counting_Pairs {

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
    
    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
    
        while (t-- > 0) {
            int n = in.nextInt();
            long x = in.nextLong();
            long y = in.nextLong();
            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }

            Arrays.sort(a);

            long totalSum = 0;
            for (int i = 0; i < n; i++) {
                totalSum += a[i];
            }

            long ans = 0;

            for (int i = 0; i < n - 1; i++) {
                long remainingSum = totalSum - a[i]; // Sum of elements excluding a[i]

                // Binary search for the smallest index where sum >= x
                int low = i + 1, high = n - 1;
                int validStart = -1;

                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    long sumWithMid = remainingSum - a[mid];
                    if (sumWithMid >= x) {
                        validStart = mid;
                        low = mid + 1;
                    } else {
                        high = mid - 1; // Try to find a smaller index
                    }
                }

                // Binary search for the largest index where sum <= y
                low = i + 1;
                high = n - 1;
                int validEnd = -1;

                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    long sumWithMid = remainingSum - a[mid];
                    if (sumWithMid <= y) {
                        validEnd = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;  // Try to find a larger index
                    }
                }
                if (validStart != -1 && validEnd != -1 && validStart >= validEnd) {
                    ans += (validStart - validEnd + 1);
                }
            }
            System.out.println(ans);

        }
        
    }
}