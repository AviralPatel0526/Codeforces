import java.util.*;
import java.io.*;

public class A_Odd_Divisor {

    static FastReader in = new FastReader();

    public static void main(String[] args) throws java.lang.Exception {
        int t = in.nextInt();
        int n = 10000001;  // Limit for the sieve
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        ArrayList<Integer> oddPrime = new ArrayList<>();

        // Sieve of Eratosthenes to find all odd primes up to n
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                if (i % 2 != 0) {
                    oddPrime.add(i);  // Only add odd primes
                }
                for (int j = 2 * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        while (t-- > 0) {
            long num = in.nextLong();
            boolean hasOddDivisor = false;

            // Check if any odd prime divides the number
            for (int prime : oddPrime) {
                if (num % prime == 0) {
                    hasOddDivisor = true;
                    break;
                }
            }

            if (hasOddDivisor) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
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
}
