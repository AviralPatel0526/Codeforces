import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * B_Not_Dividing
 */
public class B_Not_Dividing {

    public static void main(String[] args) throws java.lang.Exception {
        FastWriter out = new FastWriter();
        int t = in.nextInt();
    
        while (t != 0) {
            t--;
            int n=in.nextInt();
            long a[]=al(n);
            for(int i=0;i<n;i++){
                if(a[i] == 1){
                    a[i]+=1;
                }
            }
            for(int i=0;i<n-1;i++){
                if(a[i+1]%a[i] == 0){
                    a[i+1]+=1;
                }
            }
            for(int i=0;i<n;i++){
                out.print(a[i]+" ");
            }
            out.println("");
        }
        out.close();
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