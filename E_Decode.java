import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * E_Decode
 */
public class E_Decode {

    public static void main(String[] args) throws Exception {
        FastWriter out = new FastWriter();
        int t = in.nextInt();
        int MOD=1000000007;
        while (t-- > 0) {
            String s = in.next();
            LinkedList<Integer> a = new LinkedList<>();
            LinkedList<Integer> b = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '0') {
                    a.add(-1);
                    b.add(-1);
                } else {
                    a.add(1);
                    b.add(1);
                }
            }
            long totalCount = 0;
            totalCount = (totalCount + countSubarraysWithSumZero(a)) % MOD;
            a.removeFirst();
            b.removeLast();
            for (int i = 1; i < s.length(); i++) {
                totalCount = (totalCount + countSubarraysWithSumZero(a)*2) % MOD;
                a.removeFirst();
            }
            for (int i = 1; i < s.length(); i++) {
                totalCount = (totalCount + countSubarraysWithSumZero(b)*2) % MOD;
                b.removeLast();
            }
            out.println(totalCount);
        }
        out.close();
    }

    private static int countSubarraysWithSumZero(LinkedList<Integer> a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        
        // Initialize with sum 0 seen once
        map.put(0, 1);
        
        for (int value : a) {
            sum += value;
            
            if (map.containsKey(sum)) {
                count += map.get(sum);
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        
        return count;
    }
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
    
    // Power Calculation Method
    static long pow(long base, int exp) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result *= base;
            }
            base *= base;
            exp /= 2;
        }
        return result;
    }
    
    // Sieve of Eratosthenes Method
    static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
    
    // Prime Factorization Method using Smallest Prime Factor (SPF)
    public static List<Long> primeFactorization(long number) {
        int max = (int)Math.sqrt(number) + 1;
        long[] spf = new long[max];
        Arrays.fill(spf, -1);
        for (int i = 2; i < max; i++) {
            if (spf[i] == -1) {
                for (int j = i; j < max; j += i) {
                    if (spf[j] == -1) {
                        spf[j] = i;
                    }
                }
            }
        }
    
        List<Long> primeFactors = new ArrayList<>();
        while (number > 1) {
            if (number < max && spf[(int)number] != -1) {
                primeFactors.add(spf[(int)number]);
                number /= spf[(int)number];
            } else {
                boolean found = false;
                for (int i = 2; i < max; i++) {
                    if (number % i == 0) {
                        primeFactors.add((long)i);
                        number /= i;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    primeFactors.add(number);
                    break;
                }
            }
        }
    
        return primeFactors;
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
    
    // get array max
    static int aMax(int[] arr) {
        int a = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) a = Math.max(a, arr[i]);
        return a;
    }
    
    // get array min
    static int aMin(int[] arr) {
        int a = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) a = Math.min(a, arr[i]);
        return a;
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
    
    static class FastWriter {
        private final BufferedWriter bw;
    
        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
    
        public void print(Object object) throws IOException {
            bw.append("").append(String.valueOf(object));
        }
    
        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }
    
        public void close() throws IOException {
            bw.close();
        }
        }
    
    static class Pair {
        long f;
        long s;
        public Pair(long first, long second) {
            this.f = first;
            this.s = second;
        }
    }
    
    static class Triplet {
        long f;
        long s;
        long t;
        public Triplet(long first, long second, long third) {
            this.f = first;
            this.s = second;
            this.t = third;
        }
    }
}