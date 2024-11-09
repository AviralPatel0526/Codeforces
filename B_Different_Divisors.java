import java.util.*;
import java.lang.*;
import java.io.*;
public class B_Different_Divisors {

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
    public static ArrayList<Integer> generatePrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= limit; p++) {
            if (isPrime[p]) {
                for (int multiple = p * p; multiple <= limit; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
        }

        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static int lowerBound(ArrayList<Integer> list, int target) {
        int index = Collections.binarySearch(list, target);
        if (index < 0) {
            index = -index - 1;
        }
        return index;
    }

    public static void main(String[] args) {
        int t = in.nextInt();
        ArrayList<Integer> primesList = generatePrimes(200000);

        while (t-- > 0) {
            int n = in.nextInt();
            int secondPrime = primesList.get(lowerBound(primesList, n + 1));
            int thirdPrime = primesList.get(lowerBound(primesList,secondPrime+n));
            System.out.println(secondPrime * thirdPrime);
        }

    }
}