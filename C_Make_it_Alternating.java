import java.util.*;
import java.lang.*;
import java.io.*;
public class C_Make_it_Alternating {

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
    // input of int array
    static int[] ai(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();
        return arr;
    }
    
    // input of long array
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
    static long mod = 998244353;

    static long factorial(int x) {
        long result = 1;
        for (int i = 1; i <= x; i++) {
            result = (result * i) % mod;
        }
        return result;
    }

    public static void main(String[] args) {
        int t = in.nextInt(); // Number of test cases

        while (t-- > 0) {
            String s = in.next(); // Input string
            int n = s.length();
            long ways = 1; // To store the number of ways
            int k = 0; // Number of blocks

            for (int i = 0; i < n; ) {
                k++;
                int blockLength = 1;

                // Count the length of the current block
                while (i + blockLength < n && s.charAt(i) == s.charAt(i + blockLength)) {
                    blockLength++;
                }

                // Multiply ways by the length of the block
                ways = (ways * blockLength) % mod;

                // Move to the next block
                i += blockLength;
            }

            // Calculate (n-k)! % mod
            long erasePermutations = factorial(n - k);

            // Final answer
            ways = (ways * erasePermutations) % mod;

            System.out.println((n - k) + " " + ways);
        }

    }
}